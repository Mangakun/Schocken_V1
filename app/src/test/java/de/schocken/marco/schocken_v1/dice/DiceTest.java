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

    /**
     * This method tests the function setValue
     */
    @Test
    public void setValueTest(){
        for(int i=1;i<7;++i){
            try {
                dice.setValue(i);
            } catch (DiceValueNotInIntervalException e) {
                Assert.fail("The dice value "+i+" can be set");
            }
        }
        try {
            dice.setValue(7);
            Assert.fail("The dice value 7 can not be set");
        } catch (DiceValueNotInIntervalException e) {

        }
    }

    /**
     * This methods tests multiple the function setValue
     */
    @Test
    public void multipleSetValueTest(){
        for(int i=0; i<10000;++i){
            int diceValue = (int)(Math.random()*100);
            try {
                dice.setValue(diceValue);
                if (diceValue > 6){
                    Assert.fail("The dice value "+diceValue+" can not be set");
                }
            } catch (DiceValueNotInIntervalException e) {
                if(diceValue >= 1 && diceValue <= 6){
                    Assert.fail("The dice value "+diceValue+" can be set");
                }
            }
        }
    }

}
