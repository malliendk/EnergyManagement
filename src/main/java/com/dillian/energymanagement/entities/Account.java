package com.dillian.energymanagement.entities;

import jakarta.persistence.*;
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
}
