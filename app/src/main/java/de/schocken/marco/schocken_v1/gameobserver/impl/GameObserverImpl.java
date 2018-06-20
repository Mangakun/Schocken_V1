package de.schocken.marco.schocken_v1.gameobserver.impl;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.gameobserver.GameObserver;
import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

/**
 * Created by Snaki on 16.12.2017.
 * This class is an implementation class of a game observer.
 * This class manages the game.
 */

public class GameObserverImpl implements GameObserver {

    private List<Player> allPlayers;
    private List<Player> currentPlayers;
    private Player currentPlayer;
    private Player currentBestPlayer;
    private Player currentWorstPlayer;
    private int penaltyStack; // TODO get from settings
    private int maxThrows;

    private Player roundStarter;

    private PlayerCallback playerCallback = new PlayerCallBack();

    /**
     * Constructor of the class {@link GameObserverImpl}.
     * @param playerNames An array of player names
     */
    public GameObserverImpl(final String[] playerNames){
        currentBestPlayer = null;
        currentBestPlayer = null;
        currentWorstPlayer = null;
        currentPlayers = null;
        penaltyStack = 13;
        createPlayers(playerNames);
    }

    /**
     * This method creates players based on the player names.
     * @param playerNames An array of names
     */
    private void createPlayers(final String[] playerNames){
        allPlayers = new ArrayList<>();
        for(String playerName : playerNames){
            final Player player = new PlayerImpl(playerName,playerCallback);
            // TODO: check if already in the list ?
            allPlayers.add(player);
        }
    }

    @Override
    public void newGame() {
        // erster Spieler startet bisher das Spiel
        /*
        Eine andere Möglichkeit wäre, dass jeder würfelt und
         */
        currentPlayers.addAll(allPlayers);

        // init players
        for(final Player player : currentPlayers){
            player.nextGame();
        }
        // first player starts the game
        currentPlayer = currentPlayers.get(0);
        roundStarter = currentPlayer;
        currentPlayer.turn(); // TODO:
    }

    @Override
    public void nextHalf() {

    }

    @Override
    public void nextRound() {
        maxThrows = 3; // TODO: von settings holen
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

//    /**
//     * This method determine the current worst player.
//     */
//    private void determineCurrentWorstPlayer(){
//        // not determined yet
//        if(currentWorstPlayer == null){
//            currentWorstPlayer = currentPlayer;
//        }else{ // TODO :3 from seetings
//            final int currentWorstPlayerDiceValue = currentWorstPlayer.getDiceValue();
//            final int currentPlayerDiceValue = currentPlayer.getDiceValue();
//            // worst dice value
//            if(currentPlayerDiceValue < currentWorstPlayerDiceValue){
//                currentWorstPlayer = currentWorstPlayer;
//            }else{
//                // same dice value
//                if(currentPlayerDiceValue == currentWorstPlayerDiceValue){
//                    // look for throws needed
//                    if(currentPlayer.getDiceThrows() > currentWorstPlayer.getDiceThrows()){
//                        currentWorstPlayer = currentWorstPlayer;
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * This method determine the current best player.
//     */
//    private void determineCurrentBestPlayer(){
//        // not determined yet
//        if(currentBestPlayer == null){
//            currentBestPlayer = currentPlayer;
//        }else{
//            final int currentBestPlayerDiceValue = currentBestPlayer.getDiceValue();
//            final int currentPlayerDiceValue = currentPlayer.getDiceValue();
//            // worst dice value
//            if(currentPlayerDiceValue > currentBestPlayerDiceValue){
//                currentBestPlayer = currentWorstPlayer;
//            }else{
//                // same dice value
//                if(currentPlayerDiceValue == currentBestPlayerDiceValue){
//                    // look for throws needed
//                    if(currentPlayer.getDiceThrows() < currentBestPlayer.getDiceThrows()){
//                        currentBestPlayer = currentWorstPlayer;
//                    }
//                }
//            }
//        }
//    }


    private void roundEnd(){
        // TODO: wenn looser 13 Steine hat -> Spiel für nächste Runde
        // TODO: wenn Looser 13 Steine hat und noch nicht alle Hälften sind verteilt -> nächste Hälfte
        // TODO: wenn Looser 13 Steine hat und alle Hälften sind verteilt -> nächstes Spiel
    }


    private void distributeCoasters(){
        // TODO:
    }

    private void addCurrentPlayers(){
        for (final Player player: allPlayers){

        }
        currentWorstPlayer.turn();
    }

    private void nextPlayer(final int index){
        if(currentPlayers.size()>0){
            if(index == currentPlayers.size()){
                currentPlayer = currentPlayers.get(0);
            }else{
                currentPlayer = currentPlayers.get(index);
            }
            currentPlayer.turn();
        }else{
            // TODO: Spiel müsste vorbei sein
        }
    }

    private void distributeMaxDiceThrows(final int maxDiceThrows){
        for(final Player player: currentPlayers){
            player.setMaxDiceThrows(maxDiceThrows);
        }
    }


    class PlayerCallBack implements PlayerCallback{


        @Override
        public void callback(final boolean finish) {


            // if finish -> take out player
            if(finish){
                if(currentPlayer == roundStarter){
                    // TODO: set global max dice throws
                    distributeMaxDiceThrows( currentPlayer.getDiceThrows());
                }
                // TODO:
              //  determineCurrentWorstPlayer();
              //            determineCurrentBestPlayer();
                // delete current player from list
                int oldIndex = currentPlayers.indexOf(currentPlayer);
                currentPlayers.remove(currentPlayer);
                nextPlayer(oldIndex);
            }else{
                nextPlayer(currentPlayers.indexOf(currentPlayer)+1);
            }





//            System.out.println("players turn");
//            // TODO: nächsten Spieler
////
//            if(allPlayers.indexOf(currentPlayer)==allPlayers.size()-1){
//                currentPlayer = allPlayers.get(0);
//            }else {
//                currentPlayer = allPlayers.get(allPlayers.indexOf(currentPlayer)+1);
//            }
//            /*
//            Player darf nur dann aufgerufen werden wenn,
//            - Sollte um die dritte Hälfte gespielt werden und der Spieler besitzt keine Hälfte
//            - Der Spieler besitzt keine Strafsteine und es sind keine Strafsteine mehr in der Mitte
//             */
//            /*
//            schauen, ob das Spiel beendet ist !
//            - Wie kann das herausgefunden werden ?
//            - Wenn Spieler wieder Startspieler ist, so müsste es enden
//             */
//            if(currentPlayer.)
        }
    }
}


// TODO: GameOberver als Broadcaster
// Broadcasting-Mechanismus einbauen
