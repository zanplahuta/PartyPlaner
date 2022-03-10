package com.example.partyplaner;

import android.app.Application;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Parties extends Application {
    private ArrayList<Party> parties;

    public Parties() {
        this.parties = new ArrayList<>();
    }

    public ArrayList<Party> getParties() {
        return parties;
    }

    public void addParty(Party p) {
        parties.add(p);
    }

    @NonNull
    @Override
    public String toString() {
        return "PartyArray{ " + parties + " }";
    }

    public Party getPartyAtPos(int position) {
        return parties.get(position);
    }

    public void removeAt(int position) {
        parties.remove(position);
    }

    public int getSize() {
        return parties.size();
    }
}
