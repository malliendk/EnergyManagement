package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    int price;

    public Building(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
