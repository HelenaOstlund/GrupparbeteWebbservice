package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private long saveEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdate(employee);
        return employee.getId();
    }

    @DeleteMapping("deleteEmployee")
    private void deleteEmployee(@PathVariable("id")long id){
        employeeService.delete(id);
    }


}
