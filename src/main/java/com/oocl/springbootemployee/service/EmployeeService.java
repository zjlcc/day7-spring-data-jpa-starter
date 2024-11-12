package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.exception.EmployeeAgeNotValidException;
import com.oocl.springbootemployee.exception.EmployeeAgeSalaryNotMatchedException;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAll();
    }

    public Employee creat(Employee employee) {
        if(employee.getAge() < 18 || employee.getAge() > 65)
            throw new EmployeeAgeNotValidException();
        if(employee.getAge() >= 30 && employee.getSalary() < 20000.0)
            throw new EmployeeAgeSalaryNotMatchedException();

        employee.setActive(true);
        return employeeRepository.addEmployee(employee);
    }
}
