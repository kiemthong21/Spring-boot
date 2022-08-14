package com.fsoft.carpark.repository;

import com.fsoft.carpark.dto.EmployeeDto;
import com.fsoft.carpark.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}