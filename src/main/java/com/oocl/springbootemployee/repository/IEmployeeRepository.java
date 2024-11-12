package com.oocl.springbootemployee.repository;

import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    Employee findById(Integer id);

    List<Employee> findAllByGender(Gender gender);

    Employee create(Employee employee);

    Employee update(Integer id, Employee employee);

    void deleteById(Integer id);

    List<Employee> findAllByPage(Integer pageIndex, Integer pageSize);
}
