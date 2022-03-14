package com.sofka.domain;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;



@Data
@Table(name = "gamer_List")
@Entity
public class GamerList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gamer_list")
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamer_board")
    private String gamerBoard;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "validation_board")
    private String validationBoard;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ballot")
    private int ballot;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "is_playing")
    private boolean isPlaying;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "is_bingo")
    private boolean isBingo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lobby_list_id", referencedColumnName = "gamer_id")

    private LobbyList lobby_list;
    //private LobbyList lobbyListId;
}
