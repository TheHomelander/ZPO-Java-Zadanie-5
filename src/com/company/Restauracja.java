package com.company;

import java.util.ArrayList;
import java.util.List;

public class Restauracja {
    private List<Sala> sale = new ArrayList<>();
    private String name;
    private int currentGuests = 0;

    private final int maxAvailableSeats = 30;
    private final int success = 1;
    private final int failure = 0;



    Restauracja(String name){
        this.name = name;
    }


    protected List<Sala> getSale() {
        return sale;
    }

    protected void setSale(List<Sala> sale) {
        this.sale = sale;
    }

    protected int getMaxAvailableSeats() {
        return maxAvailableSeats;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }


    protected String printRestStatus()
    {
        try
        {
            String resultingString = "";


            for (Sala temp : sale)
            {
                resultingString = resultingString + temp.printSalaStatus() ;
            }

            return resultingString;
        }catch (Exception e)
        {
            System.out.println("Error occured while printing restaurant status");
        }
        return null;
    }

    private int returnRandomIntInRange(int max, int min)
    {
        int i = (int) (Math.random() * (max - min + 1)) + min;
        return i;
    }

    protected int initiateRestaurant()
    {
        try
        {
            final int roomOneCapacity = 18;
            final int roomTwoCapacity = 12;

            final int guestDailyMax = 50;
            final int guestDailyMin = 10;
            final int numberOfTodaysGuests = returnRandomIntInRange(guestDailyMax, guestDailyMin);

            final int maxNumberOfTablesRoom = 6;
            final int minNumberOfTablesRoom = 3;
            final int numberOfTablesRoomOne = returnRandomIntInRange(maxNumberOfTablesRoom,minNumberOfTablesRoom);
            final int numberOfTablesRoomTwo = returnRandomIntInRange(maxNumberOfTablesRoom,minNumberOfTablesRoom);
            //System.out.println("TODAYS NUMBER OF GUESTS: " + numberOfTodaysGuests);

            initiateRooms(roomOneCapacity,roomTwoCapacity, numberOfTablesRoomOne,numberOfTablesRoomTwo);

            initiateTVs();

            initiateTables();

            assignGuestsToRandomTables(numberOfTodaysGuests);

        }catch (Exception e)
        {
            System.out.println("Error occured while initiating the restaurant" + e);
        }

        return failure;
    }



    private void assignGuestsToRandomTables(int todaysGuests)
    {
        final int randomizerMin = 0;
        final int randomizerMax = sale.size() - 1;
        int tableIndexToAssign;
        boolean ifAssignToSnookerTable;
        Sala ts;

        for ( int i = 0 ; i < todaysGuests ; i++)
        {
            if( currentGuests < maxAvailableSeats)
            {

                Guest tg = new Guest();

                tableIndexToAssign = returnRandomIntInRange(randomizerMax,randomizerMin);
                ifAssignToSnookerTable = (returnRandomIntInRange(success, failure) == success );

                ts = sale.get(tableIndexToAssign);

                if( ts.getSnookerTable() != null)
                {
                    if ((ts.getSnookerTable().getNumberOfPlayers() < ts.getSnookerTable().getMaxNumberOfPlayers()) && ifAssignToSnookerTable)
                    {
                        ts.getSnookerTable().addPlayer();
                        continue;
                    }
                }

                if(ts.assignToRandomTable(tg))
                {
                         currentGuests = currentGuests + 1;
                }
                else
                {
                    if ( tableIndexToAssign == randomizerMax ) tableIndexToAssign = randomizerMin;
                    else
                        tableIndexToAssign = randomizerMax;
                    ts = sale.get(tableIndexToAssign);
                    if(ts.assignToRandomTable(tg))
                    {
                        currentGuests = currentGuests + 1;
                    }
                }
            }else
                break;
        }
    }

    private void initiateTVs()
    {
        for(Sala ts : sale)
        {
            TV ttv = new TV();
            ts.setMyTV(ttv);
        }
    }

    private void initiateTables()
    {
        for(Sala tempSala : sale)
        {
            tempSala.makeTables();
        }
    }

    private void initiateRooms(int roomOneCapacity, int roomTwoCapacity, int numberOfTablesRoomOne, int numberOfTablesRoomTwo)
    {
        final int firstRoomType = returnRandomIntInRange(success,failure);

        if( firstRoomType == success )
        {
            sale.add(new Sala(Sala.TypSali.VEGETARIAN, roomOneCapacity, numberOfTablesRoomOne));
            sale.add(new Sala(Sala.TypSali.CARNIVOROUS, roomTwoCapacity, numberOfTablesRoomTwo));
        }else
        {
            sale.add(new Sala(Sala.TypSali.CARNIVOROUS, roomOneCapacity, numberOfTablesRoomOne));
            sale.add(new Sala(Sala.TypSali.VEGETARIAN, roomTwoCapacity, numberOfTablesRoomTwo));
        }

    }


}
