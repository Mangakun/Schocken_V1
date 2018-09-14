package de.schocken.marco.schocken_v1.gameobserver;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.gameobserver.impl.GameObserverImpl;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Snaki on 16.12.2017.
 * This class is a test class for testing the game observer.
 */

public class GameObserverAddPlayersTest {

//    @Test
//    public void gameObserverAddPlayersTest1(){
//        Player player1 = mock(Player.class);
//        Player player2 = mock(Player.class);
//        GameObserver gameObserver = new GameObserverImpl();
//        List<Player> list = new ArrayList<>();
//        list.add(player1);
//        list.add(player2);
//        gameObserver.addPlayers(list);
//        when(player1.getName()).thenReturn("Marco");
//        when(player2.getName()).thenReturn("Michelle");
//        gameObserver.newGame();
//        Assert.assertEquals("Der Name sollte gleich sein!",gameObserver.getCurrentPlayer().getName(),player1.getName());
//
//    }
//

}
