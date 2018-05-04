package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of the class {@link Exception}.
 * This exceptions is triggered when to much dices are added to the player.
 * Created by Snaki on 02.12.2017.
 */

public class MaxDiceException extends Exception {

    /**
     * Constructor of the class {@link MaxDiceException}.
     */
    public MaxDiceException(){
        super("The player can only play with "+3+" dices"); // TODO: from seetings holen
    }
}
