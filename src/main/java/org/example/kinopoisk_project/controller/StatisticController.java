package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.StatisticDto;
import org.example.kinopoisk_project.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/{userId}")
    public StatisticDto getStatisticByUserId(@PathVariable("userId") Long id)
    {
        return statisticService.getStatisticByUserId(id);
    }

    @PostMapping
    public StatisticDto addNewStatistic (@RequestBody StatisticDto statistic){
        return statisticService.addNewStatistic(statistic);
    }

    @PutMapping
    public StatisticDto updateStatistic (@RequestBody StatisticDto statistic){
        return statisticService.updateStatistic(statistic);
    }

    @DeleteMapping("/{userId}")
    public void deleteStatistic(@PathVariable("userId") Long id){
        statisticService.deleteStatistic(id);
        System.out.println("Statistic was deleted");
    }
}