package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.controller.Employee;
import com.oocl.springbootemployee.controller.EmployeeRepository;
import com.oocl.springbootemployee.controller.Gender;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTest {
    @Test
    void should_return_the_given_employees_when_getAllEmployees() {
        //given
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee lucy = new Employee(6, "Lucy", 18, Gender.FEMALE, 8000.0);
        employeeRepository.addEmployee(lucy);
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        //when
        List<Employee> allEmployees = employeeService.getAllEmployees();

        //then
        assertEquals(6, allEmployees.size());
        assertEquals("Lucy", allEmployees.get(5).getName());
    }

    @Test
    void should_return_the_created_employee_when_create_given_a_employee() {
        //given
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee lucy = new Employee(6, "Lucy", 18, Gender.FEMALE, 8000.0);
        //when
        Employee createdEmployee = employeeService.creat(lucy);
        //then
        assertEquals("Lucy", createdEmployee.getName());
    }
}
