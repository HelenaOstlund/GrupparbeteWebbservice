package com.team3.GruppArbeteWebbService.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

   // @Autowired
   private final EmployeeService employeeService;


    @GetMapping("/employee")
    private List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private Employee getEmployee(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    private Employee saveEmployee(@RequestBody final Employee employee){
       employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    private ResponseEntity<Employee> deleteEmployee(@PathVariable("id")long id){
       return employeeService.deleteEmployee(id);
    }


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
