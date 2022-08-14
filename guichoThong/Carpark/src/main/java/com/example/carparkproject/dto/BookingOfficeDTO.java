package com.example.carparkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeDTO {

    private Long officeId;

    private String endContractDeadline;

    @NotBlank(groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    @Length(max = 50, groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    private String officeName;

    @NotBlank(groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    @Length(max = 11, groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    private String officePhone;

    @NotBlank(groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    @Length(max = 50, groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    private String officePlace;

    @NotNull(groups = {BookingOfficeDTO.Create.class,BookingOfficeDTO.Update.class})
    private Long officePrice;

    private String startContractDeadline;

    private Long tripId;

    private String destination;

    public BookingOfficeDTO(Long officeId, String endContractDeadline, String officeName, String officePhone, String officePlace, Long officePrice, String startContractDeadline, String destination) {
        this.officeId = officeId;
        this.endContractDeadline = endContractDeadline;
        this.officeName = officeName;
        this.officePhone = officePhone;
        this.officePlace = officePlace;
        this.officePrice = officePrice;
        this.startContractDeadline = startContractDeadline;
        this.destination = destination;
    }

    public interface Create{}

    public interface Update{}
}
