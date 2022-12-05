package com.team3.GruppArbeteWebbService.staff;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeamService {

    ResponseEntity<List<Team>> getAllTeams();
    ResponseEntity<Team> save(Team team);
    ResponseEntity<Team> deleteTeam(long teamId);

}
