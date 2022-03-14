package com.sofka.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.sql.Time;

/**
 * Clase que permite la representación de la tabla de la lista de jugadores en el Lobby en la base de datos con Spring boot
 */

@Data
@Table(name = "lobby_list")
@Entity
public class LobbyList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamer_id")
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamer_name")
    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_await")
    private Time timeAwait;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inprogress")
    private boolean inProgruess;

    @OneToOne(mappedBy = "lobby_list")
    private GamerList gamer_list;
    //private GamerList gamerListId;
}
