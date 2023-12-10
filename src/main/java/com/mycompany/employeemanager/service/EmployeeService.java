package com.mycompany.employeemanager.service;

import com.mycompany.employeemanager.exception.UserNotFoundException;
import com.mycompany.employeemanager.model.Employee;
import com.mycompany.employeemanager.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){

        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return  employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id){
        return  employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id "+ id+ " was not found"));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
