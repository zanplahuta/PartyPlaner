package com.example.partyplaner;

import java.util.ArrayList;

public class Invites {
    private ArrayList<Invite> invites;

    public Invites() {
        this.invites = new ArrayList<Invite>();
    }

    public ArrayList<Invite> getInvites() {
        return invites;
    }

    public void setInvites(ArrayList<Invite> invites) {
        this.invites = invites;
    }
}
