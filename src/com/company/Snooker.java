package com.company;

public class Snooker {
    private int numberOfPlayers = 0;
    private final int maxNumberOfPlayers = 4;

    private final String snookerTableLabel;
    private static int identificationNumber = 0;

    private final int success = 1;
    private final int failure = 0;

    Snooker(){
        snookerTableLabel = "SNOOKER" + identificationNumber;
        identificationNumber = identificationNumber + 1;
    }

    @Override
    public String toString() {
        return  snookerTableLabel  + "\n" +
                "NUMBER OF PLAYERS: " + numberOfPlayers + "\n";
    }

    protected int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    protected void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    protected int getMaxNumberOfPlayers(){
        return maxNumberOfPlayers;
    }


    protected int removePlayer(){
        if(numberOfPlayers - 1 < 0){
            return failure;
        }else
        {
            numberOfPlayers = numberOfPlayers - 1;
            return success;
        }
    }

    protected boolean addPlayer(){
        if( numberOfPlayers < maxNumberOfPlayers){
            numberOfPlayers = numberOfPlayers + 1;
            return true;
        }else
            return false;
    }

}
