package com.dillian.energymanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Supervisor {


    @Id
    @GeneratedValue
    Long id;
    String firstName;
    String lastName;
    String profilePicUri;

    @ManyToOne
    Distributor distributor;
    @ManyToMany
    List<Locality> localities;

    public Supervisor(final String firstName, final String lastName, final String profilePicUri, final Distributor distributor, final List<Locality> localities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicUri = profilePicUri;
        this.distributor = distributor;
        this.localities = localities;
    }
}
