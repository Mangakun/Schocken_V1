package de.schocken.marco.schocken_v1.gameobserver.impl;

import java.util.ArrayList;
import java.util.List;

import de.schocken.marco.schocken_v1.factories.PlayerCreator;
import de.schocken.marco.schocken_v1.gameobserver.GameObserver;
import de.schocken.marco.schocken_v1.gameobserver.PlayerCallback;
import de.schocken.marco.schocken_v1.player.Player;
import de.schocken.marco.schocken_v1.player.impl.PlayerImpl;

/**
 * Created by Snaki on 16.12.2017.
 * This class is an implementation class of a game observer.
 * This class manages the game.
 */

public class GameObserverImpl implements GameObserver, PlayerCallback {

    private List<Player> players;
    private Player currentPlayer;
    private Player currentBestPlayer;
    private Player currentWorstPlayer;
    private int penaltyStack; // TODO get from settings
    private int maxThrows;
    private Player roundStarter;
    private PlayerCallback playerCallback;

    /**
     * Constructor of the class {@link GameObserverImpl}.
     */
    public GameObserverImpl(){
        System.out.println("constructor GameObserverImpl");
        currentBestPlayer = null;
        currentBestPlayer = null;
        currentWorstPlayer = null;
        penaltyStack = 13;
        playerCallback = new PlayerCallBack();

    }

    @Override
    public void createPlayers(final String[] playerNames){
        players = PlayerCreator.getINSTANCE().createPlayers(playerNames, playerCallback);
        for(Player player : players){
            System.out.println(player.getName());
        }
    }


    @Override
    public void newGame() {
        // erster Spieler startet bisher das Spiel
        /*
        Eine andere Möglichkeit wäre, dass jeder würfelt und
         */

        // init players
        for(final Player player : players){
            player.nextGame();
        }
        // first player starts the game
        currentPlayer = players.get(0);
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


    private void nextPlayer(final int index){
        if(players.size()>0){
            if(index == players.size()){
                currentPlayer = players.get(0);
            }else{
                currentPlayer = players.get(index);
            }
            currentPlayer.turn();
        }else{
            // TODO: Spiel müsste vorbei sein
        }
    }

    private void distributeMaxDiceThrows(final int maxDiceThrows){
        for(final Player player: players){
           // player.setMaxDiceThrows(maxDiceThrows);
        }
    }


    public class PlayerCallBack implements PlayerCallback{


        @Override
        public void callback(final boolean finish) {
                System.out.println("joooooooooooooooooooooooo");
            // if finish -> take out player
//            if(finish){
//                if(currentPlayer == roundStarter){
//                    // TODO: set global max dice throws
//                    distributeMaxDiceThrows( currentPlayer.getDiceThrows());
//                }
//                // TODO:
//              //  determineCurrentWorstPlayer();
//              //            determineCurrentBestPlayer();
//                // delete current player from list
//                int oldIndex = players.indexOf(currentPlayer);
//                players.remove(currentPlayer);
//                nextPlayer(oldIndex);
//            }else{
//                nextPlayer(players.indexOf(currentPlayer)+1);
//            }





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
