package com.team3.GruppArbeteWebbService.staff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee employeeBean(){

        return new Employee("Stina","3782937291", Role.SOUSCHEF, "8439204");
    }
}
