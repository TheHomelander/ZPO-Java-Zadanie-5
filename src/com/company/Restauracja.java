package com.company;

import java.util.ArrayList;
import java.util.List;

public class Restauracja {
    private List<Sala> sale = new ArrayList<>();
    private String name;

    private int maxAvailableSeats = 40;
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

    protected String printRestStatus(List<Sala> ls){
        try {
            String resultingString = "";
            for (Sala temp : sale) {
                resultingString =   resultingString +
                                    temp.printSalaStatus() +
                                    "\n";
            }
            return resultingString;
        }catch (Exception e){
            System.out.println("Error occured while printing restaurant status");
        }
        return null;
    }

    protected int addSala(List<Sala> ls, Sala sObj){
        try{
            ls.add(sObj);
            return success;
        }catch (Exception e){
            System.out.println("Error adding Sala");
        }
        return failure;
    }

    private int returnRandomIntInRange(int max, int min)
    {
        return (int) (Math.random() * max + min);
    }

    protected int initiateRestaurant(){
        try{
            final int roomOneCapacity = 18;
            final int roomTwoCapacity = 12;

            final int guestDailyMax = 50;
            final int guestDailyMin = 10;
            final int todaysGuests = returnRandomIntInRange(guestDailyMax, guestDailyMin);

            final int maxNumberOfTablesRoom = 6;
            final int minNumberOfTablesRoom = 3;
            final int numberOfTablesRoomOne = returnRandomIntInRange(maxNumberOfTablesRoom,minNumberOfTablesRoom);
            final int numberOfTablesRoomTwo = returnRandomIntInRange(maxNumberOfTablesRoom,minNumberOfTablesRoom);

            initiateRooms(roomOneCapacity,roomTwoCapacity, numberOfTablesRoomOne,numberOfTablesRoomTwo);
            initiateTables();




        }catch (Exception e){
            System.out.println("Error occured while initiating the restaurant");
        }



        return failure;
    }

    private void initiateTables() {
        for(Sala tempSala : sale){
            tempSala.makeTables();
            for(Stol xd : tempSala.getTables()){
                System.out.println(xd.printAvailableSeats());

            }
            System.out.println("END");
        }
    }

    private void initiateRooms(int roomOneCapacity, int roomTwoCapacity, int numberOfTablesRoomOne, int numberOfTablesRoomTwo) {
        final int firstRoomType = returnRandomIntInRange(success,failure);
        System.out.println("InitiateRooms: " + firstRoomType);
        if( firstRoomType == success ){
            sale.add(new Sala(Sala.TypSali.VEGETARIAN, roomOneCapacity, numberOfTablesRoomOne));
            sale.add(new Sala(Sala.TypSali.CARNIVOROUS, roomTwoCapacity, numberOfTablesRoomTwo));
        }else{
            sale.add(new Sala(Sala.TypSali.CARNIVOROUS, roomOneCapacity, numberOfTablesRoomOne));
            sale.add(new Sala(Sala.TypSali.VEGETARIAN, roomTwoCapacity, numberOfTablesRoomTwo));
        }

    }

}
