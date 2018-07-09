package de.schocken.marco.schocken_v1.player;

import android.support.annotation.NonNull;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.DiceValue;
import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockPlayerTest {

    @Test
    public void mockPlayerTest1(){
        Player player = mock(Player.class);
        List<DiceValue> list = spy(new ArrayList<DiceValue>());

        list.add(new DiceValue() {
            @Override
            public int getValue() {
                return 2;
            }

            @Override
            public int compareTo(@NonNull Dice dice) {
                return 0;
            }
        });
        list.add(new DiceValue() {
            @Override
            public int getValue() {
                return 3;
            }

            @Override
            public int compareTo(@NonNull Dice dice) {
                return 0;
            }
        });

        assertEquals(2, list.size());
        when(player.getDicesValuesOut()).thenReturn(list);
        List<DiceValue> returnList = player.getDicesValuesOut();
        assertEquals(2, returnList.size());
        assertEquals(2, returnList.get(1).getValue());
        assertEquals(3, returnList.get(1).getValue());
    }




//    /**
//     * A sequence class, when i use the method thenAnswer -> This means every time the method is called, some thing else is returned.
//     * @param <DiceValue>
//     */
//    private class SequenceAnswer<DiceValue> implements Answer<DiceValue>{
//
//        private Iterator<DiceValue> iterator;
//
//        private DiceValue last;
//
//        public SequenceAnswer(List<DiceValue> list){
//            this.iterator = list.iterator();
//            this.last = list.get(list.size()-1);
//        }
//
//        @Override
//        public DiceValue answer(InvocationOnMock invocation) throws Throwable {
//            if (iterator.hasNext()) {
//                return iterator.next();
//            }
//            return last;
//        }
//    }
}
