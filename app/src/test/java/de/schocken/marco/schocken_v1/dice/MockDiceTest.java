package de.schocken.marco.schocken_v1.dice;

import org.junit.Test;

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
}
