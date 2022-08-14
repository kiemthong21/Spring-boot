package com.example.carparkproject.repository;

import com.example.carparkproject.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE (:name is null or e.employeeName like %:name%) " +
            "AND (:dateOfBirth is null or e.employeeBirthdate like %:dateOfBirth%) " +
            "AND (:address is null or e.employeeAddress like %:address%) " +
            "AND (:phoneNumber is null or e.employeePhone like %:phoneNumber%)" +
            "AND (:department is null or e.department like %:department%)")
    Page<Employee> getListEmployee(@Param("name") String name,
                                   @Param("dateOfBirth") String dateOfBirth,
                                   @Param("address") String address,
                                   @Param("phoneNumber") String phoneNumber,
                                   @Param("department") String department,
                                   Pageable pageable);

    Employee findEmployeeByEmployeeId(Long id);

    Employee findEmployeeByAccount(String account);
}
