package de.schocken.marco.schocken_v1.dice;

import junit.framework.Assert;

import org.junit.Test;

import de.schocken.marco.schocken_v1.dice.impl.DiceImpl;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class is a mock class for a dice test.
 */
public class MockDiceTest {


    @Test
    public void verifyRollCall(){
        Dice dice = mock(Dice.class);
        when(dice.getValue()).thenReturn(2);
        assertEquals(dice.getValue(), 2);
    }


    @Test
    public void compareToTest(){
        Dice dice1 = new DiceImpl();
        Dice dice2 = new DiceImpl();
        Dice diceSpy = spy(dice1);
        Dice diceSpy2 = spy(dice2);
        when(diceSpy.getValue()).thenReturn(3);
        when(diceSpy2.getValue()).thenReturn(1);
        Assert.assertTrue("The return value should be less than zero", diceSpy.compareTo(diceSpy2) < 0);
    }
}
