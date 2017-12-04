package de.schocken.marco.schocken_v1.player.enums;

/**
 * Created by Snaki on 18.11.2017.
 */

public enum PlayerActions {

    BLOCK("Block","TODO: description");
    private final String nameOfPlayerAction;

    private final String descriptionOfPlayerAction;

    private PlayerActions(final String nameOfPlayerAction, final String descriptionOfPlayerAction){
    this.nameOfPlayerAction = nameOfPlayerAction;
    this.descriptionOfPlayerAction = descriptionOfPlayerAction;

    }

}
