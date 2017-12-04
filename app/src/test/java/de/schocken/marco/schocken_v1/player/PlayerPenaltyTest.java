package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.MaxPenaltyException;

/**
 * This class tests the penalty functions.
 * Created by Snaki on 02.12.2017.
 */

public class PlayerPenaltyTest extends PlayerTest {

    /**
     * This method tests the setPenalty function.
     */
    @Test
    public void playerSetPenaltyTest() throws MaxPenaltyException {
        for (final Player player: players){
            player.setPenalties(12);
            Assert.assertEquals("The penalties should be equal by setPenalty",12,player.getPenalties());
        }
        for (final Player player: players){
            player.setPenalties(59);
            Assert.assertEquals("The penalties should be equal by setPenalty",59,player.getPenalties());
        }
    }

    /**
     * This method tests the addPenalty function.
     */
    @Test
    public void addPenaltyTest() throws MaxPenaltyException {
        for (final Player player: players) {
            for (int i = 0; i < 15; ++i) {
                player.addPenalties(i);
            }
        }
    }
    /**
     * This method tests the addPenalty function.
     */
    @Test
    public void addPenaltyTest2() throws MaxPenaltyException {
        for (final Player player: players) {
            player.addPenalties(1);
            Assert.assertEquals("The penalties of the player should be 1",1,player.getPenalties());
            player.addPenalties(1);
            Assert.assertEquals("The penalties of the player should be 2",2,player.getPenalties());
            player.addPenalties(4);
            Assert.assertEquals("The penalties of the player should be 6",6,player.getPenalties());
            player.addPenalties(7);
            Assert.assertEquals("The penalties of the player should be 13",13,player.getPenalties());
        }
    }
}
