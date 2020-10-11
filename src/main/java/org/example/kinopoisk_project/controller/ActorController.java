package org.example.kinopoisk_project.controller;

import org.example.kinopoisk_project.dto.ActorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("actor")
public class ActorController {
    //Обратить внимание
    @GetMapping("actor/{id}")
    public ActorDto getActorById(@PathVariable("id") Long id){
        return new ActorDto();
    }

    @PostMapping
    public ActorDto saveActor(@RequestBody ActorDto actor){
        return actor;
    }

    @PutMapping
    public ActorDto updateActor(@RequestBody ActorDto actor){
        return actor;
    }

    @DeleteMapping
    public void deleteActor(){
        System.out.println("Actor was deleted");
    }

}
