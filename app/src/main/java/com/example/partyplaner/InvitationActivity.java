package com.example.partyplaner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InvitationActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonInvite;
    private Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);

        editTextName = findViewById(R.id.editTextNameInvite);
        editTextEmail = findViewById(R.id.editTextEmailInvite);
        buttonInvite = findViewById(R.id.buttonInvite);
        buttonContinue = findViewById(R.id.buttonContinue);
    }

    public void onButtonInviteClick(View view) {
        finish();
    }

    public void onButtonContinueClick(View view) {
        finish();
    }
}