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

    @OneToMany
    List<Account> accounts;
    @ManyToMany
    List<Distributor> distributors;
    String profilePicUrl;

}
