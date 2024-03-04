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
public class Distributor {

    @Id
    @GeneratedValue
    Long id;
    String name;

    String locality;

    @OneToMany
    List<Account> accounts;

    @ManyToMany
    List<Supervisor> supervisor;
}
