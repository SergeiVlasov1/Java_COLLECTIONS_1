package ru.netology.repository;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<Player> players = new LinkedList<>();

    public List<Player> findAll() {
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName()
                    .equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void registerAll(List<Player> players) {
        this.players.addAll(players);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
