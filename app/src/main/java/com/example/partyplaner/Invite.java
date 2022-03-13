package com.example.partyplaner;

public class Invite {
    private String name;
    private String email;
    private String response;
    private String partyUUID;

    public Invite(String name, String email, String response, String partyUUID) {
        this.name = name;
        this.email = email;
        this.response = response;
        this.partyUUID = partyUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartyUUID() {
        return partyUUID;
    }

    public void setPartyUUID(String partyUUID) {
        this.partyUUID = partyUUID;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

