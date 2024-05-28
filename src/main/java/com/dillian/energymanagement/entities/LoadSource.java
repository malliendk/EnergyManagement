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
public class LoadSource {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String description;
    double gridLoad;
    int price;

    public LoadSource(String name, String description, double gridLoad, int price) {
        this.name = name;
        this.description = description;
        this.gridLoad = gridLoad;
        this.price = price;
    }
}
