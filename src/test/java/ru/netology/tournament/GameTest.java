package ru.netology.tournament;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    private Game player = new Game();

    private Player player1 = new Player(1, "Thor", 100);
    private Player player2 = new Player(2, "Hulk", 100);
    private Player player3 = new Player(3, "Captain America", 300);
    private Player player4 = new Player(4, "Ant Man", 250);
    private Player player5 = new Player(5, "Doctor Strange", 400);

    @BeforeEach
    void team() {
        player.addPlayer(player1);
        player.addPlayer(player2);
        player.addPlayer(player3);
        player.addPlayer(player4);
        player.addPlayer(player5);
    }

    @Test
    public void shouldFindAll() {
        Player[] actual = player.findAll().toArray(new Player[0]);
        Player[] expected = new Player[]{player1, player2, player3, player4, player5};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void ShouldStrengthEquals() {

        int actual = 0;
        int expected = player.round("Thor", "Hulk");

        assertEquals(actual, expected);
    }

    @Test
    public void ShouldTheFirstPlayerIsStrongerThanTheSecond() {

        int actual = 1;
        int expected = player.round("Doctor Strange", "Captain America");

        assertEquals(actual, expected);
    }

    @Test
    public void ShouldTheFirstPlayerIsWeakerThanTheSecond() {

        int actual = 2;
        int expected = player.round("Ant Man", "Captain America");

        assertEquals(actual, expected);
    }

    @Test
    public void ShouldRegistrationCheck() {
        boolean actual = false;
        boolean expected = player.register(new Player());

        assertEquals(actual, expected);
    }

    @Test
    public void ShouldRoundWithUnRegisteredPlayer1() {
        assertThrows(NotRegisteredException.class, () -> {
            player.round("Spiderman", "Captain America");
        });
    }

    @Test
    public void ShouldRoundWithUnRegisteredPlayer2() {
        assertThrows(NotRegisteredException.class, () -> {
            player.round("Hulk", "Black Widow");
        });
    }
}

