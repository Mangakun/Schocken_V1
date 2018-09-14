package de.schocken.marco.schocken_v1.gameobserver;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.factories.PlayerCreator;
import de.schocken.marco.schocken_v1.gameobserver.impl.GameObserverImpl;
import de.schocken.marco.schocken_v1.player.Player;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MockGameObserverTest {

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    @Mock
    PlayerCreator playerCreator;

    @Mock
    PlayerCallback playerCallback;


    GameObserver gameObserver = new GameObserverImpl();

    @Test
    public void createPlayersTest(){
        List<Player> players1 = spy(new ArrayList<Player>());
        players1.add(player1);
        players1.add(player2);

        try {
            Field instance = PlayerCreator.class.getDeclaredField("INSTANCE");
            instance.setAccessible(true);
            instance.set(instance, playerCreator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        when(playerCreator.createPlayers(ArgumentMatchers.any(String[].class),ArgumentMatchers.any(PlayerCallback.class))).thenReturn(players1);
        when(player1.getName()).thenReturn("Marco");
        when(player2.getName()).thenReturn("Michelle");
        gameObserver.createPlayers(new String[]{
        });
        gameObserver.newGame();
        Assert.assertEquals("Name shourl be Marco", "Marco", gameObserver.getCurrentPlayer().getName());
    }


}
