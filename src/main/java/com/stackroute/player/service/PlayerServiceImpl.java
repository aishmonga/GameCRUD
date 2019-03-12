package com.stackroute.player.service;

import com.stackroute.player.domain.Player;
import com.stackroute.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImpl {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }


    public Player savePlayer(Player player) {
        Player savedPlayer = playerRepository.save(player);
        return savedPlayer;
    }

    public List<Player> getPlayers() {
        List<Player> allPlayers = (List) playerRepository.findAll();
        return allPlayers;

    }

    public Player getPlayerById(int id) {

        Player playerById = playerRepository.findById(id).get();
        return playerById;
    }

    public Player updatedPlayerScores(Player player, int id) {
        Player playerById = playerRepository.findById(id).get();
        playerById.setScore(player.getScore());
        return playerRepository.save(playerById);
    }

    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

    public List<Player> searchByPlayerName(String playerName) {
        List<Player> player = playerRepository.searchByPlayerName(playerName);
        return player;

    }
}
