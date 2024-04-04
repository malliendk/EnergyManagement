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
public class Locality {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String imageUrl;
    @ManyToMany
    List<Supervisor> supervisors;
    @OneToMany
    List<Account> accounts;

    public Locality(final String name, final String imageUrl, final List<Supervisor> supervisors, final List<Account> accounts) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.supervisors = supervisors;
        this.accounts = accounts;
    }
}
