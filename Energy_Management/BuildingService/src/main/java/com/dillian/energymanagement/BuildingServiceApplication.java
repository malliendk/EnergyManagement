package com.dillian.energymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BuildingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingServiceApplication.class, args);
    }

}
