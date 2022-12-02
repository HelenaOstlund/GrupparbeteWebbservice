package com.team3.GruppArbeteWebbService.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long> {

    List<Team> findTeamsByEmployees(Long employeeId);



}
