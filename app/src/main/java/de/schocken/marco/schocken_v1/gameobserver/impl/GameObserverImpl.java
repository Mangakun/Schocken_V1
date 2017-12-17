package de.schocken.marco.schocken_v1.gameobserver.impl;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.gameobserver.GameObserver;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

/**
 * Created by Snaki on 16.12.2017.
 * This class is an implementation class of a game observer.
 * This class manages the game.
 */

public class GameObserverImpl implements GameObserver {

    private List<Player> players;
    private Player currentPlayer;
    private Player currentBestPlayer;
    private Player currentWorstPlayer;
    private int penaltyStack; // TODO get from settings

    /**
     * Constructor of the class {@link GameObserverImpl}.
     * @param playerNames An array of player names
     */
    public GameObserverImpl(final String[] playerNames){
        currentBestPlayer = null;
        currentBestPlayer = null;
        currentWorstPlayer = null;
        penaltyStack = 13;
        createPlayers(playerNames);
    }

    /**
     * This method creates players based on the player names.
     * @param playerNames An array of names
     */
    private void createPlayers(final String[] playerNames){
        players = new ArrayList<>();
        for(String playerName : playerNames){
            final Player player = new PlayerImpl(playerName);
            // TODO: check if already in the list ?
            players.add(player);
        }
    }

    @Override
    public void startGame() {
        // erster Spieler startet bisher das Spiel
        /*
        Eine andere Möglichkeit wäre, dass jeder würfelt und
         */
    }

    /**
     * This method determine the current worst player.
     */
    private void determineCurrentWorstPlayer(){
        // not determined yet
        if(currentWorstPlayer == null){
            currentWorstPlayer = currentPlayer;
        }else{
            final int currentWorstPlayerDiceValue = currentWorstPlayer.getDiceValue();
            final int currentPlayerDiceValue = currentPlayer.getDiceValue();
            // worst dice value
            if(currentPlayerDiceValue < currentWorstPlayerDiceValue){
                currentWorstPlayer = currentWorstPlayer;
            }else{
                // same dice value
                if(currentPlayerDiceValue == currentWorstPlayerDiceValue){
                    // look for throws needed
                    if(currentPlayer.getDiceThrows() > currentWorstPlayer.getDiceThrows()){
                        currentWorstPlayer = currentWorstPlayer;
                    }
                }
            }
        }
    }

    /**
     * This method determine the current best player.
     */
    private void determineCurrentBestPlayer(){
        // not determined yet
        if(currentBestPlayer == null){
            currentBestPlayer = currentPlayer;
        }else{
            final int currentBestPlayerDiceValue = currentBestPlayer.getDiceValue();
            final int currentPlayerDiceValue = currentPlayer.getDiceValue();
            // worst dice value
            if(currentPlayerDiceValue > currentBestPlayerDiceValue){
                currentBestPlayer = currentWorstPlayer;
            }else{
                // same dice value
                if(currentPlayerDiceValue == currentBestPlayerDiceValue){
                    // look for throws needed
                    if(currentPlayer.getDiceThrows() < currentBestPlayer.getDiceThrows()){
                        currentBestPlayer = currentWorstPlayer;
                    }
                }
            }
        }
    }
}
