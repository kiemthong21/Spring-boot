package com.example.carparkproject.mapper;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.entity.BookingOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingOfficeMapper extends EntityMapper<BookingOffice, BookingOfficeDTO>{

    BookingOffice toEntity(BookingOfficeDTO bookingOfficeDTO);

    BookingOfficeDTO toDto(BookingOffice bookingOffice);

}
