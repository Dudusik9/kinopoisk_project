package org.example.kinopoiskproject.controller;

import org.example.kinopoiskproject.dto.StatisticDto;
import org.example.kinopoiskproject.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public StatisticDto addNewStatistic (@Valid  @RequestBody StatisticDto statistic){
        return statisticService.addNewStatistic(statistic);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public StatisticDto updateStatistic (@Valid @RequestBody StatisticDto statistic){
        return statisticService.updateStatistic(statistic);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('WRITE')")
    public void deleteStatistic(@PathVariable("userId") Long id){
        statisticService.deleteStatistic(id);
    }
}
