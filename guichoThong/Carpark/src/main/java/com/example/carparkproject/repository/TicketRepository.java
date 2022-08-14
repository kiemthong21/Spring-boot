package com.example.carparkproject.repository;

import com.example.carparkproject.dto.TicketDTO;
import com.example.carparkproject.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query("SELECT new com.example.carparkproject.dto.TicketDTO(t.ticketId,t.bookingTime,t.customerName," +
            "t.licensePlate,tr.destination)" +
            " FROM Ticket t LEFT JOIN Trip tr ON t.tripId = tr.tripId " +
            "JOIN Car c ON t.licensePlate = c.licensePlate " +
            "WHERE (tr.destination is null or tr.destination like %:destination%) " +
            "AND (:licensePlate is null or t.licensePlate like %:licensePlate%)" +
            "AND (:customer is null or t.customerName like %:customer%)" +
            "AND (:bookingTime is null or t.bookingTime like %:bookingTime%)")

    Page<TicketDTO> getListTicket(@Param("destination") String destination,
                                  @Param("licensePlate")String licensePlate,
                                  @Param("customer")String customer,
                                  @Param("bookingTime")String bookingTime,
                                  Pageable pageable);



    @Query("SELECT new com.example.carparkproject.dto.TicketDTO(t.ticketId,t.bookingTime,t.customerName," +
            "t.licensePlate,tr.destination)" +
            "FROM Ticket t LEFT JOIN Trip tr ON t.tripId = tr.tripId " +
            "JOIN Car c ON t.licensePlate = c.licensePlate " +
            "WHERE t.ticketId = :id")
    TicketDTO getTicketWithTripName(@Param("id")Long id);

    Ticket findTicketByTicketId(Long id);

    List<Ticket> findAllByLicensePlate(String licensePlate);

    List<Ticket> findAllByTripId(Long tripiD);
}
