package com.stackroute.player.repository;

import com.stackroute.player.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository <Player, Integer >{
    @Query(value = "Select p from Player p where p.playerName= ?1" )
    List<Player> searchByPlayerName (String playerName);

}
