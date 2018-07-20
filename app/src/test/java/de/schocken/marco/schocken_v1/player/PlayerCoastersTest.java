package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.player.exceptions.MaxCoastersException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxPenaltyException;

/**
 * This class tests the penalty functions.
 * Created by Snaki on 02.12.2017.
 */

public class PlayerCoastersTest extends PlayerTest {

    /**
     * This method tests the setPenalty function.
     */
    @Test
    public void playerSetCoastersTest1() throws MaxPenaltyException {
        for (final Player player: players){
            int coasters = 12;
            try {
                player.setCoasters(coasters);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to set "+coasters+" coasters");
            }
            Assert.assertEquals("The penalties should be equal by setPenalty",coasters,player.getCoasters());
        }
    }

    /**
     * This method tests the setPenalty function.
     */
    @Test
    public void playerSetCoastersTest2() throws MaxPenaltyException {
        for (final Player player: players){
            int coasters = 59;
            try {
                player.setCoasters(coasters);
                Assert.fail("It is not possible to set "+coasters+" coasters");
            } catch (MaxCoastersException e) {

            }
            Assert.assertEquals("The penalties should be equal by setPenalty",coasters,player.getCoasters());
        }
    }

    /**
     * This method tests the addCoasters function.
     */
    @Test
    public void addCoastersTest() throws MaxPenaltyException {
        for (final Player player: players) {
            for (int i = 0; i < 15; ++i) {
                try {
                    player.addCoasters(i);
                    if(i > 13){
                        Assert.fail("It is not possible to set more than 13 coasters"); // TODO: von settings nehmen
                    }
                } catch (MaxCoastersException e) {

                }
            }
        }
    }
    /**
     * This method tests the addCoasters function.
     */
    @Test
    public void addCoastersTest2() throws MaxPenaltyException {
        for (final Player player: players) {
            try {
                player.addCoasters(1);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to add 1 coaster");
            }
            Assert.assertEquals("The penalties of the player should be 1",1,player.getCoasters());
            try {
                player.addCoasters(1);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to add 1 coaster");
            }
            Assert.assertEquals("The penalties of the player should be 2",2,player.getCoasters());
            try {
                player.addCoasters(4);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to add 4 coaster");
            }
            Assert.assertEquals("The penalties of the player should be 6",6,player.getCoasters());
            try {
                player.addCoasters(7);
            } catch (MaxCoastersException e) {
                e.printStackTrace();
            }
            Assert.assertEquals("The penalties of the player should be 13",13,player.getCoasters());
        }
    }

    /**
     * This method tests the addPenalty function.
     */
    @Test
    public void addCoastersTest3() throws MaxPenaltyException {
        for (final Player player: players) {
            try {
                player.addCoasters(1);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to add 1 coaster");
            }
            Assert.assertEquals("The penalties of the player should be 1",1,player.getCoasters());
            try {
                player.addCoasters(1);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to add 1 coaster");
            }
            Assert.assertEquals("The penalties of the player should be 2",2,player.getCoasters());
            try {
                player.addCoasters(4);
            } catch (MaxCoastersException e) {
                Assert.fail("It is possible to add 4 coaster");
            }
            Assert.assertEquals("The penalties of the player should be 6",6,player.getCoasters());
            try {
                player.addCoasters(8);
                Assert.fail("It is not possible to add 8 coaster");
            } catch (MaxCoastersException e) {
            }
        }
    }
}
