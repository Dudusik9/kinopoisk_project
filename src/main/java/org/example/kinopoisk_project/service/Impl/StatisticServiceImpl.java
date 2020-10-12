package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.StatisticDto;
import org.example.kinopoisk_project.entity.Statistic;
import org.example.kinopoisk_project.repository.StatisticRepository;
import org.example.kinopoisk_project.repository.UserRepository;
import org.example.kinopoisk_project.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;
    private final UserRepository userRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository, UserRepository userRepository) {
        this.statisticRepository = statisticRepository;
        this.userRepository = userRepository;
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

    @Override
    public StatisticDto addNewStatistic(StatisticDto statisticDto) {
        Statistic statistic = new Statistic();
        statistic.setId(userRepository.findById(statisticDto.getId()).orElseThrow(()->new IllegalArgumentException("")).getId());
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
