//package de.schocken.marco.schocken_v1.player;
//
//import junit.framework.Assert;
//
//import org.junit.Test;
//
//import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;
//
///**
// * This method tests the player action "open the cup".
// * Created by Snaki on 18.11.2017.
// */
//
//public class PlayerActionOpenTheCupTest extends PlayerTest {
//    /**
//     * This method tests the open the cup function.
//     */
//    @Test
//    public void openTheCupTest1(){
//        for(final Player player: players) {
//            try {
//                player.openCup();
//                Assert.fail("The player can not open the cup. The player has to roll the dices first");
//            } catch (PlayerActionNotAllowedException e) {
//            }
//            try {
//                player.rollTheDice();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can roll the dices");
//            }
//
//            try {
//                player.openCup();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can open the cup now!");
//            }
//        }
//    }
//
//    /**
//     * This method test the player action "open the cup"
//     */
//    @Test
//    public void openTheCupTest2(){
//        for(final Player player: players) {
//            try {
//                player.rollTheDice();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can roll the dices");
//            }
//            try {
//                player.openCup();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can open the cup");
//            }
//            try {
//                player.rollTheDice();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can roll the dices");
//            }
//            try {
//                player.openCup();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can open the cup");
//            }
//            try {
//                player.rollTheDice();
//            } catch (PlayerActionNotAllowedException e) {
//                Assert.fail("The player can roll the dices");
//            }
//            try {
//                player.openCup();
//                Assert.fail("The player can not open the cup");
//            } catch (PlayerActionNotAllowedException e) {
//
//            }
//        }
//    }
//}
