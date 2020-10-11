package org.example.kinopoisk_project.service;

import org.example.kinopoisk_project.dto.StatisticDto;

public interface StatisticService {
    StatisticDto getStatisticByUserId(Long id);
    StatisticDto addNewStatistic(StatisticDto statisticDto);
    StatisticDto updateStatistic(StatisticDto statisticDto);
    void deleteStatistic(Long id);
}
