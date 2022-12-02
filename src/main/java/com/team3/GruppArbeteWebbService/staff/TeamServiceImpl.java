package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        teams.addAll(teamRepository.findAll());
        if (teams.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Team> save(Team team) {
        try {
            teamRepository.save(new Team(team.getTeamType(), team.getManagerId()));
            return new ResponseEntity<>(team, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO -make it work
/*
    @Override
    public ResponseEntity<List<Employee>> getAllEmployeesByTeam(long teamId) {
      try{
          List<Employee> employees = employeeRepository.findEmployeeByTeams(teamId);
          return new ResponseEntity<>(employees, HttpStatus.OK);
      } catch (Exception e){
          return new ResponseEntity("Team not found: " + e, HttpStatus.NOT_FOUND);
      }
    }
 */
    @Override
    public ResponseEntity<Team> deleteTeam(long id) {
        try {
            teamRepository.deleteById(id);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }


}