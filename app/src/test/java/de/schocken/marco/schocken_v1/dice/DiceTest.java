package de.schocken.marco.schocken_v1.dice;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import de.schocken.marco.schocken_v1.dice.exceptions.DiceValueNotInIntervalException;
import de.schocken.marco.schocken_v1.dice.impl.DiceImpl;

/**
 * This class tests the functions of a dice.
 * Created by Snaki on 02.12.2017.
 */

public class DiceTest {

    /**
     * An object of the class {@link Dice}.
     */
    private static Dice dice;

    /**
     * This method creates a dice object.
     */
    @BeforeClass
    public static void createDice(){
        dice = new DiceImpl();
    }

    /**
     * This method tests the roll and getValue function of the dice.
     */
    @Test
    public void rollAndValueTest(){
        dice.roll();
        Assert.assertTrue("The dice value should be between 1 and 6", dice.getValue() >= 1 && dice.getValue() <= 6);
    }

    /**
     * This method tests multiple times the roll and getValue function of the dice.
     */
    @Test
    public void multipleRollAndValueTest(){
        for(int i=0;i<1000;++i){
            dice.roll();
            Assert.assertTrue("The dice value should be between 1 and 6", dice.getValue() >= 1 && dice.getValue() <= 6);
        }
    }



}
