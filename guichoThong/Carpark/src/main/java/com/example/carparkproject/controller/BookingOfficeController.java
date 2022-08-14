package com.example.carparkproject.controller;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.service.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/booking-offices")
public class BookingOfficeController {

    @Autowired
    private BookingOfficeService bookingOfficeService;

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/get-list-booking-offices")
    public ResponseEntity<Page<BookingOfficeDTO>> getListBookingOffice(@RequestParam(required = false, defaultValue = "") String officeName,
                                                                       @RequestParam(required = false, defaultValue = "") String tripName,
                                                                       Pageable pageable) {
        return ResponseEntity.ok().body(bookingOfficeService.getListBookingOffice(officeName, tripName, pageable));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/{id}")
    public ResponseEntity<BookingOfficeDTO> getBookingOfficeDetail(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookingOfficeService.getBookingOfficeDetail(id));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PostMapping("")
    public ResponseEntity<Void> createBookingOffice(@NotNull @Validated(BookingOfficeDTO.Create.class) @RequestBody BookingOfficeDTO bookingOfficeDTO) {
        bookingOfficeService.createBookingOffice(bookingOfficeDTO);
        return ResponseEntity.ok().build();


    }


}
