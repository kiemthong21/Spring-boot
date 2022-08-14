package com.example.carparkproject.mapper;

import com.example.carparkproject.dto.TicketDTO;
import com.example.carparkproject.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityMapper<Ticket, TicketDTO>{
    Ticket toEntity(TicketDTO ticketDTO);

    TicketDTO toDto(Ticket ticket);
}
