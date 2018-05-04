package de.schocken.marco.schocken_v1.player;//package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This method tests the player action "blind".
 * Created by Snaki on 18.11.2017.
 */

public class PlayerNewGameNewHalfNextRoundTest extends PlayerTest {

    /**
     * This method tests the next game function.
     */
    @Test
    public void nextGameTest(){
        for(final Player player: players) {
            player.nextGame();
            Assert.assertEquals("The player should have 0 halfs",0,player.getHalfs());
            Assert.assertEquals("The player should have 0 coasters",0,player.getCoasters());
            Assert.assertEquals("The player should have 0 dice throws",0,player.getDiceThrows());
        }
    }

    /**
     * This method tests the next game function.
     */
    @Test
    public void nextGameTest2(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
               Assert.fail("The player is able to roll the dices.");
            }
            Assert.assertEquals("The player should have 1 dice throws",1,player.getDiceThrows());
            player.nextGame();
            Assert.assertEquals("The player should have 0 halfs",0,player.getHalfs());
            Assert.assertEquals("The player should have 0 coasters",0,player.getCoasters());
            Assert.assertEquals("The player should have 0 dice throws",0,player.getDiceThrows());
        }
    }
    /**
     * This method tests the next game function.
     */
    @Test
    public void nextHalfTest(){
        for(final Player player: players) {
            player.nextHalf();
            Assert.assertEquals("The player should have 0 coasters",0,player.getCoasters());
            Assert.assertEquals("The player should have 0 dice throws",0,player.getDiceThrows());
        }
    }
    /**
     * This method tests the next game function.
     */
    @Test
    public void nextRoundTest(){
        for(final Player player: players) {
            player.nextRound();
            Assert.assertEquals("The player should have 0 dice throws",0,player.getDiceThrows());

        }
    }


}
