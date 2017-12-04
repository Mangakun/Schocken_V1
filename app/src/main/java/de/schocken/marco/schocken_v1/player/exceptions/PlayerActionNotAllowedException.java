package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of an {@link Exception}.
 * This exception should appear when player actions occurs which are not allowed.
 * Created by Snaki on 18.11.2017.
 */

public class PlayerActionNotAllowedException extends Exception {

    /**
     * Constructor of the class {@link PlayerActionNotAllowedException}.
     * @param exceptionMessage The exception message.
     */
    public PlayerActionNotAllowedException(final String exceptionMessage){
        super(exceptionMessage);
    }
}
