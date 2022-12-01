package com.team3.GruppArbeteWebbService.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByTeamId(long postId);

    @Transactional
    void deleteByTeamId(long teamId);
}
