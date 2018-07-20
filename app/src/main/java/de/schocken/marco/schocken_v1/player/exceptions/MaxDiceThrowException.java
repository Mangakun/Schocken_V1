package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of the class {@link Exception}.
 * This exceptions is triggered when to much dices are added to the player.
 * Created by Snaki on 02.12.2017.
 */

public class MaxDiceThrowException extends Exception {

    /**
     * Constructor of the class {@link MaxDiceThrowException}.
     */
    public MaxDiceThrowException(){
        super("The player can only have maximal 3 dice throws"); // TODO: from seetings holen
    }
}
