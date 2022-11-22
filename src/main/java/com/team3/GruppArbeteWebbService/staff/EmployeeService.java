package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));

        return employees;
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).get();

    }

    public void saveOrUpdate(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(long id){
        employeeRepository.deleteById(id);
    }
}
