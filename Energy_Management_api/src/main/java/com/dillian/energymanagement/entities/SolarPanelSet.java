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
public class SolarPanelSet {

    @Id
    @GeneratedValue
    Long id;
    SupplyType supplyType;
    double supplyAmount;
    double production;
}
