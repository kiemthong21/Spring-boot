package com.example.carparkproject.service;

import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.entity.BookingOffice;
import com.example.carparkproject.entity.Ticket;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.mapper.TripMapper;
import com.example.carparkproject.repository.BookingOfficeRepository;
import com.example.carparkproject.repository.TicketRepository;
import com.example.carparkproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    public Page<TripDTO> getListTrip(String destination, String departureTime, String driver, String carType, String bookedTicketNumber, Pageable pageable) {
        return tripRepository.getListTrip(destination, departureTime, driver, carType, bookedTicketNumber, pageable).map(trip -> tripMapper.toDto(trip));
    }

    public TripDTO getTripDetail(Long id) {
        Trip trip = tripRepository.findTripByTripId(id);
        if (trip == null) {
            throw new RuntimeException("This trip doesn't exist");
        }
        return tripMapper.toDto(trip);
    }

    public void createTrip(TripDTO tripDTO) {
        tripDTO.setTripId(null);
        Trip trip = tripMapper.toEntity(tripDTO);
        tripRepository.save(trip);
    }

    public void updateTrip(TripDTO tripDTO, Long id) {
        tripDTO.setTripId(id);
        Trip trip = tripRepository.findTripByTripId(id);
        if (trip == null) {
            throw new RuntimeException("This trip doesn't exist");
        }
        Trip newTrip = tripMapper.toEntity(tripDTO);
        tripRepository.save(newTrip);
    }

    public void deleteTrip(Long id) {
        Trip trip = tripRepository.findTripByTripId(id);
        if (trip == null) {
            throw new RuntimeException("This trip doesn't exist");
        }

        List<Ticket> tickets = ticketRepository.findAllByTripId(id);
        List<BookingOffice> bookingOffices = bookingOfficeRepository.findAllByTripId(id);

        if(!CollectionUtils.isEmpty(tickets) || !CollectionUtils.isEmpty(bookingOffices)){
            throw new RuntimeException("This trip have been used in some object");
        }

        tripRepository.delete(trip);
    }
}
