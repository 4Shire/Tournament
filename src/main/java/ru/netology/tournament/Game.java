package ru.netology.tournament;

import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public boolean register(Player player) {
        players.add(player);
        return false;
    }

    public List<Player> findAll() {
        return players;
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {
        int result = 0;
        int player1 = findByName(playerName1);
        int player2 = findByName(playerName2);

        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName1)) {
                player1 = player.getStrength();
            }
            if (player.getName().equalsIgnoreCase(playerName2)) {
                player2 = player.getStrength();
            }
        }
        if (player1 == -1 || player2 == -1) {
            throw new NotRegisteredException("Игрок не зарегистрирован!");
        }
        if (player1 > player2) {
            result = 1;
        }
        if (player1 == player2) {
            result = 0;
        }
        if (player1 < player2) {
            result = 2;
        }
        return result;
    }

}
