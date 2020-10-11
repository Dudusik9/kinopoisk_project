package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.StatisticDto;
import org.example.kinopoisk_project.entity.Statistic;
import org.example.kinopoisk_project.repository.StatisticRepository;
import org.example.kinopoisk_project.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public StatisticDto getStatisticByUserId(Long id) {
        Statistic statistic = statisticRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Statistic didn't find"));
        return StatisticDto.builder()
                .id(statistic.getId())
                .numberOfFeedback(statistic.getNumberOfFeedback())
                .numberOfVisits(statistic.getNumberOfVisits())
                .build();
    }

//    Этот метод не добавляет данные в табл.
//    Cannot add or update a child row: a foreign key constraint fails
    @Override
    public StatisticDto addNewStatistic(StatisticDto statisticDto) {
        Statistic statistic = new Statistic();
        statistic.setId(statisticDto.getId());
        statistic.setNumberOfFeedback(statisticDto.getNumberOfFeedback());
        statistic.setNumberOfVisits(statisticDto.getNumberOfVisits());
        statistic = statisticRepository.save(statistic);
        return StatisticDto.builder()
                .id(statistic.getId())
                .numberOfFeedback(statistic.getNumberOfFeedback())
                .numberOfVisits(statistic.getNumberOfVisits())
                .build();
    }

    @Override
    public StatisticDto updateStatistic(StatisticDto statisticDto) {
        Statistic statistic = statisticRepository.findById(statisticDto.getId()).orElseThrow(() -> new IllegalArgumentException("Statistic didn't find"));
        statistic.setNumberOfFeedback(statisticDto.getNumberOfFeedback());
        statistic.setNumberOfVisits(statisticDto.getNumberOfVisits());
        statistic = statisticRepository.save(statistic);
        return StatisticDto.builder()
                .id(statistic.getId())
                .numberOfFeedback(statistic.getNumberOfFeedback())
                .numberOfVisits(statistic.getNumberOfVisits())
                .build();
    }

    @Override
    public void deleteStatistic(Long id) {
        statisticRepository.deleteById(id);
    }
}
