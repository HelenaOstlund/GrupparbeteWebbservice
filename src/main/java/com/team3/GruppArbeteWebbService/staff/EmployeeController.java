package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor
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

    @GetMapping("/employees/{EmployeeId}/teams")
    public ResponseEntity<List<Team>> getAllTeamsByEmployeeId(@PathVariable(value = "employeeId") Long employeeId) {
        return employeeServiceImpl.getAllTeamsByEmployeeId(employeeId);
    }

    @PostMapping("/addEmployee")
    private ResponseEntity<Employee> saveEmployee(@RequestBody final Employee employee) {
        return employeeServiceImpl.saveEmployee(employee);
    }

    @PostMapping("/teams/{teamId}/employee")
    private ResponseEntity<Employee> saveEmployeeToTeam(@PathVariable(value = "teamId") Long teamId, @RequestBody final Employee employeeRequest) {
        return employeeServiceImpl.addEmployeeToTeam(teamId, employeeRequest);
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
