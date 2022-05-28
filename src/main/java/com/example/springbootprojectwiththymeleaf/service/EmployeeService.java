package com.example.springbootprojectwiththymeleaf.service;

import com.example.springbootprojectwiththymeleaf.crudEntity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findEmployeeById(int employeeId);

    public void saveEmployee(Employee employee);

    public void deleteEmployeeByID(int employeeId);
}
