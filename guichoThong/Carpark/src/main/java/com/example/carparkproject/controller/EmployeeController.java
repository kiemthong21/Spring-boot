package com.example.carparkproject.controller;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAuthority(\"" + "HRM" + "\")")
    @GetMapping("/get-list-employees")
    public ResponseEntity<Page<EmployeeDTO>> getListEmployee(@RequestParam(required = false,defaultValue = "") String name,
                                                          @RequestParam(required = false,defaultValue = "") String dateOfBirth,
                                                          @RequestParam(required = false,defaultValue = "") String address,
                                                          @RequestParam(required = false,defaultValue = "") String phoneNumber,
                                                          @RequestParam(required = false,defaultValue = "") String department,
                                                          Pageable pageable){
        return ResponseEntity.ok().body(employeeService.getListEmployee(name,dateOfBirth,address,phoneNumber,department,pageable));
    }

    @PreAuthorize("hasAuthority(\"" + "HRM" + "\")")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getDetailEmployee(@NotNull @PathVariable Long id){
        return ResponseEntity.ok().body(employeeService.getDetailEmployee(id));
    }

    @PreAuthorize("hasAuthority(\"" + "HRM" + "\")")
    @PostMapping()
    public ResponseEntity<Void> createEmployee(@RequestBody @NotNull @Validated(EmployeeDTO.Create.class)  EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "HRM" + "\")")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@RequestBody @NotNull @Validated(EmployeeDTO.Update.class) EmployeeDTO employeeDTO,
                                               @NotNull @PathVariable Long id){

        employeeService.updateEmployee(employeeDTO,id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "HRM" + "\")")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@NotNull @PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }



}
