package com.sofka.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LobbyController {

    @GetMapping(path = "/lobby")
    public void gamerLobbyList(){
    }

    @PostMapping(path = "/name")
    public void addGamerLobby(){
    }

    @DeleteMapping(path = "/name/{id}")
    public void deleteLobbyList(){
    }

    @PatchMapping(path = "/name/timeAwait/{id}")
    public void updateTimeAwait(){

    }

    @PatchMapping(path = "/name/inprogress/{id}")
    public void updateInprogress(){

    }
}
