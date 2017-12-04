package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This method tests the player action "blind".
 * Created by Snaki on 18.11.2017.
 */

public class PlayerActionBlindTest extends PlayerTest {

    /**
     * This method tests the blind function.
     */
    @Test
    public void blindTest(){
        for(final Player player: players) {
            try {
                player.blind();
                Assert.fail("The player can not call blind!");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices!");
            }
            try {
                player.blind();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call blind!");
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind!");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }

    /**
     * This method tests the blind function.
     */
    @Test
    public void blindTest2(){
        for(final Player player: players) {
            try {
                player.blind();
                Assert.fail("The player can not call blind before the player has rolled the dices");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind before the player has rolled the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.blind();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call blind");
            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }

    /**
     * This method tests the blind and open the cup function.
     */
    @Test
    public void blindAndOpenTheCupTest1(){
        for(final Player player: players) {
            try {
                player.blind();
                Assert.fail("The player can not call blind before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertFalse("The player could not called blind", player.isBlindCall());
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.blind();
                Assert.fail("The player can not call blind before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertFalse("The player could not called blind", player.isBlindCall());
            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.blind();
                Assert.assertTrue("The player has called blind", player.isBlindCall());
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call the blind");
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertTrue("The player has called blind", player.isBlindCall());
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }
    /**
     * This method tests the blind and open the cup function.
     */
    @Test
    public void blindAndOpenTheCupTest2(){
        for(final Player player: players) {
            try {
                player.openCup();
                Assert.fail("The player can not open the cup before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.blind();
                Assert.fail("The player can not call blind before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertFalse("The player could not called blind", player.isBlindCall());
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertFalse("The player could not called blind", player.isBlindCall());
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup before the player has not rolled the dices for the first time");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertFalse("The player has not called blind", player.isBlindCall());
            }
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
            try {
                player.blind();
                Assert.fail("The player can not call blind");
            } catch (PlayerActionNotAllowedException e) {
                Assert.assertFalse("The player has not called blind", player.isBlindCall());
            }
        }
    }

    /**
     * This method tests the player action "blind".
     */
    @Test
    public void blindTest3(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
            try {
                player.blind();
                Assert.fail("The player can not call blind");
            } catch (PlayerActionNotAllowedException e) {
            }
        }
    }
}
