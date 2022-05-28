package com.example.springbootprojectwiththymeleaf.employeeDAO;

import com.example.springbootprojectwiththymeleaf.crudEntity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();
}
