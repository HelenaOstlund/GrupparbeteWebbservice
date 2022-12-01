package com.team3.GruppArbeteWebbService.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

   // @Autowired
   private final EmployeeServiceImpl employeeServiceImpl;


    @GetMapping("/employee")
    private ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    private ResponseEntity<Employee> getEmployee(@PathVariable("id") long id){
        return employeeServiceImpl.getEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    private Employee saveEmployee(@RequestBody final Employee employee){
       employeeServiceImpl.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    private ResponseEntity<Employee> deleteEmployee(@PathVariable("id")long id){
       return employeeServiceImpl.deleteEmployee(id);
    }


    @PutMapping("/updateEmployee/{id}")
    private ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id){
        return employeeServiceImpl.editEmployee(employee, id);
    }

   /* @PatchMapping("/editEmployee/{id}")
    private ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.edit(employee, id), HttpStatus.OK);
    }*/

    @PatchMapping("/editEmployee/{id}")
    private ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        return employeeServiceImpl.editEmployee(employee, id);
    }
}
