package com.example.partyplaner;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreatePartyActivity extends AppCompatActivity {
    private static final String TAG = CreatePartyActivity.class.getSimpleName();

    private static final int IMAGE_SELECT_CODE = 900;

    protected Parties parties;
    SharedPreferences sharedPreferences;

    Button buttonDiscard, buttonCreate, buttonChooseFile, buttonProfileLink, buttonShare, buttonLikeTemporary;
    EditText etTitle, etDescription, etDate;
    TextView textViewURI;
    ImageView imageView;
    Date date1;
    String stringTitle, stringDescription, stringDate, shareMessage;

    Party party1 = new Party();
    Parties partiesList = new Parties();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);

        imageView = findViewById(R.id.imageView);
        buttonDiscard = findViewById(R.id.buttonDiscard);
        buttonCreate = findViewById(R.id.buttonCreate);
        buttonProfileLink = findViewById(R.id.buttonProfileLink);
        buttonShare = findViewById(R.id.buttonShare);
        buttonLikeTemporary = findViewById(R.id.buttonLikeTemporary);
        buttonChooseFile = findViewById(R.id.buttonChooseFile);
        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etDate = findViewById(R.id.etDate);
        textViewURI = findViewById(R.id.textViewURI);

        buttonChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGE_SELECT_CODE);
            }
        });

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);

                shareMessage = etTitle.getText().toString() + "\n\n" + etDate.getText().toString() + '\n' + etDescription.getText().toString() + '\n';
                //change the type of data you need to share,
                //for image use "image/*"
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(intent, "Share"));
            }
        });

        buttonDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTitle.setText("");
                etDate.setText("");
                etDescription.setText("");
            }
        });

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringTitle = etTitle.getText().toString();
                stringDate = etDate.getText().toString();
                stringDescription = etDescription.getText().toString();

                try {
                    date1=new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                party1.setName(etTitle.getText().toString());
                party1.setLocation("Tyrseca ulica 30, Maribor");
                party1.setDatetime(date1);
                party1.setType("private");
                party1.setDescription(etDescription.getText().toString());
                party1.setLikes(20);

                partiesList.addParty(party1);

                etTitle.setText("");
                etDate.setText("");
                etDescription.setText("");
                //Toast.makeText(getApplicationContext(), date1.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_SELECT_CODE && resultCode == RESULT_OK){
            if (data != null){
                Uri uri = data.getData();
                imageView.setImageURI(uri);
                textViewURI.setText((String)imageView.getTag());
            }
        }
    }



    public void onClickBackground(View v) {
        if(v == buttonLikeTemporary) {
            buttonLikeTemporary.setBackgroundResource(R.drawable.heart);
        }
    }

    public void onClickOpenList(View view) {
        Intent i = new Intent(getBaseContext(), PartyListGuestActivity.class);
        startActivity(i);
    }

}