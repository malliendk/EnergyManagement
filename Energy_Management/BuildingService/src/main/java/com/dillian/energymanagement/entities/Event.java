package com.dillian.energymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    @OneToOne
    Building building;

    public Event(final String name, final String description, final Building building) {
        this.name = name;
        this.description = description;
        this.building = building;
    }
}
