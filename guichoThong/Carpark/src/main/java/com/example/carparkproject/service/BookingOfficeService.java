package com.example.carparkproject.service;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.entity.BookingOffice;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.mapper.BookingOfficeMapper;
import com.example.carparkproject.repository.BookingOfficeRepository;
import com.example.carparkproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookingOfficeService {

    @Autowired
    private BookingOfficeMapper bookingOfficeMapper;

    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    @Autowired
    private TripRepository tripRepository;

    public Page<BookingOfficeDTO> getListBookingOffice(String officeName, String tripName, Pageable pageable) {
        return bookingOfficeRepository.getListBookingOffice(officeName,tripName,pageable);
    }


    public BookingOfficeDTO getBookingOfficeDetail(Long id) {
        BookingOfficeDTO bookingOfficeDTO = bookingOfficeRepository.getDetailBookingOfficeWithDestination(id);
        if(bookingOfficeDTO == null){
            throw new RuntimeException("this id doesn't exist");
        }

        return bookingOfficeDTO;
    }

    public void createBookingOffice(BookingOfficeDTO bookingOfficeDTO) {
        bookingOfficeDTO.setOfficeId(null);
        if(bookingOfficeDTO.getTripId() != null){
            Trip trip = tripRepository.findTripByTripId(bookingOfficeDTO.getTripId());
            if(trip == null){
                throw new RuntimeException("This trip doesn't exist");
            }
        }
        BookingOffice bookingOffice = bookingOfficeMapper.toEntity(bookingOfficeDTO);
        bookingOfficeRepository.save(bookingOffice);
    }


}
