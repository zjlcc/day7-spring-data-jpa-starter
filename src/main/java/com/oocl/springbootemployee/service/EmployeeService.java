package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.controller.Employee;
import com.oocl.springbootemployee.controller.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAll();
    }
}
