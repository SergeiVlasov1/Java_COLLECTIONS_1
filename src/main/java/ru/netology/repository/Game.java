package ru.netology.repository;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        this.players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
