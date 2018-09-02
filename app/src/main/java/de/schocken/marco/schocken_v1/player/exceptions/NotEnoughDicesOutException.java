package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of the class {@link Exception}.
 * This exceptions is triggered when to much dices are added to the player.
 * Created by Snaki on 02.12.2017.
 */

public class NotEnoughDicesOutException extends Exception {

    /**
     * Constructor of the class {@link NotEnoughDicesOutException}.
     */
    public NotEnoughDicesOutException(){
        super("There are not enough dices out"); // TODO: from seetings holen
    }
}
