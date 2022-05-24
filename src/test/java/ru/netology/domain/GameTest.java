package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Game;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Стипе Миочич", 17);
    private Player player2 = new Player(2, "Брэндон Морено", 7);
    private Player player3 = new Player(3, "Александр Волкановски", 25);
    private Player player4 = new Player(4, "Исраэль Адесанья", 25);

    @BeforeEach
    void shouldRegisterAllPlayers() {
        game.registerAll(List.of(player1, player2, player3, player4));
    }

    @Test
    void shouldFindAllRegisteredPlayers() {
        assertEquals(List.of(player1, player2, player3, player4), game.findAll());
    }

    @Test
    void shouldFindByNameWhenRegister() {
        assertEquals(player3, game.findByName("Александр Волкановски"));
    }

    @Test
    void shouldReturnNullWhenNotRegister() {
        assertNull(game.findByName("Дэвид Дворак"));
    }

    @Test
    void shouldShowResultIfPlayer1Wins() {
        assertEquals(1, game.round("Стипе Миочич", "Брэндон Морено"));
    }

    @Test
    void shouldShowResultIfPlayer2Wins() {
        assertEquals(2, game.round("Брэндон Морено", "Александр Волкановски"));
    }

    @Test
    void shouldShowResultWhenDraw() {
        assertEquals(0, game.round("Александр Волкановски", "Исраэль Адесанья"));
    }

    @Test
    void shouldThrowExceptionWhenPlayer1Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Дэвид Дворак", "Исраэль Адесанья"));
    }

    @Test
    void shouldThrowExceptionWhenPlayer2Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Исраэль Адесанья", "Дэвид Дворак"));
    }

    @Test
    void shouldThrowExceptionWhenPlayersBothUnregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Дэвид Дворак", "Шон О'Мэлли"));
    }
}