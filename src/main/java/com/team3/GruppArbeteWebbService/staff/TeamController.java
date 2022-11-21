package com.team3.GruppArbeteWebbService.staff;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TeamController {
    
    List<Team> teamList = new ArrayList<>(
            Arrays.asList(
            //        new Team("First Shift Team", List<Employee> employeeList, )
            )
            
    );
}
