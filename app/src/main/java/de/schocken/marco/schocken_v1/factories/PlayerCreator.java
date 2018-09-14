package de.schocken.marco.schocken_v1.factories;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

public class PlayerCreator {

    private static PlayerCreator INSTANCE = new PlayerCreator();

    private PlayerCreator(){

    }

    public List<Player> createPlayers(final String[] playersNames, final PlayerCallback playerCallback){
        List<Player> players = new ArrayList<>();
        for(String playerName : playersNames){
            final Player player = new PlayerImpl(playerName,playerCallback);
            // TODO: check if already in the list ?
            players.add(player);
        }
         return players;
    }

    public static PlayerCreator getINSTANCE() {
        return INSTANCE;
    }
}
