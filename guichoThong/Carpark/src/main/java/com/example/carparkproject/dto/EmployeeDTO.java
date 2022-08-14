package com.example.carparkproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDTO {

    private Long employeeId;

    @NotBlank(groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    @Length(max = 50,groups = EmployeeDTO.Create.class)
    private String account;

    @NotBlank(groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    @Length(max = 10,groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    private String department;

    @Length(max = 50,groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    private String employeeAddress;

    private String employeeBirthdate;

    private String employeeEmail;

    @NotBlank(groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    @Length(max = 50,groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    private String employeeName;

    @NotBlank(groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    @Length(max = 10,groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    private String employeePhone;

    @NotBlank(groups = {EmployeeDTO.Create.class,EmployeeDTO.Auth.class})
    @Length(max = 50,groups = {EmployeeDTO.Create.class,EmployeeDTO.Auth.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    @Length(max = 1,groups = {EmployeeDTO.Create.class,EmployeeDTO.Update.class})
    private String sex;

    public interface Create{}

    public interface Update{}

    public interface Auth{}

}
