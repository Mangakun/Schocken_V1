package de.schocken.marco.schocken_v1.player;

import android.support.annotation.VisibleForTesting;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.player.exceptions.MaxAddDiceException;

/**
 * Created by Snaki on 02.12.2017.
 */

public interface PlayerDiceActions extends PlayerActionInformation{


    /**
     * This method adds dices to the player.
     * This method is for testing.
     * @param dice An object of the class {@link Dice}.
     * @throws MaxAddDiceException
     */
    //void addDiceToDiceOuts(final Dice dice) throws MaxAddDiceException;

   // void clearDiceOuts();

    /**
     * This method returns the value of a dice of a giving index.
     * @param index The index
     * @return The dice value of the dice by the given index.
     * @throws IndexOutOfBoundsException
     */
    int getDiceValueOfDiceOut(int index) throws  IndexOutOfBoundsException;
}