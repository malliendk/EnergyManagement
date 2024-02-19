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
    String name;

    @OneToMany
    List<Account> accounts;
    @OneToMany
    List<Distributor> distributors;

}
