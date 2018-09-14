package de.schocken.marco.schocken_v1.player.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import de.schocken.marco.schocken_v1.player.exceptions.MaxDiceThrowException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxHalfException;
import de.schocken.marco.schocken_v1.player.exceptions.MaxPenaltyException;
import de.schocken.marco.schocken_v1.player.exceptions.NotEnoughDicesOutException;
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
    private String playerName;

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

    /**
     * An object of the class {@link PlayerCallback}.
     */
    private PlayerCallback playerCallback;

    /**
     * Constructor of the class {@link PlayerImpl}.
     *
     * @param playerName The name of the player.
     */
    public PlayerImpl(final String playerName, final PlayerCallback callback) {
        Log.d(debugMSG, "Constructor of the class Player");
        this.playerName = playerName;
        this.playerCallback = callback;
        dicesIn = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {// TODO: aus settings holen
            dicesIn.add(new DiceImpl());
        }
        dicesOut = new ArrayList<>();
        maxDiceThrows = 3; // TODO: von globalen settings nehmen
        nextGame();
    }

    /*
     * *********************************************
     * interface methods
     * ********************************************
     */


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
            clearPlayerView();
            playerCallback.callback(true); // all dices are out
        } else {
            throw new PlayerActionNotAllowedException("The player cant call stay"); // TODO:von Strings.xml holen ?
        }
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
            if (diceThrows == maxDiceThrows) {
                clearPlayerView();
                playerCallback.callback(false); // because not all dices are out
            } else {
                //set up player view
                setUpPlayerView();
            }

        } else {
            throw new PlayerActionNotAllowedException("The player can not roll the dices"); //TODO: von Strings.xml nehmen ?
        }
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
        if (!dicesOut.contains(diceValue)) {
            new DiceNotFoundException(diceValue.getValue());
        }
        dicesIn.add((Dice) diceValue);
        dicesOut.remove(diceValue);
    }

    @Override
    public void diceOut(final DiceValue diceValue) throws DiceNotFoundException {
        if (!dicesIn.contains(diceValue)) {
            new DiceNotFoundException(diceValue.getValue());
        }
        dicesOut.add((Dice) diceValue);
        dicesIn.remove(diceValue);
    }

    @Override
    public int getDiceValueForCompare() throws  NotEnoughDicesOutException{
        if(getDicesValuesOut().size() <3 ){
            throw new NotEnoughDicesOutException();
        }
        final List<DiceValue> dicesCopy = new ArrayList<>(getDicesValuesOut());
        Collections.sort(dicesCopy);
        for(int i=0;i<dicesCopy.size()-1;++i){
            if(dicesCopy.get(i).getValue() < dicesCopy.get(i+1).getValue()){
                throw new RuntimeException("The dices are not sorted");
            }
        }
        double diceValueForCompare = 0.0;
        int coastersOfDiceValue = getCoastersOfDiceValue();
        for(int i = 0;i<dicesCopy.size();++i){
            diceValueForCompare+=dicesCopy.get(i).getValue()*Math.pow(10,dicesCopy.size()-1-i);
        }
        diceValueForCompare += coastersOfDiceValue * 1000;
        if(dicesCopy.get(1).getValue() == 1){
            diceValueForCompare*=10;
        }
        return (int)diceValueForCompare;
    }

    @Override
    public int getCoastersOfDiceValue() throws  NotEnoughDicesOutException{
        if(getDicesValuesOut().size() <3 ){
            throw new NotEnoughDicesOutException();
        }
        final List<DiceValue> dicesCopy = new ArrayList<>(getDicesValuesOut());
        Collections.sort(dicesCopy);
        for(int i=0;i<dicesCopy.size()-1;++i){
            if(dicesCopy.get(i).getValue() < dicesCopy.get(i+1).getValue()){
                throw new RuntimeException("The dices are not sorted");
            }
        }
        final int diceValue1 = dicesCopy.get(0).getValue();
        final int diceValue2 = dicesCopy.get(1).getValue();
        final int diceValue3 = dicesCopy.get(2).getValue();
        // Schocks
        if(diceValue2 == 1 && diceValue3 == 1){
            if(diceValue1 == 1){
                return 13;
            }
            return diceValue1;
        }else{
            // general
            if(diceValue1==diceValue2 && diceValue2 == diceValue3){
                return 3;

            }else{
                if(diceValue1-1 == diceValue2 && diceValue2-1 == diceValue3){
                    return 2;
                }else{
                    return 1;
                }
            }
        }
    }

    @Override
    public void turn() {


        setUpPlayerView();
    }

    @Override
    public void addHalf() throws MaxHalfException{
        this.halfs += 1;
        if(this. halfs > 2){
            throw new MaxHalfException();
        }
    }
    /*
     * *********************************************
     * private methods
     * ********************************************
     */

    private boolean isAbleToCallStay() {
        if (diceThrows > 0 && diceThrows < 3 && dicesOut.size() != 3) { // TODO :3 from settings
            return true;
        }
        return false;
    }

    private boolean isAbleToRollTheDices() {
        if (dicesIn.size() != 0 && diceThrows < maxDiceThrows) { // TODO :3 from settings
            return true;
        } else {
            return false;
        }
    }

    private boolean isAbleToOpenTheCup() {
        if (dicesIn.size() != 0 && diceThrows == maxDiceThrows) { // TODO :3 from settings
            return true;
        } else {
            return false;
        }
    }

    private void setUpPlayerView() {
        // disable the whole view
        if (isAbleToCallStay()) {
            // enable button
        } else {
            // disable button
        }
        if (isAbleToOpenTheCup()) {
            // enable button
        } else {
            // disable button
        }
        if (isAbleToRollTheDices()) {
            // TODO: enable button
        } else {
            // disable button
        }
    }


    private void clearPlayerView() {

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
    public void setMaxDiceThrows(int maxDiceThrows) throws MaxDiceThrowException{
        this.maxDiceThrows = maxDiceThrows;
        if(this.maxDiceThrows > 3){
            throw new MaxDiceThrowException();
        }
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

//    private boolean containsDiceValue(final List<Dice> list, int diceValue) {
//        boolean found = false;
//        for (final Dice dice : list) {
//            if (dice.getValue() == diceValue) {
//                found = true;
//                break;
//            }
//        }
//        return found;
//    }
//
//    private Dice getDiceObject(final List<Dice> list, int diceValue) {
//        for (final Dice dice : list) {
//            if (dice.getValue() == diceValue) {
//                return dice;
//            }
//        }
//        return null;
//    }