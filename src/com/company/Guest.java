package com.company;

public class Guest {
    private String name;
    private String surname;
    private String guestID;
    protected final String[] nameAvailable = {"Adam", "Ola", "Paweł", "Piotr", "Bartek", "Kamil"};
    protected final String[] surnameAvailable = {"Krzak", "Dąbrowski", "Kowal", "Kowal", "Korniszon", "Zapała"};

    private boolean isVegetarian;

    private float bill = 0.0F;
    private static int iD = 1;
    private final int minimumRandomInt = 1;
    private final int success = 1;
    private final int failure = 0;

    Guest(String name, String surname, boolean isVegetarian){
        guestID = "GUEST" + iD;
        iD = iD + 1;
        this.name = name;
        this.surname = surname;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String toString() {
        return  guestID + ": " + name + " " + surname + ", " +
                "Vegetarian: " + isVegetarian + ", " +
                "Bill: " + bill;
    }

    protected boolean isVegetarian() {
        return isVegetarian;
    }

    protected void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
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
        return (int) (Math.random() * max + min);
    }

    protected String getRandomName(){
        return nameAvailable[returnRandomIntInRange(nameAvailable.length, minimumRandomInt)];
    }

    protected String getRandomSurname(){
        return surnameAvailable[returnRandomIntInRange(surnameAvailable.length, minimumRandomInt)];
    }

    public void randomizeGuest() {
        name = getRandomName();
        surname = getRandomSurname();
        isVegetarian = (returnRandomIntInRange(success,failure) == success) ;
    }
}
