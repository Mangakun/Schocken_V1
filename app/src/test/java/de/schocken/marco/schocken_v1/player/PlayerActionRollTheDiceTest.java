package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This class is an extension of the {@link PlayerTest} class.
 * This class contains all tests for the player action "roll the dice".
 * Created by Snaki on 18.11.2017.
 */

public class PlayerActionRollTheDiceTest extends PlayerTest {

    /**
     * This method tests the roll the dice player action.
     */
    @Test
    public void rollTheDiceTest1() {
        for (final Player player : players) {
            Assert.assertNotNull("The player should not be null!", player);
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 1", 1, player.getDiceThrows());
            Assert.assertFalse("The player is not ready with throws",player.isFinsishedWithThrows());
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
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 2", 2, player.getDiceThrows());
            Assert.assertFalse("The player is not ready with throws",player.isFinsishedWithThrows());
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
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 3", 3, player.getDiceThrows());
            Assert.assertTrue("The player is ready with throws",player.isFinsishedWithThrows());
            try {
                player.rollTheDice();
                Assert.fail("The player can not roll the dices a fourth time!");
            } catch (PlayerActionNotAllowedException e) {
            }

        }
    }


}
