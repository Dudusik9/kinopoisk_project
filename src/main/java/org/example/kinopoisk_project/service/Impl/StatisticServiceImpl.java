package org.example.kinopoisk_project.service.Impl;

import org.example.kinopoisk_project.dto.StatisticDto;
import org.example.kinopoisk_project.entity.Statistic;
import org.example.kinopoisk_project.repository.StatisticRepository;
import org.example.kinopoisk_project.repository.UserRepository;
import org.example.kinopoisk_project.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository, UserRepository userRepository, ConversionService conversionService) {
        this.statisticRepository = statisticRepository;
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public StatisticDto getStatisticByUserId(Long id) {
        Statistic statistic = statisticRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Statistic didn't find"));
        return conversionService.convert(statistic, StatisticDto.class);
    }

    @Override
    public StatisticDto addNewStatistic(StatisticDto statisticDto) {
        Statistic statistic = new Statistic();
        statistic.setId(userRepository.findById(statisticDto.getId()).orElseThrow(()->new IllegalArgumentException("")).getId());
        statistic.setNumberOfFeedback(statisticDto.getNumberOfFeedback());
        statistic.setNumberOfVisits(statisticDto.getNumberOfVisits());
        statistic = statisticRepository.save(statistic);
        return conversionService.convert(statistic, StatisticDto.class);
    }

    @Override
    public StatisticDto updateStatistic(StatisticDto statisticDto) {
        Statistic statistic = statisticRepository.findById(statisticDto.getId()).orElseThrow(() -> new IllegalArgumentException("Statistic didn't find"));
        statistic.setNumberOfFeedback(statisticDto.getNumberOfFeedback());
        statistic.setNumberOfVisits(statisticDto.getNumberOfVisits());
        statistic = statisticRepository.save(statistic);
        return conversionService.convert(statistic, StatisticDto.class);
    }

//    не удаляется статистика
    @Override
    public void deleteStatistic(Long id) {
//        statisticRepository.deleteById(id);
        Statistic statistic = statisticRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(""));
        statisticRepository.delete(statistic);
    }
}
