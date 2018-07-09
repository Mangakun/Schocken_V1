package de.schocken.marco.schocken_v1.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerCallBackTest {

   @Mock private PlayerCallback playerCallback;
   @InjectMocks private Player player = new PlayerImpl(null,null);

    @Test
    public void playerCallBackTest(){

//        player.call();
//        verify(playerCallback).callback(false);
    }
}
