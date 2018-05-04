package de.schocken.marco.schocken_v1.player.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.DiceValue;
import de.schocken.marco.schocken_v1.dice.impl.DiceImpl;
import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.PlayerActions;
import de.schocken.marco.schocken_v1.player.exceptions.DiceNotFoundException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxCoastersException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxDiceException;
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
     * The max dice throws a player has.
     */
    private int maxDiceThrows;

    /**
     * The penalties of the player.
     */
    private int coasters;

    /**
     * A list of dices which set the player out.
     */
    private List<Dice> dicesOut;

    /**
     * A list of dices which has the player under the cup and can roll with it.
     */
    private List<Dice> dicesIn;

    /**
     * The number of halfs.
     */
    private int halfs;
//
//    /**
//     * An object of the class {@link PlayerCallback}.
//     */
//    private PlayerCallback playerCallback;
//
//    /**
//     * This variable stores if the player is the start player of the game.
//     */
//    private boolean startPlayer;
//

    /**
     * Constructor of the class {@link PlayerImpl}.
     *
     * @param playerName The name of the player.
     */
    public PlayerImpl(final String playerName) {
        Log.d(debugMSG, "Constructor of the class Player");
        this.playerName = playerName;
        dicesIn = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {// TODO: aus settings holen
            dicesIn.add(new DiceImpl());
        }
        dicesOut = new ArrayList<>();
        maxDiceThrows = 3; // TODO: von globalen settings nehmen
        nextGame();
    }

//    /*
//     * *********************************************
//     * interface methods
//     * ********************************************
//     */


    @Override
    public void addCoasters(int coasters) throws MaxCoastersException {
        Log.d(debugMSG, playerName + " gets " + coasters + " penalties");
        if (this.coasters + coasters > 13) { //TODO: von settings holen
            throw new MaxCoastersException();
        }
        this.coasters += coasters;
    }


    @Override
    public void stay() throws PlayerActionNotAllowedException {
        Log.d(debugMSG, "Method stay()");
        if (isAbleToCallStay()) {
            dicesOut.addAll(dicesIn);
            dicesIn.clear();
        } else {
            throw new PlayerActionNotAllowedException("The player cant call stay"); // TODO:von Strings.xml holen ?
        }
//        if (diceThrows > 0 && diceThrows <=3 && alreadyUp){ // TODO: 3 von settings holen
//            roundFinished = true;
//        }else{
//
//        }
    }


    @Override
    public void rollTheDice() throws PlayerActionNotAllowedException {
        Log.d(debugMSG, "Method rollTheDice()");
        // check if the player is able to roll the dices
        if (isAbleToRollTheDices()) {
            ++diceThrows;
            for (int i = 0; i < dicesIn.size(); ++i) {
                dicesIn.get(i).roll();
            }
        } else {
            throw new PlayerActionNotAllowedException("The player can not roll the dices"); //TODO: von Strings.xml nehmen ?
        }
//        if(diceThrows >=0 && diceThrows < 3 && !alreadyRolled && !roundFinished && !finishedThrows){
//            // increase dice throws
//            ++diceThrows;
//            // no roll again
//            alreadyRolled = true;
//            alreadyUp = false;
//            for(int i=0; i<dicesIn.size();++i) {
//                dicesIn.get(i).roll();
//            }
//            // reached maximum of throws
//            if(diceThrows == 3){ // TODO: get from settings
//                finishedThrows = true;
//            }
//        }else{
//
//        }
    }


    @Override
    public void openCup() throws PlayerActionNotAllowedException {
        Log.d(debugMSG, "Method openCup()");
        if (isAbleToOpenTheCup()) {

        } else {
            throw new PlayerActionNotAllowedException("The player can not open the cup"); // TODO: aus trings.xml ?
        }
    }


    @Override
    public void nextHalf() {
        coasters = 0;
        nextRound();
    }

    @Override
    public void nextRound() {
        diceThrows = 0;
        dicesOut.clear();
    }

    @Override
    public void nextGame() {
        halfs = 0;
        nextHalf();

    }



    @Override
    public void diceBackIn(final DiceValue diceValue) throws DiceNotFoundException {
       if(!dicesOut.contains(diceValue)){
           new DiceNotFoundException(diceValue.getValue());
       }
       dicesIn.add((Dice) diceValue);
       dicesOut.remove(diceValue);
    }

    @Override
    public void diceOut(final DiceValue diceValue) throws DiceNotFoundException {
        if(!dicesIn.contains(diceValue)){
            new DiceNotFoundException(diceValue.getValue());
        }
        dicesOut.add((Dice) diceValue);
        dicesIn.remove(diceValue);
//        if(!containsDiceValue(dicesIn,diceValue)){
//            throw new DiceNotFoundException(diceValue);
//        }
//        Dice dice = getDiceObject(dicesIn,diceValue);
//        if(dice != null){
//            dicesOut.add(dice);
//            dicesOut.remove(dice);
//        }else{
//            new RuntimeException("Dice object is null!");
//        }

    }

   private boolean containsDiceValue(final List<Dice> list, int diceValue){
        boolean found = false;
        for(final Dice dice : list){
            if(dice.getValue() == diceValue){
                found = true;
                break;
            }
        }
        return found;
    }

    private Dice getDiceObject(final List<Dice> list, int diceValue){
        for(final Dice dice : list){
            if(dice.getValue() == diceValue){
                return dice;
            }
        }
        return null;
    }

    /*
     * *********************************************
     * private methods
     * ********************************************
     */

    private boolean isAbleToCallStay() {
        if (diceThrows > 0 && diceThrows < 3 && dicesOut.size() != 3) {
            return true;
        }
        return false;
    }

    private boolean isAbleToRollTheDices() {
        if (dicesIn.size() != 0 && diceThrows < maxDiceThrows) { // TODO :3 from seetings
            return true;
        } else {
            return false;
        }
    }

    private boolean isAbleToOpenTheCup() {
        if (dicesIn.size() != 0 && diceThrows == maxDiceThrows) { // TODO :3 from seetings
            return true;
        } else {
            return false;
        }
    }


    /*
     * ***********************************
     *  getter and setter
     * ***********************************
     */
    @Override
    public String getName() {
        Log.d(debugMSG, "Method getName()");
        return playerName;
    }


    @Override
    public int getCoasters() {
        return coasters;
    }

    @Override
    public void setCoasters(int coasters) throws MaxCoastersException {
        Log.d(debugMSG, playerName + " gets " + coasters + " penalties");
        if (coasters > 13) { // TODO: aus settings nehmen
            throw new MaxCoastersException();
        }
        this.coasters = coasters;
    }

    @Override
    public int getHalfs() {
        return halfs;
    }

    @Override
    public int getDiceThrows() {
        Log.d(debugMSG, "return dice throws (" + diceThrows + ")");
        return diceThrows;
    }

    @Override
    public List<DiceValue> getDicesValuesIn() {
        return new ArrayList<DiceValue>(dicesIn);
    }

    @Override
    public List<DiceValue> getDicesValuesOut() {
       return new ArrayList<DiceValue>(dicesOut);
    }

}

//    @Override
//    public int getDiceValueOfDiceOut(int index) throws IndexOutOfBoundsException {
//        return dicesOut.get(index).getValue();
//    }
//
//    @Override
//    public int getDiceValue() {
//        return 0;
//    }
//
//
//
//
//    @Override
//    public boolean isRoundFinished() {
//        Log.d(debugMSG,"return round finished ("+roundFinished+")");
//        return roundFinished;
//    }
//
//    @Override
//    public boolean isFinsishedWithThrows() {
//        return finishedThrows;
//    }
//
//    // private boolean isAbleToOpenTheCup(){
//
//    // }
//
//

//
//
//    @Override
//    public void newRound() {
//        Log.d(debugMSG,"Method newRound()");
//        diceThrows = 0;
//        // TODO: clear outs
//        roundFinished = false;
//        alreadyRolled = false;
//        alreadyUp = false;
//    }
//
//    @Override
//    public void newGame() {
//        Log.d(debugMSG,"Method newGame()");
//        // TODO: set halfs to zero
//        nextHalf();
//    }
//
//    @Override
//    public void nextHalf() {
//        Log.d(debugMSG,"Method nextHalf()");
//        newRound();
//        playerPenalties = 0;
//    }
//
//    @Override
//    public void turn(boolean startPlayer,PlayerCallback playerCallback) {
//        Log.d(debugMSG,"Method playerCallback()");
//        this.playerCallback = playerCallback;
//        this.startPlayer = startPlayer;
//    }

//
//
//
//    /*
//    @Override
//    public void addDiceToDiceOuts(Dice dice) throws MaxAddDiceException {
//        if(dicesOut.size()+1 > 3){ // TODO: aus settings holen
//            throw new MaxAddDiceException(3);
//        }
//        dicesOut.add(dice);
//    }
//
//    @Override
//    public void clearDiceOuts() {
//        dicesOut.clear();
//    }
//    */
//