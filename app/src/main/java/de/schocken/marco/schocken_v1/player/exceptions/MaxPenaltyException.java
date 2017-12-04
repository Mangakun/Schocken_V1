package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of an {@link Exception}.
 * This exception handles an max penalty exception
 * Created by Snaki on 18.11.2017.
 */
public class MaxPenaltyException extends Exception {

    /**
     * Constructor of the class {@link MaxPenaltyException}.
     */
    public MaxPenaltyException(int maxPenalties){
        super("The penalties can not be more than "+maxPenalties);
    }
}
