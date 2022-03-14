package com.sofka.dao;

import com.sofka.domain.LobbyList;
import org.springframework.data.repository.CrudRepository;

public interface LobbyDao extends CrudRepository<LobbyList, Long> {
}
