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
public class Distributor {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String logoUri;

    @OneToMany
    List<Account> accounts;

    @ManyToMany
    List<Supervisor> supervisor;
}
