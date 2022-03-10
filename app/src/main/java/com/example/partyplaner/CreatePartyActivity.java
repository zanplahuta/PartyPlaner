package com.example.partyplaner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class CreatePartyActivity extends AppCompatActivity {
    private static final String TAG = CreatePartyActivity.class.getSimpleName();

    public static final String FORM_MODE_ID = "FORM_MODE_ID";
    public static final int FORM_MODE_INSERT = 0;

    public static final int ACTIVITY_ID = 111;
    public static final String DATA_ACTION = "DATA_ACTION";

    protected Parties parties;
    SharedPreferences sharedPreferences;

    Button buttonDiscard, buttonCreate, buttonChooseFile;
    EditText etTitle, etDescription;
    DatePicker etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}