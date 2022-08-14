package com.example.carparkproject.service;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.entity.Employee;
import com.example.carparkproject.mapper.EmployeeMapper;
import com.example.carparkproject.repository.EmployeeRepository;
import com.example.carparkproject.security.EmployeeDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority(\"" + "HRM" + "\")")
    public Page<EmployeeDTO> getListEmployee(String name, String dateOfBirth, String address, String phoneNumber, String department, Pageable pageable) {
        return employeeRepository.getListEmployee(name,dateOfBirth,address,phoneNumber,department,pageable).map(employee -> employeeMapper.toDto(employee));
    }

    public EmployeeDTO getDetailEmployee(Long id) {
        Employee employee = employeeRepository.findEmployeeByEmployeeId(id);
        return employeeMapper.toDto(employee);
    }


    public void createEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeId(null);
        Employee employee = employeeRepository.findEmployeeByAccount(employeeDTO.getAccount());
        if(employee != null){
            throw new RuntimeException("this account is already exist");
        }
        employeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        Employee employeeDB = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employeeDB);
    }

    public void updateEmployee(EmployeeDTO employeeDTO,Long id) {
        Employee employeeDb = employeeRepository.findEmployeeByEmployeeId(id);
        if(employeeDb == null){
            throw new RuntimeException("This employee doesn't exist");
        }
        employeeDTO.setEmployeeId(id);
        if(!employeeDb.getAccount().equals(employeeDTO.getAccount())) {
            Employee employee = employeeRepository.findEmployeeByAccount(employeeDTO.getAccount());
            if (employee != null) {
                throw new RuntimeException("this account is already exist");
            }
        }

        employeeDTO.setPassword(employeeDb.getPassword());
        Employee newEmployee = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(newEmployee);
    }


    public void deleteEmployee(Long id) {
        Employee employeeDb = employeeRepository.findEmployeeByEmployeeId(id);
        if(employeeDb == null){
            throw new RuntimeException("This employee doesn't exist");
        }
        employeeRepository.delete(employeeDb);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByAccount(username);
        if(employee == null){
            throw new RuntimeException("employee not found");
        }
        return new EmployeeDetailsImpl(employee);
    }


}
