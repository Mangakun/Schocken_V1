package de.schocken.marco.schocken_v1.dice;

import de.schocken.marco.schocken_v1.dice.exceptions.DiceValueNotInIntervalException;

/**
 * Created by Snaki on 02.12.2017.
 */

public interface DiceValue extends Comparable<DiceValue>{


    /**
     * This method returns the value of the dice.
     * @return The dice value.
     */
    int getValue();

}

