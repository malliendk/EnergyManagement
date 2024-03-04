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
public class Supervisor {


    @Id
    @GeneratedValue
    Long id;
    String name;

    @OneToMany
    List<Account> accounts;
    @ManyToMany
    List<Distributor> distributors;
    String profilePicUrl;

    public Supervisor(Long id, String name, List<Account> accounts, List<Distributor> distributors, String profilePicUrl) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
        this.distributors = distributors;
        this.profilePicUrl = profilePicUrl;
    }
}
