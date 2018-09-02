package de.schocken.marco.schocken_v1.dice.impl;

import android.support.annotation.NonNull;

import java.util.Random;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.DiceValue;

/**
 * Created by Snaki on 02.12.2017.
 */

public class DiceImpl implements Dice {
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

    @Override
    public void roll() {
        diceValue = (random.nextInt(6) + 1);
    }

    @Override
    public int getValue() {
        return diceValue;
    }



    @Override
    public int compareTo(@NonNull final DiceValue another) {
        System.out.println("hier");
        return another.getValue() - getValue();
    }

    @Override
    public String toString() {
        return "DiceImpl{" +
                "diceValue=" + diceValue +
                ", random=" + random +
                '}';
    }

}