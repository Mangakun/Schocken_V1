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
            try {
                player.openCup();
                Assert.fail("Player cant open the dices, when nothing is under the cup");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            Assert.assertEquals("The player dices throws (" + player.getDiceThrows() + ") should be equal 1", 1, player.getDiceThrows());
            try {
                player.stay();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call stay!");
            }
            Assert.assertTrue("The player is finished for this round",player.isRoundFinished());
        }
    }

    /**
     * This method tests the player action "stay".
     */
    @Test
    public void stayTest2(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            try {
                player.stay();
                Assert.fail("The player can not call stay without opened the cup first");
            } catch (PlayerActionNotAllowedException e) {
            }
            try {
                player.rollTheDice();
                Assert.fail("The player can not roll the dices");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }

    /**
     * This method tests the player action "stay"
     */
    @Test
    public void stayTest3(){
        for(final Player player: players) {
            try {
                player.rollTheDice();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can roll the dices");
            }
            /*try {
                player.blind();
            } catch (PlayerActionNotAllowedException e) {
                Assert.fail("The player can call blind");
            }*/
            try {
                player.stay();
                Assert.fail("The player can not call stay");
            } catch (PlayerActionNotAllowedException e) {

            }
        }
    }
    /**
     * This method tests the player action "stay"
     */
    @Test
    public void stayTest4(){
        for(final Player player: players) {
//            player.rollTheDice();
//            player.openCup();
//            player.rollTheDice();
//            player.openCup();
//            player.blind();
        }

    }
}
