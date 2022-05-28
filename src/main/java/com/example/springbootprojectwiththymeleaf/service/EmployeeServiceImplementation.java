package com.example.springbootprojectwiththymeleaf.service;

import com.example.springbootprojectwiththymeleaf.crudEntity.Employee;
import com.example.springbootprojectwiththymeleaf.employeeDAO.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findEmployeeById(int employeeId) {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Employee employee = null;

        if(employeeOptional.isPresent())
            employee=employeeOptional.get();
        else {
            throw new RuntimeException("Employee by Id " + employeeId + " not present");
        }
        return employee;

    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployeeByID(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
