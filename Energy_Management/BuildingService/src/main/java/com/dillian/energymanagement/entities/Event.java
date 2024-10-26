package com.dillian.energymanagement.entities;

import com.dillian.energymanagement.entities.building.Building;
import jakarta.persistence.*;
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
    @JoinColumn(name = "building_id")
    Building building;
}
