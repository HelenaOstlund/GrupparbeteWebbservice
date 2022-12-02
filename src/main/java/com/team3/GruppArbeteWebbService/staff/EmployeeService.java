package com.team3.GruppArbeteWebbService.staff;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface EmployeeService {

    ResponseEntity<Employee>getEmployeeById(long id);
    ResponseEntity<List<Employee>> getAllEmployees();
    //ResponseEntity<List<Team>> getAllTeamsByEmployee(long id);
    ResponseEntity<Employee> addEmployeeToTeam(long teamId, Employee employeeRequest);
    ResponseEntity<Employee> saveEmployee(Employee employee);
    ResponseEntity<Employee> deleteEmployee(long id);
    ResponseEntity<Employee> editEmployee(Employee employee, long id);

}
