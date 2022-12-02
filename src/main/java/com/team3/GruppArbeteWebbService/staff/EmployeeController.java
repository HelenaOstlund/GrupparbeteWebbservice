package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }


    @GetMapping("/employee")
    private ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        return employeeServiceImpl.getEmployeeById(id);
    }
/*
    @GetMapping("/employees/{id}/teams")
    private ResponseEntity<List<Team>> getAllTeamsByEmployee(@PathVariable("id") long id) {
        return employeeServiceImpl.getAllTeamsByEmployee(id);
    }
 */
    @PostMapping("/addEmployee")
    private ResponseEntity<Employee> saveEmployee(@RequestBody final Employee employee) {
        return employeeServiceImpl.saveEmployee(employee);
    }

    @PostMapping("/teams/{id}/employee")
    private ResponseEntity<Employee> saveEmployeeToTeam(@PathVariable(value = "id") long id, @RequestBody final Employee employeeRequest) {
        return employeeServiceImpl.addEmployeeToTeam(id, employeeRequest);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    private ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        return employeeServiceImpl.deleteEmployee(id);
    }


    @PutMapping("/updateEmployee/{id}")
    private ResponseEntity<Employee> updateEmployee(@RequestBody final Employee employee, @PathVariable("id") long id) {
        return employeeServiceImpl.editEmployee(employee, id);
    }

    @PatchMapping("/editEmployee/{id}")
    private ResponseEntity<Employee> editEmployee(@RequestBody final Employee employee, @PathVariable("id") long id) {
        return employeeServiceImpl.editEmployee(employee, id);
    }
}
