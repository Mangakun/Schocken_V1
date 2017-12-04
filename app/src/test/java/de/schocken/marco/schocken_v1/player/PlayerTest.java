package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

/**
 * This is a player test class. All player test classes should be extension of this class.
 * Created by Snaki on 18.11.2017.
 */

public class PlayerTest {

    /**
     * A list of players.
     */
    protected static List<Player> players;

    /**
     * A list of player names.
     */
    private final static String[] playerNames = {"Marco", "Michelle", "Marei"};

    /**
     * This method is called once before all player tests.
     * This method creates a player
     */
    @BeforeClass
    public static void createPlayers() {
        players = new ArrayList<>();
        for (final String playerName : playerNames) {
            final Player player = new PlayerImpl(playerName);
            players.add(player);
        }
    }

    /**
     * This method creates a new round for every test method.
     */
    @Before
    public void newRound(){
        for(final Player player :players){
            player.newRound();
        }
    }

    /**
     * This method tests, if the list of players is not empty.
     */
    @Test
    public void emptyTest() {
        Assert.assertTrue("The list is filled!", players.size() > 0);
    }

    /**
     * This method tests the player names.
     */
    @Test
    public void containsPlayerNames() {
        int i = -1;
        for ( i = 0; i < players.size(); ++i) {
            Assert.assertTrue(players.get(i).getName() + " should be equal " + playerNames[i], players.get(i).getName().equals(playerNames[i]));
        }
        Assert.assertTrue("The counter is equal the size of the player list", i == players.size());
        Assert.assertTrue("The counter is equal the size of the player names array", i == playerNames.length);
    }

    /**
     * This method tests the name of the first player list entry
     */
    @Test
    public void testNameFirstPlayerListEntry(){
        Assert.assertTrue(players.get(0).getName() + " should be equal " + playerNames[0], players.get(0).getName().equals(playerNames[0]));
        Assert.assertFalse(players.get(0).getName() + " should be not equal " + playerNames[1], players.get(0).getName().equals(playerNames[1]));
    }

    /**
     * This method tests the name of the second player list entry
     */
    @Test
    public void testNameSecondPlayerListEntry(){
        Assert.assertTrue(players.get(1).getName() + " should be equal " + playerNames[1], players.get(1).getName().equals(playerNames[1]));
        Assert.assertFalse(players.get(1).getName() + " should be not equal " + playerNames[2], players.get(1).getName().equals(playerNames[2]));

    }

    /**
     * This method tests the name of the third player list entry
     */
    @Test
    public void testNameThirdPlayerListEntry(){
        Assert.assertTrue(players.get(2).getName() + " should be equal " + playerNames[2], players.get(2).getName().equals(playerNames[2]));
        Assert.assertFalse(players.get(2).getName() + " should be not equal " + playerNames[0], players.get(2).getName().equals(playerNames[0]));
    }

}
