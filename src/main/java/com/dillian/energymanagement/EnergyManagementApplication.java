package com.dillian.energymanagement;

import com.dillian.energymanagement.bootstrap.SampleRecordSaver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class EnergyManagementApplication implements CommandLineRunner {

    private final SampleRecordSaver sampleRecordSaver;

    public static void main(String[] args) {
        SpringApplication.run(EnergyManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        sampleRecordSaver.saveAccounts();
        sampleRecordSaver.saveSupervisors();
        sampleRecordSaver.saveDistributors();
    }
}
