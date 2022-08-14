package com.example.carparkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private Long ticketId;

    private String bookingTime;

    @NotBlank(groups = {TicketDTO.Create.class, TicketDTO.Update.class})
    @Length(max = 11, groups = {TicketDTO.Create.class, TicketDTO.Update.class})
    private String customerName;

    @NotBlank(groups = {TicketDTO.Create.class, TicketDTO.Update.class})
    @Length(max = 50, groups = {TicketDTO.Create.class, TicketDTO.Update.class})
    private String licensePlate;

    private Long tripId;

    private String destination;

    public TicketDTO(Long ticketId, String bookingTime, String customerName, String licensePlate, String destination) {
        this.ticketId = ticketId;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.destination = destination;
    }

    public interface Create {
    }

    public interface Update {
    }
}
