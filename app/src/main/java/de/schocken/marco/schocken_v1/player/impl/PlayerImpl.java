package de.schocken.marco.schocken_v1.player.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.dice.Dice;
import de.schocken.marco.schocken_v1.dice.impl.DiceImpl;
import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.PlayerActions;
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
//
//    /**
//     * This variable stores if the player has finished the round.
//     */
//    private boolean roundFinished;
//
//    /**
//     * This variable stores if the player has finished with this throws.
//     */
//    private boolean finishedThrows;
//
//    /**
//     * This variable stores if the player can roll
//     */
//    private boolean alreadyRolled;
//
//    /**
//     * This variable stores if the player already opened the cup.
//     */
//    private boolean alreadyUp;
//
//    /**
//     * The penalties of the player.
//     */
//    private int playerPenalties;

    /**
     * A list of dices which set the player out.
     */
    private List<Dice> dicesOut;

    /**
     * A list of dices which has the player under the cup and can roll with it.
     */
    private List<Dice> dicesIn;
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
        Log.d(debugMSG,"Constructor of the class Player");
        this.playerName = playerName;
        dicesIn = new ArrayList<>();
        for(int i=0; i<3;++i){// TODO: aus settings holen
            dicesIn.add(new DiceImpl());
        }
        dicesOut = new ArrayList<>();
        maxDiceThrows = 3; // TODO: von globalen settings nehmen
    }
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
//    /*
//     * *********************************************
//     * interface methods
//     * ********************************************
//     */
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
//    @Override
//    public void addPenalties(int penalties) throws MaxPenaltyException {
//        Log.d(debugMSG,playerName + " gets "+penalties+" penalties");
//        if(playerPenalties+penalties > 13){ //TODO: von settings holen
//            throw new MaxPenaltyException(13);
//        }
//        playerPenalties+=penalties;
//    }
//

    private boolean isAbleToCallStay() {
        if(diceThrows > 0 && diceThrows < 3 && dicesOut.size() != 3){
            return true;
        }
        return false;
    }


    @Override
    public void stay() throws PlayerActionNotAllowedException {
        Log.d(debugMSG,"Method stay()");
        if(isAbleToCallStay()){
            dicesOut.addAll(dicesIn);
            dicesIn.clear();
        }else{
            throw new PlayerActionNotAllowedException("The player cant call stay"); // TODO:von Strings.xml holen ?
        }
//        if (diceThrows > 0 && diceThrows <=3 && alreadyUp){ // TODO: 3 von settings holen
//            roundFinished = true;
//        }else{
//
//        }
    }


    private boolean isAbleToRollTheDices(){
        if(dicesOut.size() != 3){ // TODO :3 from seetings
            if(diceThrows < maxDiceThrows) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public void rollTheDice() throws PlayerActionNotAllowedException {
        Log.d(debugMSG, "Method rollTheDice()");
        // check if the player is able to roll the dices
        if(isAbleToRollTheDices()){
            ++ diceThrows;
            for(int i=0; i<dicesIn.size();++i) {
                dicesIn.get(i).roll();
        }
        }else{
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

    private boolean isAbleToOpenTheCup() {
        if (dicesOut.size() != 3 && diceThrows < maxDiceThrows) { // TODO :3 from seetings
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void openCup() throws PlayerActionNotAllowedException {
        Log.d(debugMSG,"Method openCup()");
        if(isAbleToOpenTheCup()){

        }else{
            throw new PlayerActionNotAllowedException("The player can not open the cup"); // TODO: aus trings.xml ?
        }
    }


//
//    /*
//     * *********************************************
//     * private methods
//     * ********************************************
//     */


//
//    // private boolean isAbleToOpenTheCup(){
//
//    // }
//
//
    /*
     * ***********************************
     *  getter and setter
     * ***********************************
     */
    @Override
    public String getName() {
        Log.d(debugMSG,"Method getName()");
        return playerName;
    }
//
//
//    @Override
//    public int getPenalties() {
//        return playerPenalties;
//    }
//
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
//    @Override
//    public void setPenalties(int penalties) throws MaxPenaltyException {
//        Log.d(debugMSG,playerName + " gets "+penalties+" penalties");
//        if(penalties > 13){
//            throw new MaxPenaltyException(13);
//        }
//        playerPenalties = penalties;
//    }
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


    @Override
    public int getDiceThrows() {
        Log.d(debugMSG,"return dice throws ("+diceThrows+")");
        return diceThrows;
    }
}
