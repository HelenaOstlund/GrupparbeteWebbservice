package com.team3.GruppArbeteWebbService.staff;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>(
           /* Arrays.asList(
                    new Employee(0, "Stina", "196760716-3486", Role.CHEF, "07432894478"),
                    new Employee(1, "José", "19800805-3543",Role.SOMMELIER, "0747389473")
            )*/
    );

    @GetMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/getEmployee")
    public Employee getFirstEmployee() {
        return employeeList.get(0);
    }


    @PostMapping("/addEmployee")
    public void createEmployee(){
     //  TODO
        //   employeeList.add(new Employee(employeeList.size(), "Ally", "19700604-0203", Role.))
    }

    @DeleteMapping("deleteEmployee")
    public void deleteEmployee(){
        //TODO
    }
}
