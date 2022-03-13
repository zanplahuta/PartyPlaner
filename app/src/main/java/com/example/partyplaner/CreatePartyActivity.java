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


public class CreatePartyActivity extends AppCompatActivity {
    private static final String TAG = CreatePartyActivity.class.getSimpleName();

    private static final int IMAGE_SELECT_CODE = 900;

    protected Parties parties;
    SharedPreferences sharedPreferences;

    Button buttonDiscard, buttonCreate, buttonChooseFile, buttonProfileLink;
    EditText etTitle, etDescription, etDate;
    TextView textViewURI;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);

        imageView = findViewById(R.id.imageView);
        buttonDiscard = findViewById(R.id.buttonDiscard);
        buttonCreate = findViewById(R.id.buttonCreate);
        buttonProfileLink = findViewById(R.id.buttonProfileLink);
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

}