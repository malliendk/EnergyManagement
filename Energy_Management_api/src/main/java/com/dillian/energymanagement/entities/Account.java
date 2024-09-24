package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.SupplyType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Long id;
    private SupplyType supplyType;
    private double supplyAmount;
    private double energyYield;
    private double goldYield;
    private double researchYield;
    private double popYield;
}
