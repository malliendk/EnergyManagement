package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Supervisor {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String profilePicUri;
    private double distributionEfficiency;
    private double incomeRate;
    private double popRate;

    public Supervisor(String firstName, String lastName, String profilePicUri, double distributionEfficiency, double incomeRate, double popRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicUri = profilePicUri;
        this.distributionEfficiency = distributionEfficiency;
        this.incomeRate = incomeRate;
        this.popRate = popRate;
    }
}
