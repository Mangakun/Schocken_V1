package de.schocken.marco.schocken_v1.player;

import java.util.List;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.DiceValue;
import de.schocken.marco.schocken_v1.player.exceptions.DiceNotFoundException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxDiceException;


/**
 * Created by Snaki on 02.12.2017.
 */

public interface PlayerDiceActions {

    /**
     * TODO: documentation
     * @param diceValue
     * @throws MaxDiceException
     */
    void diceBackIn(final DiceValue diceValue)throws DiceNotFoundException;

    /**
     * TODO: documentation
     * @param diceValue
     * @throws MaxDiceException
     */
    void diceOut(final DiceValue diceValue) throws DiceNotFoundException;

    /**
     * TODO: documentation.
     * @return
     */
    List<DiceValue> getDicesValuesIn();

    /**
     * TODO: documentation.
     * @return
     */
    List<DiceValue> getDicesValuesOut();



}
/**
 //     * This method adds dices to the player.
 //     * This method is for testing.
 //     * @param dice An object of the class {@link Dice}.
 //     * @throws MaxAddDiceException
 //     */
//    //void addDiceToDiceOuts(final Dice dice) throws MaxAddDiceException;
//
//   // void clearDiceOuts();
//
//    /**
//     * This method returns the value of a dice of a giving index.
//     * @param index The index
//     * @return The dice value of the dice by the given index.
//     * @throws IndexOutOfBoundsException
//     */
//    int getDiceValueOfDiceOut(int index) throws  IndexOutOfBoundsException;
//
//    /**
//     * This method returns the dice value of the player.
//     * @return The dice value.
//     */
//    int getDiceValue();