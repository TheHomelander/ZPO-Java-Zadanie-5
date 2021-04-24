package com.company;

public class Main {

    public static void main(String[] args) {

        Restauracja wyobrazniaRestaurant = new Restauracja("Wyobraźnia");
        wyobrazniaRestaurant.initiateRestaurant();
        System.out.println("INITIATE FINISHED");
        // notatka dla Wiktora
        // dodać losowe dodawanie osób do stolika z bilardem
        // wywal pole i wszystkie funkcje z klasy Guest isVegan i zobacz czy da się losować krzesła, które wywaliłeś z dwa commity temu
        // jak bd czas to jeszcze można rozdzielić Restauracja.addgueststorandomtavbles, żeby osobna metoda generowała wcześniej listę gości a następnie byli oni przydzielani
        //System.out.println( wyobrazniaRestaurant.printRestStatus() );

    }
}
