package de.schocken.marco.schocken_v1.gameobserver;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.schocken.marco.schocken_v1.factories.PlayerCreator;
import de.schocken.marco.schocken_v1.gameobserver.impl.GameObserverImpl;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameObserverCallBackTest {


    @Test
    public void  gameObserverCallBackTest1(){
        GameObserver gameObserver = spy(new GameObserverImpl());


        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("hier");
                //invocation.


                return null;
            }
        }).when(gameObserver).createPlayers(ArgumentMatchers.any());

        gameObserver.createPlayers(new String[] {});



//        PlayerCreator playerCreator = mock(PlayerCreator.class);
//
//        Player player1 = spy(Player.class);
//        Player player2 = spy(Player.class);
//
//        List<Player> players1 = spy(new ArrayList<Player>());
//        players1.add(player1);
//        players1.add(player2);
//
//        doAnswer(new Answer<Void>() {
//            @Override
//            public Void answer(InvocationOnMock invocation) throws Throwable {
//                System.out.println("hier");
//                player1.stay();
//
//                return null;
//            }
//        }).when(player1).turn();
//
//        when(player1.getName()).thenReturn("Marco");
//        try {
//            doCallRealMethod().when(player1).stay();
//        } catch (PlayerActionNotAllowedException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//
//        try {
//            Field instance = PlayerCreator.class.getDeclaredField("INSTANCE");
//            instance.setAccessible(true);
//            instance.set(instance, playerCreator);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        when(playerCreator.createPlayers(ArgumentMatchers.any(String[].class),ArgumentMatchers.any(PlayerCallback.class))).thenReturn(players1);
//        gameObserver.createPlayers(new String[]{
//        });
//
//        gameObserver.newGame();
//        verify(gameObserver).newGame();
//        Assert.assertEquals("Name shourl be Marco", "Marco", gameObserver.getCurrentPlayer().getName());
//        verify(player1).turn();

    }

}
