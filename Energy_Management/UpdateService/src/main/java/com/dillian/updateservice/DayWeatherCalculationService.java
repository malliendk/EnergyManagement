package com.dillian.updateservice;

import com.dillian.updateservice.dtos.BuildingDTO;
import com.dillian.updateservice.dtos.GameDTO;
import com.dillian.updateservice.enums.TimeOfDay;
import com.dillian.updateservice.enums.WeatherType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DayWeatherCalculationService {

    private TimeOfDay timeOfDay;
    private WeatherType weatherType;


    public void recalculateAll(Map<TimeOfDay, WeatherType> dayWeatherMap, GameDTO gameDTO) {
        extractDayTimeAndWeather(dayWeatherMap);
        recalculateHousingConsumption(gameDTO);
        mapSolarPanelProductionToHouses(gameDTO);
        decideBonusYield(gameDTO);
    }

    public void calculateHousingProduction(GameDTO gameDTO) {
        gameDTO.getBuildings()
                .stream()
                .filter(building -> building.getHouseHolds() > 0)
                .forEach(house -> house.setEnergyProduction(house.getEnergyProduction()
                        * this.timeOfDay.getGenerationFactor() * this.weatherType.getGenerationInfluence()));
    }

    public void recalculateHousingConsumption(GameDTO gameDTO) {
        gameDTO.getBuildings()
                .stream()
                .filter(building -> building.getIncomeYield() > 0)
                .forEach(house -> house.setEnergyConsumption(house.getEnergyConsumption()
                        * this.timeOfDay.getHousingConsumptionFactor()));
    }


    public void extractDayTimeAndWeather(Map<TimeOfDay, WeatherType> dayWeatherMap) {
        this.timeOfDay = dayWeatherMap.keySet().iterator().next();
        this.weatherType = dayWeatherMap.values().iterator().next();
    }
}
