package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stol {

    protected String tableLabel;
    private List<Krzeslo> chairs = new ArrayList<>();
    private static int iD = 0;
    protected int maxPlaces;
    protected int takenPlaces = 0;

    Stol(int maxPLaces)
    {
        tableLabel = "TABLE" + iD;
        iD = iD + 1;
        this.maxPlaces = maxPLaces;
        addNewChairs();
    }

    protected boolean addNewChairs() {
        try {
            for (int i = 0; i < maxPlaces; i++) {
                chairs.add(new Krzeslo());
            }
            return true;
        }catch (Exception e){
            System.out.println("Error adding chairs " + e);

        }
        return false;
    }

    protected String printAvailableSeats(){
        return tableLabel + ":\n" +
                "All Seats: " + maxPlaces + "\n" +
                "Taken Seats: " + takenPlaces + "\n";
    }

    public void addGuest(Guest tg) {
        for(Krzeslo tk : chairs){
            if(tk == null){
                tk.sittingGuest = tg;
            }
        }
    }
}
