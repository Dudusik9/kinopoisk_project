package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.StatisticDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("statistic")
public class StatisticController {

    @GetMapping("/statistic/{userId}")
    public StatisticDto getStatisticByUserId(@PathVariable("userId") Long id){
        return new StatisticDto();
    }

    @PostMapping
    public StatisticDto saveStatistic (@RequestBody StatisticDto statistic){
        return statistic;
    }

    @PutMapping
    public StatisticDto updateStatistic (@RequestBody StatisticDto statistic){
        return statistic;
    }

    @DeleteMapping
    public void deleteStatistic(){
        System.out.println("Statistic was deleted");
    }
}
