package de.schocken.marco.schocken_v1.gameobserver;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import de.schocken.marco.schocken_v1.gameobserver.impl.GameObserverImpl;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

/**
 * Created by Snaki on 16.12.2017.
 * This class is a test class for testing the game observer.
 */

public class GameObserverTest {

    /**
     * A list of player names.
     */
    private final static String[] playerNames = {"Marco", "Michelle", "Marei"};

    /**
     * A game observer object.
     */
    protected static GameObserver gameObserver;

    /**
     * This method is called once before all game observer tests.
     * This method creates a game observer.
     */
    @BeforeClass
    public static void createGameObserver() {
        gameObserver = new GameObserverImpl();
    }

    /**
     * This method tests the game observer object.
     */
    @Test
    public void objectTest(){
        Assert.assertNotNull("The game observer should not be null",gameObserver);
    }


    @Test
    public void nextPlayerTest(){
        gameObserver.newGame();
        gameObserver.createPlayers(playerNames);
        Player currentPlayer = gameObserver.getCurrentPlayer();
        Player save = currentPlayer;
        try {
            currentPlayer.rollTheDice();
        } catch (PlayerActionNotAllowedException e) {
            Assert.fail("The player can roll the dices");
        }
        try {
            currentPlayer.rollTheDice();
        } catch (PlayerActionNotAllowedException e) {
            Assert.fail("The player can roll the dices");
        }
        try {
            currentPlayer.rollTheDice();
        } catch (PlayerActionNotAllowedException e) {
            Assert.fail("The player can roll the dices");
        }
        try {
            currentPlayer.rollTheDice();
            Assert.fail("The player can not roll the dices");
        } catch (PlayerActionNotAllowedException e) {

        }

        Assert.assertNotSame("Der Currentplayer sollte ein anderer sein",gameObserver.getCurrentPlayer(),save);
    }


}
