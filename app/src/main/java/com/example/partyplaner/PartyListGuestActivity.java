package com.example.partyplaner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PartyListGuestActivity extends AppCompatActivity {
    private static final String TAG = PartyListGuestActivity.class.getSimpleName();
    protected RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_list_guest);

        recyclerView = findViewById(R.id.recyclerView);
    }
}