package com.company;

public class Krzeslo {
    private static int iD = 0;
    private String krzesloLabel;
    protected Guest sittingGuest = null;

    Krzeslo(){
        krzesloLabel = "CHAIR" + iD;
        iD = iD + 1;
    }

    @Override
    public String toString() {
        return krzesloLabel;
    }
}
