package com.dillian.e_mngt_backendforfrontend.services.DTOBuilder;

import com.dillian.e_mngt_backendforfrontend.dtos.BuildingDTO;
import com.dillian.e_mngt_backendforfrontend.dtos.SolarPanelSetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

@Service
public class StatsCalculationHelperService {

    public double sumDoubleProperty(List<BuildingDTO> buildings, ToDoubleFunction<BuildingDTO> propertyFunction) {
        return buildings
                .stream()
                .mapToDouble(propertyFunction)
                .sum();
    }

    public int sumIntProperty(List<BuildingDTO> buildings, ToIntFunction<BuildingDTO> propertyFunction) {
        return buildings
                .stream()
                .mapToInt(propertyFunction)
                .sum();
    }

    public void mapSolarProduction(ToDoubleFunction<SolarPanelSetDTO> solarPanelGetter, ToDoubleFunction<BuildingDTO> buildingGetter,
                                   BiConsumer<BuildingDTO, Double> setterMethod, BuildingDTO buildingDTO) {
        buildingDTO.getSolarPanelSets()
                .forEach(solarPanelSetDTO -> {
                    double newValue = solarPanelGetter.applyAsDouble(solarPanelSetDTO) + buildingGetter.applyAsDouble(buildingDTO);
                    setterMethod.accept(buildingDTO, newValue);
                });
    }
}
