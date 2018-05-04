package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This method tests the player action "open the cup".
 * Created by Snaki on 18.11.2017.
 */

public class PlayerActionRollTheDiceAndOpenTheCupTest extends PlayerTest {
    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void rollTheDiceAndOpenTheCupTest(){
        for(final Player player: players) {
            try {
                player.openCup();
                Assert.fail("The player can not open the cup.");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 1", 1, player.getDiceThrows());
            try {
                player.openCup();
                Assert.fail("The player can not open the cup.");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 2", 2, player.getDiceThrows());
            try {
                player.openCup();
                Assert.fail("The player can not open the cup.");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 3", 3, player.getDiceThrows());
            try {
                player.rollTheDice();
                Assert.fail("The player can not roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 3", 3, player.getDiceThrows());
            try {
                player.stay();
                Assert.fail("The player can not call stay!");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }

    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void rollTheDiceAndOpenTheCupTest2(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 1", 1, player.getDiceThrows());
            try {
                player.openCup();
                Assert.fail("The player can not open the cup");
            } catch (PlayerActionNotAllowedException e) {
            }
        }
    }

    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void rollTheDiceAndOpenTheCupTest3(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 1", 1, player.getDiceThrows());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 2", 2, player.getDiceThrows());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 3", 3, player.getDiceThrows());
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
        }
    }
    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void rollTheDiceAndOpenTheCupTest4(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 1", 1, player.getDiceThrows());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 2", 2, player.getDiceThrows());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 3", 3, player.getDiceThrows());
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
        }
    }
}
