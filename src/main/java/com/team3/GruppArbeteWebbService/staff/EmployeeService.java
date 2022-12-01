package com.team3.GruppArbeteWebbService.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.addAll(employeeRepository.findAll());

        return employees;
    }

    public Employee getEmployeeById(long id) {

        return employeeRepository.findById(id).get();

    }
//TODO: check if employee already exists
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /* if (title == null)
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }*/

    public ResponseEntity<Employee> deleteEmployee(long id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }

//PUT and PATCH
    public Employee edit(Employee employee, long id) {
        Employee employeeInDB = employeeRepository.findById(id).get();

       if(Objects.nonNull(employee.getName())){
           employeeInDB.setName(employee.getName());
       }
      //  if(Objects.nonNull(employee.get())){
        //    employeeInDB.setTeamId(employee.getTeamId());
    //    }
       if(Objects.nonNull(employee.getPhonenumber())){
           employeeInDB.setPhonenumber(employee.getPhonenumber());
       }
       if(Objects.nonNull(employee.getRole())){
           employeeInDB.setRole(employee.getRole());
       }
       if(Objects.nonNull(employee.getSSN())) {
           employeeInDB.setSSN(employee.getSSN());
       }

        return employeeRepository.save(employeeInDB);

    }
}
