package de.schocken.marco.schocken_v1.gameobserver;

import de.schocken.marco.schocken_v1.player.Player;

/**
 * Created by Snaki on 16.12.2017.
 */

public interface GameObserver {

    /**
     * This method starts the game.
     */
    void newGame();


    void nextHalf();

    void nextRound();


    Player getCurrentPlayer();

}
