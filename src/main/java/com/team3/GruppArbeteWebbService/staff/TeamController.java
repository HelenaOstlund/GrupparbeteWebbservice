package com.team3.GruppArbeteWebbService.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RequiredArgsConstructor
@RestController
public class TeamController {

    private final TeamService teamService;

    //eller employeeServiceImpl?
   // private final EmployeeService employeeService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;

    }


    @GetMapping("/team")
    private ResponseEntity<List<Team>> getEmployeesInTeam() {
        return teamService.getAllTeams();
    }

    @PostMapping("/addTeam")
    private ResponseEntity<Team> saveTeam(@RequestBody final Team team){
        return teamService.save(team);
    }


    @GetMapping("teams/{teamId}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesByTeam(@PathVariable(value = "teamId") Long teamId) {
        return teamService.getAllEmployeesByTeam(teamId);
    }


    /*

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Tutorial _tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        _tutorial.setTitle(tutorial.getTitle());
        _tutorial.setDescription(tutorial.getDescription());
        _tutorial.setPublished(tutorial.isPublished());

        return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        tutorialRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        tutorialRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }


}
*/
}
