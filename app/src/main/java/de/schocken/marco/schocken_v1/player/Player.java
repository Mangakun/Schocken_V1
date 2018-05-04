package de.schocken.marco.schocken_v1.player;

/**
 * This interface is an extension of {@link PlayerGameActions}.
 * This interface contains methods of a player.
 * Created by Snaki on 07.11.2017.
  */

public interface Player  extends PlayerActions,PlayerGameActions,PlayerDiceActions{

    /**
     * This method returns the name of the {@link Player}.
     * @return The name of the player
     */
    String getName();

}
