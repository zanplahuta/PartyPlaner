package com.example.partyplaner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String userID = sp.getString("userId", null);
        String jwt = sp.getString("jwt", null);
        if(TextUtils.isEmpty(editTextName.getText())) {
            editTextName.setError("Name should not be empty!");
        }
        if(TextUtils.isEmpty(editTextEmail.getText())) {
            editTextEmail.setError("Email should not be empty!");
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,"ip goes here"+"/activities",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(InvitationActivity.this, "Person successfully invited!", Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(getBaseContext(), CreatePartyActivity.class);
                        //startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("asd", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", editTextName.getText().toString());
                params.put("email", editTextEmail.getText().toString());
                //params.put("party", partyID); //partyID dobim iz responsa od POST requesta, nato ga pošljem na ta activity

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("x-auth-token", jwt);
                return params;
            }
        };
        queue.add(stringRequest);
    }

    public void onButtonContinueClick(View view) {
        Intent intent = new Intent(getBaseContext(), PartyListGuestActivity.class); //Začasno ga pošljemo kr na guest list
        startActivity(intent);
    }
}