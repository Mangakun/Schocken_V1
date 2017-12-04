package de.schocken.marco.schocken_v1.player;

import de.schocken.marco.schocken_v1.player.PlayerActions;

/**
 * This interface is an extension of the interface {@link PlayerActions}.
 * This interface contains all method to get information from the player actions.
 * Created by Snaki on 18.11.2017.
 */

public interface PlayerActionInformation extends PlayerActions {

    /**
     * This method returns the throws of the player.
     * @return The throws of the player.
     */
    int getDiceThrows();

    /**
     * This method returns if the player called blind.
     * @return If the player called blind.
     */
    boolean isBlindCall();

    /**
     * This method returns if the player has finished its round.
     * @return If the player has finished its round.
     */
    boolean isRoundFinished();

}
