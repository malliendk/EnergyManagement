package com.dillian.energymanagement;

import com.dillian.energymanagement.bootstrap.RelationshipSetter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class EnergyManagementApplication implements CommandLineRunner {

    private final RelationshipSetter relationshipSetter;

    public static void main(String[] args) {
        SpringApplication.run(EnergyManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        relationshipSetter.initializeObjectsAndSetRelationships();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE");
            }
        };
    }
}
