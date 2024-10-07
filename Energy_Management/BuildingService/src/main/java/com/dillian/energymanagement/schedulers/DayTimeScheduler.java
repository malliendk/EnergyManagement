package com.dillian.energymanagement.schedulers;

import com.dillian.energymanagement.WebSocketHandler;
import com.dillian.energymanagement.enums.TimeOfDay;
import com.dillian.energymanagement.enums.WeatherType;
import com.dillian.energymanagement.services.WeatherService;
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
public class DayTimeScheduler {

    private final WeatherService weatherService;
    private final WebSocketHandler webSocketHandler;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);


    public void scheduleDayTimeAndWeather() {
        Runnable task = () -> {
            Map<TimeOfDay, WeatherType> dayWeatherMap = this.weatherService.createNewDayWeatherMap();
            cycleThroughTimesOfDay(dayWeatherMap);
        };
        scheduler.scheduleAtFixedRate(task, 0, 60, TimeUnit.SECONDS);
    }

    private void cycleThroughTimesOfDay(Map<TimeOfDay, WeatherType> dayWeatherMap) {
        final int[] index = {0};
        Runnable task = () -> {
            TimeOfDay currentTimeOfDay = weatherService.getTimesOfDay().get(index[0]);
            WeatherType weatherType = dayWeatherMap.get(currentTimeOfDay);
            Map<TimeOfDay, WeatherType> dayTimeAndWeather = Map.of(currentTimeOfDay, weatherType);
            webSocketHandler.broadCastTimeOfDay(dayTimeAndWeather);
            index[0]++;
            if (index[0] == dayTimeAndWeather.size()) {
                index[0] = 0;
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 15, TimeUnit.SECONDS);
    }
}
