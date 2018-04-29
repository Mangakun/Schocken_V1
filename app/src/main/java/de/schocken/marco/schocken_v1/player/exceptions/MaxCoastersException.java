package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of the class {@link Exception}.
 * This exceptions is triggered when to much dices are added to the player.
 * Created by Snaki on 02.12.2017.
 */

public class MaxCoastersException extends Exception {

    /**
     * Constructor of the class {@link MaxCoastersException}.
     */
    public MaxCoastersException(){
        super("The player can not have more than 13 coasters");
    }
}
