package com.dillian.updateservice.enums;

import lombok.Getter;

@Getter
public enum WeatherType {

    SUNNY(1.5),
    MODERATE(1),
    OVERCAST(0.5),
    RAINY(0.25);

    private final double generationInfluence;

    WeatherType(double generationInfluence) {
        this.generationInfluence = generationInfluence;
    }
}
