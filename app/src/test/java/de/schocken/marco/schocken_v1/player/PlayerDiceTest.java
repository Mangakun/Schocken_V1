package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import de.schocken.marco.schocken_v1.dice.DiceValue;
import de.schocken.marco.schocken_v1.player.exceptions.DiceNotFoundException;
import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This method tests the functions of the player which are connected with the dices which are out.
 * Created by Snaki on 02.12.2017.
 */

public class PlayerDiceTest extends PlayerTest {

    /**
     * This method test the dice actions.
     */
    @Test
    public void playerDiceTest1() {
        for (final Player player : players) {
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
        }
    }

    /**
     * This method test the dice actions.
     */
    @Test
    public void playerDiceTest2() {
        for (final Player player : players) {
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
        }
    }
    /**
     * This method test the dice actions.
     */
    @Test
    public void playerDiceTest3() {
        for (final Player player : players) {
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
        }
    }
    /**
     * This method test the dice actions.
     */
    @Test
    public void playerDiceTest4() {
        for (final Player player : players) {
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.stay();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call stay");
            }
            Assert.assertEquals("The player should have 0 dices in ", 0, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 3 dices out ", 3, player.getDicesValuesOut().size());
        }
    }


    /**
     * This method test the dice actions.
     */
    @Test
    public void playerDiceTest5() {
        for (final Player player : players) {
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player should have 3 dices in ", 3, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 0, player.getDicesValuesOut().size());
            List<DiceValue> dicesValues = player.getDicesValuesIn();
            int randomEntry = getRandom(dicesValues.size());
            try {
                player.diceOut(dicesValues.get(randomEntry));
            } catch (DiceNotFoundException e) {
                Assert.fail("The dice should be in the list of dices in");

            }
            Assert.assertEquals("The player should have 3 dices in ", 2, player.getDicesValuesIn().size());
            Assert.assertEquals("The player should have 0 dices out ", 1, player.getDicesValuesOut().size());
        }
    }



    private int getRandom(final int max){
        Random rn = new Random();
        int result =  rn.nextInt(max); // random number between 0 and max
        return result;
    }

}
