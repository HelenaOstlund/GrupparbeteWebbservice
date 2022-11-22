package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    private ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    private Employee getEmployee(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    private Employee saveEmployee(@RequestBody final Employee employee){
       employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    private String deleteEmployee(@PathVariable("id")long id){
        employeeService.delete(id);
        return "Deleted successfully.";
    }

   /* @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") long id) {
        return employeeService.edit(id);
    }*/

    @PutMapping("/updateEmployee/{id}")
    private Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id){
        return employeeService.edit(employee, id);
    }

   /* @PatchMapping("/editEmployee/{id}")
    private ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.edit(employee, id), HttpStatus.OK);
    }*/

    @PatchMapping("/editEmployee/{id}")
    private Employee editEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        return employeeService.edit(employee, id);
    }
}
