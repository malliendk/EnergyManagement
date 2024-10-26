package com.dillian.e_mngt_backendforfrontend.services;

import com.dillian.e_mngt_backendforfrontend.enums.TimeOfDay;
import com.dillian.e_mngt_backendforfrontend.enums.WeatherType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
@Slf4j
public class DayTimeSchedulerService {

    private final WeatherService weatherService;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public void scheduleDayTimeAndWeather() {
        Runnable task = () -> {
            Map<TimeOfDay, WeatherType> dayWeatherMap = this.weatherService.createNewDayWeatherMap();
            cycleThroughTimesOfDay(dayWeatherMap);
            log.info("Scheduled New Day Weather Map: {}", dayWeatherMap);
        };
        scheduler.scheduleAtFixedRate(task, 0, 15, TimeUnit.SECONDS);
    }

    private void cycleThroughTimesOfDay(Map<TimeOfDay, WeatherType> dayWeatherMap) {
        final int[] index = {0};
        Runnable task = () -> {
            TimeOfDay currentTimeOfDay = weatherService.getTimesOfDay().get(index[0]);
            WeatherType weatherType = dayWeatherMap.get(currentTimeOfDay);
            Map<TimeOfDay, WeatherType> dayTimeAndWeather = Map.of(currentTimeOfDay, weatherType);
            index[0]++;
            if (index[0] == dayTimeAndWeather.size()) {
                index[0] = 0;
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 15, TimeUnit.SECONDS);
    }
}
