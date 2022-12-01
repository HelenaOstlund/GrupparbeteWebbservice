package com.team3.GruppArbeteWebbService.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

   private final TeamRepository teamRepository;

    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        teams.addAll(teamRepository.findAll());
        if (teams.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }


    public ResponseEntity<Team> save(Team team) {
        try {
            teamRepository.save(new Team(team.getTeamType(), team.getManagerId()));
            return new ResponseEntity<>(team, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
