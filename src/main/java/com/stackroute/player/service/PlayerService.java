package com.stackroute.player.service;

import com.stackroute.player.domain.Player;
import com.stackroute.player.exceptions.PlayerAlreadyExistException;
import com.stackroute.player.exceptions.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {

    public Player savePlayer(Player player) throws Exception;

    public List<Player> getPlayers() throws Exception;

    public void deletePlayerById(int id);

    public Player updatedPlayerScores(Player player, int id) throws Exception;

    public List<Player> searchByPlayerName(String name);
}


