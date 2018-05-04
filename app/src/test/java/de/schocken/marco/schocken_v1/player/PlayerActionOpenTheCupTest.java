package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This method tests the player action "open the cup".
 * Created by Snaki on 18.11.2017.
 */

public class PlayerActionOpenTheCupTest extends PlayerTest {
    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void openTheCupTest1(){
        for(final Player player: players) {
            try {
                player.openCup();
                Assert.fail("The player can not open the cup. The player has to roll the dices first");
            } catch (PlayerActionNotAllowedException e) {
            }
        }
    }

    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void openTheCupTest2(){
        for(final Player player: players) {
            try {
                player.openCup();
                Assert.fail("The player can not open the cup. The player has to roll the dices first");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup. The player has to roll the dices first");
            } catch (PlayerActionNotAllowedException e) {
            }
        }
    }

    /**
     * This method test the player action "open the cup".
     */
    @Test
    public void openTheCupTest3(){
        for(final Player player: players) {
            try {
                player.openCup();
                Assert.fail("The player can not open the cup. The player has to roll the dices first");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup. The player has to roll the dices first");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.openCup();
                Assert.fail("The player can not open the cup. The player has to roll the dices first");
            } catch (PlayerActionNotAllowedException e) {
            }
        }
    }




}
