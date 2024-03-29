package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private final TypSali typSali;

    private int currentNumberOfGuests = 0;
    private  final int numberOfTables;
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

    protected int getCurrentNumberOfGuests (){
        return currentNumberOfGuests;
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




    protected boolean assignToRandomTable(Guest tg)
    {
        if( currentNumberOfGuests < seatsNeeded )
        {
            final boolean findTableFlag = true;
            final int minRoll = 0;
            final int maxRoll = tables.size() - 1;

            int rolledTableIndex;
            Stol ts;
            while (findTableFlag)
            {
                rolledTableIndex = returnRandomIntInRange(maxRoll, minRoll);
                ts = tables.get(rolledTableIndex);

                if (ts.takenPlaces < ts.maxPlaces)
                {
                    if (ts.addGuest(tg))
                    {
                        ts.takenPlaces = ts.takenPlaces + 1;
                        currentNumberOfGuests = currentNumberOfGuests + 1;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    protected boolean addTable(int maxPlaces)
    {
        try
        {
            tables.add(new Stol(maxPlaces));
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error adding tables " + e);
        }
        return false;
    }

    protected boolean addGuest(List<Guest> gl, Guest myGuest)
    {
        try
        {
            gl.add(myGuest);
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error adding guest " + e);
        }
        return false;
    }

    private int returnRandomIntInRange(int max, int min)
    {
        int i = (int) (Math.random() * (max - min + 1)) + min;
        return i;
    }

    protected String printSalaStatus()
    {
        try
        {
            String returnString = "";

            returnString = "====== " + salaID + ": ======\n" +
                            "Current number of sitting guests: " + currentNumberOfGuests + "\n" +
                            "Room cuisine type: " + typSali + "\n\n" +
                            myTV.toString() + "\n";

            if ( snookerTable != null ) returnString = returnString + snookerTable.toString() + "\n";

            for(Stol ts : tables)
            {
                returnString = returnString + ts.printAvailableSeats() + "\n";
            }

            return returnString;
        }
        catch (Exception e)
        {
            System.out.println("Error in printing room status " + e);
        }
        return null;
    }

    protected boolean makeTables() {
        try
        {
            int[] tableCapacityArray = new int[numberOfTables];
            int randomValue = 0;
            int minRandom = 0;
            int maxRandom = numberOfTables - 1 ;


            for(int j = 0 ; j < seatsNeeded ; j++){
                randomValue = returnRandomIntInRange(maxRandom, minRandom);
                tableCapacityArray[randomValue] = tableCapacityArray[randomValue] + 1;
            }
            for (int i = 0; i < numberOfTables ; i++)
            {
                tables.add(new Stol(tableCapacityArray[i]));
            }

            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error initializing Tables");
        }

        return false;
    }




}
