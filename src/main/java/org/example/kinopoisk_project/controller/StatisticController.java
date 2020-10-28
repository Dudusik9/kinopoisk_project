package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.StatisticDto;
import org.example.kinopoisk_project.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('STATISTIC_READ')")
    public StatisticDto getStatisticByUserId(@PathVariable("userId") Long id)
    {
        return statisticService.getStatisticByUserId(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public StatisticDto addNewStatistic (@RequestBody StatisticDto statistic){
        return statisticService.addNewStatistic(statistic);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public StatisticDto updateStatistic (@RequestBody StatisticDto statistic){
        return statisticService.updateStatistic(statistic);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('WRITE')")
    public void deleteStatistic(@PathVariable("userId") Long id){
        statisticService.deleteStatistic(id);
    }
}
