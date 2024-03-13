package com.dillian.energymanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor {


    @Id
    @GeneratedValue
    Long id;
    String firstName;
    String lastName;
    String profilePicUri;

    @ManyToOne
    Distributor distributors;
    @ManyToMany
    List<Locality> localities;

}
