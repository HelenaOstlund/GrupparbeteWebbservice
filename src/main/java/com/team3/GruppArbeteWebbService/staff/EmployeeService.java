package com.team3.GruppArbeteWebbService.staff;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//interface ökar säkerheten
//@Service
public interface EmployeeService {


    //TODO - abstract queries

    ResponseEntity<Employee>getEmployeeById(long id);
    ResponseEntity<List<Employee>> getAllEmployees();
    ResponseEntity<Employee> addEmployeeToTeam(long teamId, Employee employeeRequest);
    ResponseEntity<Employee> saveEmployee(Employee employee);
    ResponseEntity<List<Team>> getAllTeamsByEmployeeId(Long employeeId);
    ResponseEntity<Employee> deleteEmployee(long id);
    ResponseEntity<Employee> editEmployee(Employee employee, long id);

}
