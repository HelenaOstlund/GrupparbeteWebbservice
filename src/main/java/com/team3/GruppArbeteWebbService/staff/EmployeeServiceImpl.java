package com.team3.GruppArbeteWebbService.staff;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



    @Override
    public ResponseEntity<List<Team>> getAllTeamsByEmployeeId(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new IllegalStateException("Not found employee  with id = " + employeeId);
        }
        List<Team> teams = teamRepository.findTeamsByEmployees(employeeId);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Employee> addEmployeeToTeam(long teamId, Employee employeeRequest) {
        Employee employee = teamRepository.findById(teamId).map(team -> {
            long employeeId = employeeRequest.getId();

            if (employeeId != 0L) {
                Employee _employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException("Not found Tag with id = " + employeeId));

              team.addEmployee(_employee);
                teamRepository.save(team);
                return _employee;
            }
          team.addEmployee(employeeRequest);
            return employeeRepository.save(employeeRequest);
        }).orElseThrow(() -> new IllegalStateException("Not found teams with id = " + teamId));

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    //TODO: check if employee already exists
    @Override
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee employeeSaved = employeeRepository.save(employee);
            return new ResponseEntity<>(employeeSaved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Employee> deleteEmployee(long id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Employee> editEmployee(Employee employee, long id) {
        //evt såhär: (@PathVariable("id") long id, @RequestBody Employee em)
        Employee employeeInDB = employeeRepository.findById(id).get();

        if (Objects.nonNull(employee.getName())) {
            employeeInDB.setName(employee.getName());
        }
        //  if(Objects.nonNull(employee.get())){
        //    employeeInDB.setTeamId(employee.getTeamId());
        //    }
        if (Objects.nonNull(employee.getPhonenumber())) {
            employeeInDB.setPhonenumber(employee.getPhonenumber());
        }
        if (Objects.nonNull(employee.getRole())) {
            employeeInDB.setRole(employee.getRole());
        }
        if (Objects.nonNull(employee.getSSN())) {
            employeeInDB.setSSN(employee.getSSN());
        }
        return new ResponseEntity<>(employeeRepository.save(employeeInDB), HttpStatus.OK);
    }


}
