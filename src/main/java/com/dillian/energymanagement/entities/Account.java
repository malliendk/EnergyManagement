package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String supplyType;
    double supplyAmount;

    @ManyToOne
    Locality locality;
    @ManyToOne
    Distributor distributor;
}
