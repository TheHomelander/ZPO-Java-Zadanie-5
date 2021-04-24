package com.company;

public class Main {

    public static void main(String[] args) {

        Restauracja wyobrazniaRestaurant = new Restauracja("Wyobraźnia");
        wyobrazniaRestaurant.initiateRestaurant();
        System.out.println("INITIATE FINISHED");
        // notatka dla Wiktora

        // jak bd czas to jeszcze można rozdzielić Restauracja.addgueststorandomtavbles, żeby osobna metoda generowała wcześniej listę gości a następnie byli oni przydzielani
        System.out.println( wyobrazniaRestaurant.printRestStatus() );
        wyobrazniaRestaurant.printControlSum();

    }
}
