package com.company;

public class Guest {
    private String name;
    private String surname;
    private String guestID;
    protected final String[] nameAvailable = {"Adam", "Ola", "Paweł", "Piotr", "Bartek", "Kamil"};
    protected final String[] surnameAvailable = {"Krzak", "Dąbrowski", "Kowal", "Kowal", "Korniszon", "Zapała"};


    private float bill = 0.0F;
    private static int iD = 1;
    private final int minimumRandomInt = 1;
    private final int success = 1;
    private final int failure = 0;

    Guest(String name, String surname){
        guestID = "GUEST" + iD;
        iD = iD + 1;
        this.name = name;
        this.surname = surname;
    }


    @Override
    public String toString() {
        return  guestID + ": " + name + " " + surname + ", " +
                "Bill: " + bill;
    }



    protected float getBill() {
        return bill;
    }

    protected void setBill(float bill) {
        this.bill = bill;
    }

    protected int addChargeToGuest(float charge){
        if( charge > 0.0F ){
            bill = bill + charge;
            return success;
        }else {
            return failure;
        }
    }

    private int returnRandomIntInRange(int max, int min)
    {
        int i = (int) (Math.random() * (max - min + 1)) + min;
        return i;
    }

    protected String getRandomName(){
        return nameAvailable[returnRandomIntInRange(nameAvailable.length - 1, minimumRandomInt)];
    }

    protected String getRandomSurname(){
        return surnameAvailable[returnRandomIntInRange(surnameAvailable.length - 1, minimumRandomInt)];
    }

    public void randomizeGuest() {
        name = getRandomName();
        surname = getRandomSurname();
    }
}
