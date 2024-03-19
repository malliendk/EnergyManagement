package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Distributor {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String logoUri;

    @OneToMany
    List<Supervisor> supervisors;
    @OneToMany
    List<Account> accounts;

    public Distributor(final String name, final String logoUri, final List<Supervisor> supervisors, final List<Account> accounts) {
        this.name = name;
        this.logoUri = logoUri;
        this.supervisors = supervisors;
        this.accounts = accounts;
    }
}
