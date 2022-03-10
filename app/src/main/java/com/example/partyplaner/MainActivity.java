package com.example.partyplaner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sign_in(View view) {
        Intent i = new Intent(getBaseContext(), SignIn.class);
        startActivity(i);
    }
    public void onClickOpenCreate(View view) {
        Intent i = new Intent(getBaseContext(), CreatePartyActivity.class);
        startActivity(i);
    }
}