package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private final TypSali typSali;

    private int currentNumberOfGuests = 0;
    private int numberOfTables;
    private List<Guest> guests = new ArrayList<>();
    private List<Stol> tables = new ArrayList<>();

    private static int iD = 0;
    private int seatsNeeded = 0;

    private Snooker snookerTable = null;
    private TV myTV = null;

    private final String salaID;




    protected enum TypSali{
        VEGETARIAN, CARNIVOROUS
    }


    Sala(TypSali typSali, int seatsNeeded, int numberOfTables){
        salaID = "SALA" + iD;
        iD = iD + 1;

        this.typSali = typSali;
        this.numberOfTables = numberOfTables;
        this.seatsNeeded = seatsNeeded;
        System.out.println(this.seatsNeeded);
        if( typSali == TypSali.VEGETARIAN) snookerTable = new Snooker();

    }

    protected TV getMyTV() {
        return myTV;
    }

    protected void setMyTV(TV myTV) {
        this.myTV = myTV;
    }

    protected int getSeatsNeeded() {
        return seatsNeeded;
    }

    protected void setSeatsNeeded(int seatsNeeded) {
        this.seatsNeeded = seatsNeeded;
    }

    protected List<Guest> getGuests() {
        return guests;
    }

    protected List<Stol> getTables() {
        return tables;
    }

    protected Snooker getSnookerTable() {
        return snookerTable;
    }

    protected void setSnookerTable(Snooker snookerTableNew) {
        snookerTable = snookerTableNew;
    }

    protected TypSali getTypSali() {
        return typSali;
    }

    protected String getSalaID() {
        return salaID;
    }


    public boolean assignToRandomTable(Guest tg) {
        boolean findTableFlag = true;
        final int minRoll = 0;
        final int maxRoll = tables.size() - 1;
        int rolledTableIndex;
        Stol ts;
        while(findTableFlag){
            rolledTableIndex = returnRandomIntInRange(maxRoll, minRoll);
            ts = tables.get(rolledTableIndex);

            if( ts.takenPlaces < ts.maxPlaces ){
                ts.addGuest(tg);
                System.out.println("TABLE: " + rolledTableIndex + " TAKEN: " + ts.takenPlaces + " MAX: " + ts.maxPlaces);
                return true;
            }
        }
        return false;
    }


    protected boolean addTable(int maxPlaces)
    {
        try {

            tables.add(new Stol(maxPlaces));

            return true;
        }catch (Exception e){
            System.out.println("Error adding tables " + e);
        }
        return false;
    }

    protected boolean addGuest(List<Guest> gl, Guest myGuest){
        try {
            gl.add(myGuest);
            return true;
        }catch (Exception e){
            System.out.println("Error adding guest " + e);
        }
        return false;
    }

    private int returnRandomIntInRange(int max, int min)
    {
        return (int) (Math.random() * max + min);
    }

    protected String printSalaStatus(){
        try
        {
            String returnString = "";
            returnString = salaID + ": \n" +
                            "Guests number: " + currentNumberOfGuests + "\n" +
                            "Room cuisine type: " + typSali + "\n" +
                            myTV.toString();
            if ( snookerTable != null ) returnString = returnString + snookerTable.toString() + "\n";
            return returnString;
        }
        catch (Exception e)
        {
            System.out.println("Error in printing status " + e);
        }
        return null;

    }

    public boolean makeTables() {
        try {
            int temporaryVariable = seatsNeeded;
            int randomValue = 0;
            int minRandom = 1;
            int maxRandom = seatsNeeded / 2;

            for (int i = 0; i < numberOfTables ; i++)
            {
                randomValue = returnRandomIntInRange(maxRandom, minRandom);
                if (temporaryVariable - randomValue > 0){
                    tables.add(new Stol(randomValue));
                    temporaryVariable = temporaryVariable - randomValue;
                }
                else {
                    tables.add(new Stol(temporaryVariable));
                    temporaryVariable = 0;
                }


            }

            return true;
        }catch (Exception e){
            System.out.println("Error initializing Tables");
        }

        return false;
    }




}
