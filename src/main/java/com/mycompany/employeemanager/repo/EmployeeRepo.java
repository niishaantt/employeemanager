package com.mycompany.employeemanager.repo;

import com.mycompany.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
//Query method in spring: Where spring automatically detects the query required by the name we give fro the method
    Optional<Employee> findEmployeeById(Long id);
}
