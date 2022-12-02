package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }


    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        teams.addAll(teamRepository.findAll());
        if (teams.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    public ResponseEntity<Team> save(@RequestBody Team team) {
        try {
            teamRepository.save(new Team(team.getTeamType(), team.getManagerId()));
            return new ResponseEntity<>(team, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<List<Employee>> getAllEmployeesByTeam(long teamId) {
        if (!teamRepository.existsById(teamId)) {
            throw new IllegalStateException("Not found teams with id = " + teamId);
        }
        List<Employee> employees = employeeRepository.findEmployeeByTeams(teamId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}
