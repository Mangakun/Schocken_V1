package de.schocken.marco.schocken_v1.player.exceptions;

/**
 * This class is an extension of the class {@link Exception}.
 * This exceptions is triggered when to much dices are added to the player.
 * Created by Snaki on 02.12.2017.
 */

public class MaxAddDiceException extends Exception {

    /**
     * Constructor of the class {@link MaxAddDiceException}.
     * @param maxDices The maximum of dices which with a player can player.
     */
    public MaxAddDiceException(int maxDices){
        super("The player can only player with "+maxDices+" dices");
    }
}
