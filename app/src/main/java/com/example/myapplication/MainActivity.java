package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myconnection.MyDb;

public class MainActivity extends AppCompatActivity {

    private Button btnSaveDiaryEntry;
    private EditText etDate, etEntry;
    private MyDb myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaveDiaryEntry = findViewById(R.id.btnSaveDiaryEntry);
        etDate = findViewById(R.id.etDate);
        etEntry = findViewById(R.id.etEntry);

        myDb = new MyDb(this);
        myDb.open();

        btnSaveDiaryEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertEntry();
            }
        });
    }

    private void insertEntry() {
        try {
            long result = myDb.insertEntry(etDate.getText().toString(), etEntry.getText().toString());
            if(result != -1){
                Toast.makeText(this, "Successfully added . . .",
                        Toast.LENGTH_SHORT).show();
            }
        } catch(Exception e){
            Toast.makeText(this, e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        //myDb.close();
    }
}