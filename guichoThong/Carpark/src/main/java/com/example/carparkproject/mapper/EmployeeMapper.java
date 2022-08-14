package com.example.carparkproject.mapper;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDTO> {

    Employee toEntity(EmployeeDTO employeeDTO);

    EmployeeDTO toDto(Employee employee);

}
