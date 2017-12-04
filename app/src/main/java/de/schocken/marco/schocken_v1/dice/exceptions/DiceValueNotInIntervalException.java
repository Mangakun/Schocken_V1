package de.schocken.marco.schocken_v1.dice.exceptions;

/**
 * This class in an extension of an exception.
 * This exception handles the exception that a dice value can only between 1 and 6.
 * Created by Snaki on 02.12.2017.
 */

public class DiceValueNotInIntervalException extends Exception {

    /**
     * Constructor of the class {@link DiceValueNotInIntervalException}.
     * @param diceValue The dice value which triggers the exception.
     */
    public DiceValueNotInIntervalException(int diceValue){
        super("The dice value "+diceValue+" is not in the interval 1 and 6");
    }

}
