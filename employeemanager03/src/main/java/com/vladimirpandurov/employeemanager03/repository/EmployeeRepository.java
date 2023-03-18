package com.vladimirpandurov.employeemanager03.repository;

import com.vladimirpandurov.employeemanager03.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);
    void deleteEmployeesById(Long id);

}
