package com.example.partyplaner;

import java.util.ArrayList;

public class Parties {
    private ArrayList<Party> parties;

    public Parties() {
        this.parties = new ArrayList<>();
    }

    public ArrayList<Party> getParties() {
        return parties;
    }

    public void addParty(Party p) {parties.add(p);}
}
