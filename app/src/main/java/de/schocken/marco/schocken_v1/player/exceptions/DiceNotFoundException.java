package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of the class {@link Exception}.
 * This exceptions is triggered when to much dices are added to the player.
 * Created by Snaki on 02.12.2017.
 */

public class DiceNotFoundException extends Exception {

    /**
     * Constructor of the class {@link DiceNotFoundException}.
     */
    public DiceNotFoundException(int diceValue){
        super("The dice value ("+diceValue+") can not be found"); // TODO: from seetings holen
    }
}
