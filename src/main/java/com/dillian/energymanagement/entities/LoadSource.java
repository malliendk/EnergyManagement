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
    Long id;
    String name;

    String description;
    double load;

    public LoadSource(final String name, final String description, final double load) {
        this.name = name;
        this.description = description;
        this.load = load;
    }
}
