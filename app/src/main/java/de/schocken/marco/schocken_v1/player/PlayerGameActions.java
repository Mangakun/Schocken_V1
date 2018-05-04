package de.schocken.marco.schocken_v1.player;

import java.util.List;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.player.PlayerActions;
import de.schocken.marco.schocken_v1.player.exceptions.MaxCoastersException;

/**
 * This interface is an extension of the interface {@link PlayerActions}.
 * This interface contains all method to get information from the player actions.
 * Created by Snaki on 18.11.2017.
 */

public interface PlayerGameActions {

    /**
     * This method returns the coasters of the player.
     * @return
     */
    int getCoasters();

    /**
     * This method adds the given coasters to the player coasters.
     * @param coasters The coasters, which shoould be added
     */
    void addCoasters(int coasters) throws MaxCoastersException;

    /**
     * This method sets the coasters of the player.
     * @param coasters
     */
    void setCoasters(int coasters) throws MaxCoastersException;

    /**
     * This method starts the next half for the player.
     */
    void nextHalf();

    /**
     * This method starts the next round for the player.
     */
    void nextRound();

    /**
     * This method starts the next game for the player.
     */
    void nextGame();

    /**
     * This method returns the halfs of the player.
     * @return The count of the halfs.
     */
    int getHalfs();
}



//    /**
//     * This method returns the amount of coasters which belongs to the players dice value.
//     * @return The coasters of the players dice value.
//     */
//    int getCoastersOfDiceValue();
//
//    /**
//     * This method returns the dices, which has the player out.
//     * @return A list of dices which has the player out.
//     */
//    List<Dice> getDicesOuts();


//    /**
//     * This method returns the number which the player has out.
//     * @return The number of dices out.
//     */
//    int getNumberOfOutDices();
//
//    /**
//     * This method returns the dice value of the player.
//     * @return The dice value.
//     */
//    int getDiceValue();