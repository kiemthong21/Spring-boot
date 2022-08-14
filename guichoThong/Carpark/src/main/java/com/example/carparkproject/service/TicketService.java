package com.example.carparkproject.service;

import com.example.carparkproject.dto.TicketDTO;
import com.example.carparkproject.entity.Car;
import com.example.carparkproject.entity.Ticket;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.mapper.TicketMapper;
import com.example.carparkproject.repository.CarRepository;
import com.example.carparkproject.repository.TicketRepository;
import com.example.carparkproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TripRepository tripRepository;


    public Page<TicketDTO> getListTicket(String destination, String licensePlate, String customer, String bookingTime, Pageable pageable) {
        return ticketRepository.getListTicket(destination,licensePlate,customer,bookingTime,pageable);
    }

    public TicketDTO getDetailTicket(Long id) {
        Ticket ticket = ticketRepository.findTicketByTicketId(id);
        if(ticket == null){
            throw new RuntimeException("this ticket doesn't exist");
        }
        Car car = carRepository.findCarByLicensePlate(ticket.getLicensePlate());
        if(car == null){
            throw new RuntimeException("this LicensePlate doesn't exist");
        }
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);
        if(ticket.getTripId() != null){
            Trip trip = tripRepository.findTripByTripId(ticket.getTripId());
            if(trip == null){
                throw new RuntimeException("this trip doesn't exist");
            }else{
                ticketDTO.setDestination(trip.getDestination());
            }
        }
        return ticketDTO;
    }

    private void validateTicket(TicketDTO ticketDTO){
        Car car = carRepository.findCarByLicensePlate(ticketDTO.getLicensePlate());
        if(car == null){
            throw new RuntimeException("this LicensePlate doesn't exist");
        }
        if(ticketDTO.getTripId() != null){
            Trip trip = tripRepository.findTripByTripId(ticketDTO.getTripId());
            if(trip == null){
                throw new RuntimeException("this trip doesn't exist");
            }
        }
    }


    public void createTicket(TicketDTO ticketDTO) {
        ticketDTO.setTicketId(null);
        validateTicket(ticketDTO);
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticketRepository.save(ticket);
    }


    public void updateTicket(TicketDTO ticketDTO, Long id) {
        ticketDTO.setTicketId(id);
        Ticket ticket = ticketRepository.findTicketByTicketId(id);
        if(ticket == null){
            throw new RuntimeException("this ticket doesn't exist");
        }
        validateTicket(ticketDTO);
        Ticket newTicket = ticketMapper.toEntity(ticketDTO);
        ticketRepository.save(newTicket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findTicketByTicketId(id);
        if(ticket == null){
            throw new RuntimeException("this ticket doesn't exist");
        }
        ticketRepository.delete(ticket);
    }
}
