package de.schocken.marco.schocken_v1.player;

/**
 * This interface contains all methods which are necessary for the game.
 * Created by Snaki on 26.11.2017.
 */

public interface GameActions {

    /**
     * A new round is called.
     */
    void newRound();

    /**
     * A new game is called.
     */
    void newGame();

    /**
     * The game about the next half started.
     */
    void nextHalf();
}
