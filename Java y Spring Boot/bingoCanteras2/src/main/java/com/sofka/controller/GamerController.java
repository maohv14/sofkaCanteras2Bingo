package com.sofka.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamerController {
    @GetMapping(path = "/gamers")
    public void gamerList(){
    }

    @PostMapping(path = "/gamer")
    public void addGamer(){
    }

    @DeleteMapping(path = "/gamer/{id}")
    public void deleteGamerList(){
    }

    @PatchMapping(path = "/gamer/validationBoard/{id}")
    public void updateValidationBoard(){

    }

    @PatchMapping(path = "/gamer/ballot/{id}")
    public void updateBallot(){

    }

    @PatchMapping(path = "/gamer/isPlaying/{id}")
    public void updateIsPlaying(){

    }

    @PatchMapping(path = "/gamer/isBingo/{id}")
    public void updateIsBingo(){

    }
}
