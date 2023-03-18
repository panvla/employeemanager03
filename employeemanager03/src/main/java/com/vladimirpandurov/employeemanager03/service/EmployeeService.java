package com.vladimirpandurov.employeemanager03.service;

import com.vladimirpandurov.employeemanager03.domain.Employee;
import com.vladimirpandurov.employeemanager03.exception.UserNotFoundException;
import com.vladimirpandurov.employeemanager03.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id){
        return this.employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + " was not found"));
    }

    public List<Employee> findAll(){
        return this.employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployeee(Long id){
        this.employeeRepository.deleteEmployeesById(id);
    }

}
