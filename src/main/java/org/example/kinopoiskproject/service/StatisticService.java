package org.example.kinopoiskproject.service;

import org.example.kinopoiskproject.dto.StatisticDto;

public interface StatisticService {
    StatisticDto getStatisticByUserId(Long id);
    StatisticDto addNewStatistic(StatisticDto statisticDto);
    StatisticDto updateStatistic(StatisticDto statisticDto);
    void deleteStatistic(Long id);
}
