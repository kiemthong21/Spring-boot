package com.example.carparkproject.controller;

import com.example.carparkproject.dto.TicketDTO;
import com.example.carparkproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/get-list-tickets")
    public ResponseEntity<Page<TicketDTO>> getListTicket(@RequestParam(required = false,defaultValue = "")String destination,
                                                         @RequestParam(required = false,defaultValue = "")String licensePlate,
                                                         @RequestParam(required = false,defaultValue = "")String customer,
                                                         @RequestParam(required = false,defaultValue = "")String bookingTime,
                                                         Pageable pageable){
        return ResponseEntity.ok().body(ticketService.getListTicket(destination,licensePlate,customer,bookingTime,pageable));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getDetailTicket(@NotNull @PathVariable Long id){
        return ResponseEntity.ok().body(ticketService.getDetailTicket(id));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PostMapping()
    public ResponseEntity<Void> createTicket(@NotNull @Validated(TicketDTO.Create.class) TicketDTO ticketDTO){
        ticketService.createTicket(ticketDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTicket(@NotNull @Validated(TicketDTO.Create.class) TicketDTO ticketDTO,
                                             @NotNull @PathVariable Long id){
        ticketService.updateTicket(ticketDTO,id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@NotNull @PathVariable Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }



}
