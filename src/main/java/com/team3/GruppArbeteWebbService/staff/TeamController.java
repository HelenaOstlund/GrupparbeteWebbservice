package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private final TeamServiceImpl teamServiceImpl;

    //eller employeeServiceImpl?
   // private final EmployeeService employeeService;

    @Autowired
    public TeamController(TeamServiceImpl teamServiceImpl) {
        this.teamServiceImpl = teamServiceImpl;

    }


    @GetMapping("/team")
    private ResponseEntity<List<Team>> getEmployeesInTeam() {
        return teamServiceImpl.getAllTeams();
    }

    @PostMapping("/addTeam")
    private ResponseEntity<Team> saveTeam(@RequestBody final Team team){
        return teamServiceImpl.save(team);
    }

/*
    @GetMapping("/teams/{id}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesByTeam(@PathVariable(value = "id") long teamId) {
        return teamServiceImpl.getAllEmployeesByTeam(teamId);
    }
*/

    @DeleteMapping("/deleteTeam/{id}")
    public ResponseEntity<Team> deleteTeam (@PathVariable (value = "id") long teamId){
        return teamServiceImpl.deleteTeam(teamId);
    }
}
