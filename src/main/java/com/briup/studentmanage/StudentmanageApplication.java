package com.briup.studentmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.briup.studentmanage.mapper"})
public class StudentmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmanageApplication.class, args);
    }

}
