package de.schocken.marco.schocken_v1.player;

import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * THis interface contains all player actions which are allowed.
 * Created by Snaki on 18.11.2017.
 */

public interface PlayerActions{

    /**
     * The player finishes his round.
     * @throws PlayerActionNotAllowedException
     */
    void stay() throws PlayerActionNotAllowedException;

    /**
     * The player rolls the dices.
     * @throws PlayerActionNotAllowedException
     */
    void rollTheDice() throws PlayerActionNotAllowedException;

    /**
     * The player opens his cup.
     * @throws PlayerActionNotAllowedException
     */
    void openCup() throws PlayerActionNotAllowedException;

    void turn();
}


