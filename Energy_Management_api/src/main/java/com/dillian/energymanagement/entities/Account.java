package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.SupplyType;
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
    SupplyType supplyType;
    double supplyAmount;
    double production;
}
