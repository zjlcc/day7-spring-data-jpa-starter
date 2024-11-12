package com.oocl.springbootemployee.repository;

import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;

import java.util.List;

public class MockedEmployeeRepository implements IEmployeeRepository{

    private List<Employee> employees = null;

    public void whenGetAllReturn(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public List<Employee> getEmployeesByGender(Gender gender) {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        return null;
    }

    @Override
    public void removeEmployee(Integer id) {

    }

    @Override
    public List<Employee> getAllByPageSize(Integer pageIndex, Integer pageSize) {
        return null;
    }
}
