package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myconnection.MyDb;

import java.util.ArrayList;

public class DiaryListActivity extends AppCompatActivity {

//    private String[] diaryEntries = {
//        "happy day", "stressful moments", "eating time", "sleeping habits"
//    };

    MyDb myDb;

    private ListView lvDiaryEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list);

        lvDiaryEntries = findViewById(R.id.lvDiaryEntries);
        myDb = new MyDb(this);
        myDb.open();

        ArrayList<String> entries = myDb.getEntries();

        String[] entryDates = new String[entries.size()];

        for(int index = 0; index < entryDates.length; index++){
            entryDates[index] = entries.get(1);
        }

        ListAdapter adapter = new ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, entries
        );

        lvDiaryEntries.setAdapter(adapter);

        lvDiaryEntries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String testClick = "You clicked" + String.valueOf(adapterView.getItemAtPosition(i)) + ".";
                Toast.makeText(getApplicationContext(), testClick, Toast.LENGTH_SHORT).show();
            }
        });
    }
}