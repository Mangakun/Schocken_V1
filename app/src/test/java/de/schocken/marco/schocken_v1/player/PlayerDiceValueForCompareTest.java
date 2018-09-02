package de.schocken.marco.schocken_v1.player;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.dice.DiceValue;
import de.schocken.marco.schocken_v1.dice.impl.DiceImpl;
import de.schocken.marco.schocken_v1.player.exceptions.NotEnoughDicesOutException;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class PlayerDiceValueForCompareTest {

    @Test
    public void playerDiceValueForCompareTest1(){
        // dice 1
        DiceValue value1 = spy(new DiceImpl());
        when(value1.getValue()).thenReturn(3);
        // dice 2
        DiceValue value2 = spy(new DiceImpl());
        when(value2.getValue()).thenReturn(3);
        // dice 3
        DiceValue value3 = spy(new DiceImpl());
        when(value3.getValue()).thenReturn(3);
        // create list
        List<DiceValue> list = new ArrayList<DiceValue>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        // mock player
        Player player = spy(new PlayerImpl(null,null));
        when(player.getDicesValuesOut()).thenReturn(list);
        try {
            Assert.assertEquals(3333,player.getDiceValueForCompare());
        } catch (NotEnoughDicesOutException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void playerDiceValueForCompareTest2(){
        // dice 1
        DiceValue value1 = spy(new DiceImpl());
        when(value1.getValue()).thenReturn(3);
        // dice 2
        DiceValue value2 = spy(new DiceImpl());
        when(value2.getValue()).thenReturn(5);
        // dice 3
        DiceValue value3 = spy(new DiceImpl());
        when(value3.getValue()).thenReturn(4);
        // create list
        List<DiceValue> list = new ArrayList<DiceValue>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        // mock player
        Player player = spy(new PlayerImpl(null,null));
        when(player.getDicesValuesOut()).thenReturn(list);
        try {
            Assert.assertEquals(2543,player.getDiceValueForCompare());
        } catch (NotEnoughDicesOutException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void playerDiceValueForCompareTest3(){
        // dice 1
        DiceValue value1 = spy(new DiceImpl());
        when(value1.getValue()).thenReturn(1);
        // dice 2
        DiceValue value2 = spy(new DiceImpl());
        when(value2.getValue()).thenReturn(5);
        // dice 3
        DiceValue value3 = spy(new DiceImpl());
        when(value3.getValue()).thenReturn(1);
        // create list
        List<DiceValue> list = new ArrayList<DiceValue>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        // mock player
        Player player = spy(new PlayerImpl(null,null));
        when(player.getDicesValuesOut()).thenReturn(list);
        try {
            Assert.assertEquals(55110,player.getDiceValueForCompare());
        } catch (NotEnoughDicesOutException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void playerDiceValueForCompareTest4(){
        // dice 1
        DiceValue value1 = spy(new DiceImpl());
        when(value1.getValue()).thenReturn(1);
        // dice 2
        DiceValue value2 = spy(new DiceImpl());
        when(value2.getValue()).thenReturn(1);
        // dice 3
        DiceValue value3 = spy(new DiceImpl());
        when(value3.getValue()).thenReturn(1);
        // create list
        List<DiceValue> list = new ArrayList<DiceValue>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        // mock player
        Player player = spy(new PlayerImpl(null,null));
        when(player.getDicesValuesOut()).thenReturn(list);
        try {
            Assert.assertEquals(131110,player.getDiceValueForCompare());
        } catch (NotEnoughDicesOutException e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void playerDiceValueForCompareTest5(){
        // dice 1
        DiceValue value1 = spy(new DiceImpl());
        when(value1.getValue()).thenReturn(6);
        // dice 2
        DiceValue value2 = spy(new DiceImpl());
        when(value2.getValue()).thenReturn(5);
        // dice 3
        DiceValue value3 = spy(new DiceImpl());
        when(value3.getValue()).thenReturn(6);
        // create list
        List<DiceValue> list = new ArrayList<DiceValue>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        // mock player
        Player player = spy(new PlayerImpl(null,null));
        when(player.getDicesValuesOut()).thenReturn(list);
        try {
            Assert.assertEquals(1665,player.getDiceValueForCompare());
        } catch (NotEnoughDicesOutException e) {
            Assert.fail(e.getMessage());
        }
    }
}
