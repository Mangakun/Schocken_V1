package de.schocken.marco.schocken_v1.dice;

import de.schocken.marco.schocken_v1.dice.exceptions.DiceValueNotInIntervalException;

/**
 * Created by Snaki on 02.12.2017.
 */

public interface Dice extends Comparable<Dice>{

    /**
     * This method rolls the dice.
     */
    void roll();

    /**
     * This method returns the value of the dice.
     * @return The dice value.
     */
    int getValue();

    /**
     * This method sets the value of the dice.
     * @param value The value of the dice.
     */
    void setValue(int value) throws DiceValueNotInIntervalException;
}

