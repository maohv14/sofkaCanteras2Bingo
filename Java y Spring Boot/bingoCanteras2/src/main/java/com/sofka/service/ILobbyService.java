package com.sofka.service;

import com.sofka.domain.LobbyList;

import java.util.List;

public interface ILobbyService {

    public List<LobbyList> listar();

    public LobbyList save(LobbyList gamer);

    public LobbyList update(Long id, LobbyList gamer);

    public void delete(LobbyList gamer);

    public void findGamer(LobbyList gamer);

}
