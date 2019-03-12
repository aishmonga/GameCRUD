package com.stackroute.player.controller;

import com.stackroute.player.domain.Player;
import com.stackroute.player.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class PlayerController {

    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerServiceImpl = playerServiceImpl;
    }

    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer (@RequestBody Player player){
        Player savedPlayer = playerServiceImpl.savePlayer(player);
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.OK);
    }


    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayer(){
        List<Player> playerList =  playerServiceImpl.getPlayers();
        return new ResponseEntity<List<Player>>(playerList , HttpStatus.OK);
    }

    @GetMapping("/player/{id}")

    public ResponseEntity<Player> getPlayerById(@PathVariable int id){
        Player playerById = playerServiceImpl.getPlayerById(id);
        return new ResponseEntity<Player>(playerById , HttpStatus.OK);
    }

    @DeleteMapping("player/{id}")

    public ResponseEntity<List<Player>> deletePlayerById(@PathVariable int id){
        playerServiceImpl.deletePlayerById(id);
        return new ResponseEntity<List<Player>>(playerServiceImpl.getPlayers() , HttpStatus.OK);
    }

    @PutMapping("player/{id}")

    public ResponseEntity<List<Player>> updatedPlayer(@PathVariable int id , @RequestBody Player player){
        playerServiceImpl.updatedPlayerScores(player,id);
        return new ResponseEntity<List<Player>>(playerServiceImpl.getPlayers() , HttpStatus.OK);
    }

}
