package com.fsoft.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsoft.carpark.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}