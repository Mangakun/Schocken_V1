package de.schocken.marco.schocken_v1.player;

import org.junit.Assert;
import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This class contains methods for testing general player actions.
 * Created by Snaki on 27.11.2017.
 */

public class PlayerGeneralPlayerActionTest extends PlayerTest {

    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest1(){
        for(final Player player: players) {
            try {
                player.stay();
                Assert.fail("The player cant call stay");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.blind();
                Assert.fail("The player cant call blind");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dice");
            }
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest2(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.blind();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player cancall blind");
            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest3(){
        for(final Player player: players) {
            try {
                player.blind();
                Assert.fail("The player cant call blind");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest4(){
        for(final Player player: players) {
            try {
                player.stay();
                Assert.fail("The player cant call stay");
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
                Assert.fail("The player can openthe cup");
            }
            try {
                player.blind();
                Assert.fail("The player cant call blind");
            } catch (PlayerActionNotAllowedException e) {

            }

        }
    }

    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest5() {
        for (final Player player : players) {
            try {
                player.openCup();
                Assert.fail("The player cant open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.blind();
                Assert.fail("The player cant call blind");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.stay();
                Assert.fail("The player cant call stay");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.rollTheDice();
                Assert.fail("The player cant roll the dices");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
            try {
                player.openCup();
                Assert.fail("The player cant open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest6() {
        for (final Player player : players) {
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
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.stay();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call stay");
            }
            try {
                player.openCup();
                Assert.fail("The player cant open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
                Assert.fail("The player cant roll the dice");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.blind();
                Assert.fail("The player cant call blind");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest7() {
        for (final Player player : players) {
            try {
                player.blind();
                Assert.fail("The player cant call blind!");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.openCup();
                Assert.fail("The player cant open the cup!");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dice");
            }
            try {
                player.blind();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call blind");
            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest8() {
        for (final Player player : players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dice");
            }
            try {
                player.openCup();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can open the cup");
            }
            try {
                player.stay();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call stay");
            }
        }
    }
    /**
     * This method tests a general player actions.
     */
    @Test
    public void playerGeneralTest9() {
        for (final Player player : players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dice");
            }
            try {
                player.blind();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call blind");
            }

            try {
                player.openCup();
                Assert.fail("The player cant open the cup");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.stay();
                Assert.fail("The player cant call stay");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }



}
