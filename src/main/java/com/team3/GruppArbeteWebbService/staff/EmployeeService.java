package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));

        return employees;
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();

    }

    public ResponseEntity<Employee> save(Employee employee) {
        try {
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    public Employee edit(Employee employee, long id) {
        Employee employeeInDB = employeeRepository.findById(id).get();
/*
       if (Objects.nonNull(employee.getName())
                && !"".equalsIgnoreCase(
                employee.getName())) {
            employee.setName(
                    employee.getName());
        }

        if (Objects.nonNull(
                employee.getSSN())
                && !"".equalsIgnoreCase(
                employee.getSSN())) {
            employeeInDB.setSSN(
                    employee.getSSN());
        }

        if (Objects.nonNull(employee.getPhonenumber())
                && !"".equalsIgnoreCase(
                employee.getPhonenumber())) {
            employeeInDB.setPhonenumber(
                    employee.getPhonenumber());
        }
if(Objects.nonNull(employee.getRole())){
    employeeInDB.setRole(employee.getRole());
}
*/
       if(Objects.nonNull(employee.getName())){ employeeInDB.setName(employee.getName());}
       if(Objects.nonNull(employee.getPhonenumber())){ employeeInDB.setPhonenumber(employee.getPhonenumber());}
       if(Objects.nonNull(employee.getRole())){ employeeInDB.setRole(employee.getRole());}
       if(Objects.nonNull(employee.getSSN())){ employeeInDB.setSSN(employee.getSSN());}
        //final Employee updatedEmployee = employeeRepository.save(employeeInDB);
        return employeeRepository.save(employeeInDB);

    }
}
