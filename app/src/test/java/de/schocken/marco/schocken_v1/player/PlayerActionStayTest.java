package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * This class tests the player action "stay".
 * Created by Snaki on 26.11.2017.
 */

public class PlayerActionStayTest extends PlayerTest {

    /**
     * This method test the player action "stay".
     */
    @Test
    public void stayTest(){
        for(final Player player: players) {
            try {
                player.stay();
                Assert.fail("Player cant call stay. At first he has to roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }

    /**
     * This method test the player action "stay".
     */
    @Test
    public void stayTest2(){
        for(final Player player: players) {
            try {
                player.stay();
                Assert.fail("Player cant call stay. At first he has to roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.stay();
                Assert.fail("Player cant call stay. At first he has to roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }
    /**
     * This method test the player action "stay".
     */
    @Test
    public void stayTest3(){
        for(final Player player: players) {
            try {
                player.stay();
                Assert.fail("Player cant call stay. At first he has to roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.stay();
                Assert.fail("Player cant call stay. At first he has to roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
            try {
                player.stay();
                Assert.fail("Player cant call stay. At first he has to roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }

}
