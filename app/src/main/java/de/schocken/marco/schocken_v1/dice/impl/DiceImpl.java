package de.schocken.marco.schocken_v1.dice.impl;

import android.graphics.Color;
import android.support.annotation.NonNull;

import java.util.Random;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.exceptions.DiceValueNotInIntervalException;

/**
 * Created by Snaki on 02.12.2017.
 */

public class DiceImpl implements Dice{
    /**
     * The value of the dice.
     */
    private int diceValue;

    /**
     * An object of the class {@link Random}.
     */
    private Random random;

    /**
     * Constructor of the class {@link DiceImpl}.
     */
    public DiceImpl() {
        this.diceValue = -1;
        random = new Random();
    }

    /**
     * Constructor of the class {@link DiceImpl}.
     * @param diceValue The start value which should the dice have.
     */
    public DiceImpl(final int diceValue){
        this.diceValue = diceValue;
        random = new Random();
    }

    @Override
    public void roll() {
        diceValue = (random.nextInt(6) + 1);
    }

    @Override
    public int getValue() {
        return diceValue;
    }

    @Override
    public void setValue(int value) throws DiceValueNotInIntervalException {
        if(value < 1 || value > 6){
            throw new DiceValueNotInIntervalException(value);
        }
        diceValue = value;
    }

    @Override
    public int compareTo(@NonNull final Dice another) {
        return another.getValue() - this.diceValue;
    }

    @Override
    public String toString() {
        return "DiceImpl{" +
                "diceValue=" + diceValue +
                ", random=" + random +
                '}';
    }

}
