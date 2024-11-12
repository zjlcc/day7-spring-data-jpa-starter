package com.oocl.springbootemployee.controller;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private Integer id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company(Integer id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company() {}

    public Company(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
