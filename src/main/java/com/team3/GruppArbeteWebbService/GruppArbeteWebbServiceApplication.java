package com.team3.GruppArbeteWebbService;

import com.team3.GruppArbeteWebbService.staff.Employee;
import com.team3.GruppArbeteWebbService.staff.EmployeeConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GruppArbeteWebbServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GruppArbeteWebbServiceApplication.class, args);

     //   ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);

      //  Employee employee = context.getBean("employeeBean", Employee.class);

       // System.out.println(employee.getName());

    }

}