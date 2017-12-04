package de.schocken.marco.schocken_v1.player.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.impl.DiceImpl;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.exceptions.MaxAddDiceException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxPenaltyException;
import de.schocken.marco.schocken_v1.player.exceptions.PlayerActionNotAllowedException;

/**
 * An implementation class of a player.
 * Created by Snaki on 18.11.2017.
 */

public class PlayerImpl implements Player {
    /**
     * A msg string for debug.
     */
    private final String debugMSG = "Player";

    /**
     * The name of the player.
     */
    private final String playerName;

    /**
     * The dice throws of a player.
     */
    private int diceThrows;

    /**
     * This variable stores a blind call from the player.
     */
    private boolean blindCall;

    /**
     * This variable stores if the player has finished the round.
     */
    private boolean roundFinished;

    /**
     * This variable stores if the player can roll
     */
    private boolean canRoll;

    /**
     * This variable stores if the player already opened the cup.
     */
    private boolean alreadyOpenedCup;

    /**
     * The penalties of the player.
     */
    private int playerPenalties;

    /**
     * A list of dices which set the player out.
     */
    private List<Dice> dicesOut;

    /**
     * A list of dices which has the player under the cup and can roll with it.
     */
    private List<Dice> dicesIn;

    /**
     * Constructor of the class {@link PlayerImpl}.
     *
     * @param playerName The name of the player.
     */
    public PlayerImpl(final String playerName) {
        Log.d(debugMSG,"Constructor of the class Player");
        this.playerName = playerName;
        dicesIn = new ArrayList<>();
        for(int i=0; i<3;++i){// TODO: aus settings holen
            dicesIn.add(new DiceImpl());
        }
        dicesOut = new ArrayList<>();
    }

    @Override
    public String getName() {
        Log.d(debugMSG,"Method getName()");
        return playerName;
    }

    @Override
    public void stay() throws PlayerActionNotAllowedException {
        Log.d(debugMSG,"Method stay()");
        if (diceThrows > 0 && diceThrows <=3 && !blindCall){ // TODO: 3 von settings holen
            roundFinished = true;
        }else{
            throw new PlayerActionNotAllowedException("The player cant call stay"); // TODO:von Strings.xml holen ?
        }
    }

    @Override
    public void rollTheDice() throws PlayerActionNotAllowedException {
        Log.d(debugMSG, "Method rollTheDice()");
        if(diceThrows >= 3 || roundFinished || !canRoll){// TODO: 3 von settings holen
            throw new PlayerActionNotAllowedException("The player can not roll the dices"); //TODO: von Strings.xml nehmen ?
        }
        ++diceThrows;
        for(int i=0; i<dicesIn.size();++i) {
            dicesIn.get(i).roll();
        }
            canRoll = false;
        alreadyOpenedCup = false;
    }

    @Override
    public void openCup() throws PlayerActionNotAllowedException {
        Log.d(debugMSG,"Method openCup()");
        /*
        The player can only open the cup, when
        - he has not call blind
        - he has already opened the cup
        - he has not finished yet
         */
        if(diceThrows > 0  && diceThrows < 3 && !blindCall && !alreadyOpenedCup && !roundFinished){
            // TODO: was soll hier gemacht werden
            canRoll = true;
            alreadyOpenedCup = true;
        }else{
            throw new PlayerActionNotAllowedException("The player can not open the cup"); // TODO: aus trings.xml ?
        }
    }

    @Override
    public void blind() throws PlayerActionNotAllowedException {
        Log.d(debugMSG,"Method blind()");
        /*
        Theplayer can call blind, when
        - the player has not called blind before
        - The player has not
         */
        if(diceThrows == 1 && !blindCall && !alreadyOpenedCup/*&&!startPlayer*/){ //TODO: mit einbauen
            Log.d(debugMSG,"player is calling blind");
            blindCall = true;
        }else{
            throw new PlayerActionNotAllowedException("The player can not call blind"); // TODO: aus trings.xml ?
        }
    }

    @Override
    public void block() throws PlayerActionNotAllowedException {
        Log.d(debugMSG,"Method block");
    }

    @Override
    public int getDiceThrows() {
        Log.d(debugMSG,"return dice throws ("+diceThrows+")");
        return diceThrows;
    }

    @Override
    public boolean isBlindCall() {
        Log.d(debugMSG,"return is blind call ("+blindCall+")");
        return blindCall;
    }

    @Override
    public boolean isRoundFinished() {
        Log.d(debugMSG,"return round finished ("+roundFinished+")");
        return roundFinished;
    }

    @Override
    public void newRound() {
        Log.d(debugMSG,"MEthod newRound()");
        diceThrows = 0;
        // TODO: clear outs
        blindCall = false;
        roundFinished = false;
        canRoll = true;
        alreadyOpenedCup = false;
    }

    @Override
    public void newGame() {
        Log.d(debugMSG,"Method newGame()");
        // TODO: set halfs to zero
        nextHalf();
    }

    @Override
    public void nextHalf() {
        Log.d(debugMSG,"Method nextHalf()");
        newRound();
        playerPenalties = 0;
    }

    @Override
    public void addPenalties(int penalties) throws MaxPenaltyException {
        Log.d(debugMSG,playerName + " gets "+penalties+" penalties");
        if(playerPenalties+penalties > 13){ //TODO: von settings holen
            throw new MaxPenaltyException(13);
        }
        playerPenalties+=penalties;
    }

    @Override
    public void setPenalties(int penalties) throws MaxPenaltyException {
        Log.d(debugMSG,playerName + " gets "+penalties+" penalties");
        if(penalties > 13){
            throw new MaxPenaltyException(13);
        }
        playerPenalties = penalties;
    }

    @Override
    public int getPenalties() {
        return playerPenalties;
    }

    @Override
    public int getDiceValueOfDiceOut(int index) throws IndexOutOfBoundsException {
        return dicesOut.get(index).getValue();
    }

    /*
    @Override
    public void addDiceToDiceOuts(Dice dice) throws MaxAddDiceException {
        if(dicesOut.size()+1 > 3){ // TODO: aus settings holen
            throw new MaxAddDiceException(3);
        }
        dicesOut.add(dice);
    }

    @Override
    public void clearDiceOuts() {
        dicesOut.clear();
    }
    */
}
