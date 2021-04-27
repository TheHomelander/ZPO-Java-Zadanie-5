package com.company;

public class Main {

    public static void main(String[] args) {

        Restauracja wyobrazniaRestaurant = new Restauracja("Wyobraźnia");
        wyobrazniaRestaurant.initiateRestaurant();
        System.out.println( wyobrazniaRestaurant.printRestStatus() );

    }
}
