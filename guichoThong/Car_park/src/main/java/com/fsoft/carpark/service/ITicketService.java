package com.fsoft.carpark.service;

import com.fsoft.carpark.dto.TicketDto;
import com.fsoft.carpark.model.Ticket;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketService {
    //get all tickets
    ResponseEntity<List<TicketDto>> getAllTickets();

    //get ticket by id
    ResponseEntity<TicketDto> getTicketById(Long id);

    //add new ticket
    ResponseEntity<Ticket> addNewTicket(TicketDto tickerDto);

    //delete ticket by id
    ResponseEntity<Map<String, Boolean>> deleteTicketById(Long id);

    //convert Entity to DTO
    TicketDto mapToDto(Ticket ticket);

    //convert DTO to Entity
    Ticket mapToEntity(TicketDto tickerDto);
}
