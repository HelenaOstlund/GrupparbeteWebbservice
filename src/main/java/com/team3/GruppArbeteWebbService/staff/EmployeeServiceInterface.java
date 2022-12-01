package com.team3.GruppArbeteWebbService.staff;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//interface ökar säkerheten
@Service
public interface EmployeeServiceInterface {


    //TODO - abstract queries

    ResponseEntity<Employee>getEmployeeId(long id);
    ResponseEntity<List<Employee>> getAllEmployees();
    ResponseEntity<Employee> saveEmployee(Employee employee);
    ResponseEntity<Employee> deleteEmployee(long id);
    ResponseEntity<Employee> editEmployee(Employee employee, long id);


}
