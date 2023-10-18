package com.notes.pu_notes_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Sem_Comp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_comp);


        // Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("B.E. Computer");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Set click listeners for the cards
        findViewById(R.id.c1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Computer Programming", "Engineering Drawing I", "English for Technical communication", "Fundamental of computing Technology", "Mathematics I", "Physics", "Workshop Technology"};
                String cardName = "I Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Applied Mechanics", "Basic Electrical Engineering", "Chemistry", "Digital Logic", "Mathematics-II", "Object Oriented Programming with C++"};
                String cardName = "II Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Applied Sociology", "Computer Graphics", "Data Structure & Algorithm", "EDC", "Mathematics - III", "OOAD"};
                String cardName = "III Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Applied Sociology", "Communication Systems", "Database Management System", "Discrete Structure", "Free & Open Source Programming", "Microprocessor"};
                String cardName = "IV Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Algorithm Analysis and Design", "Computer Graphics", "Numerical Method", "Operating System", "Project", "Research Methodology"};
                String cardName = "V Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Computer Network", "Engineering Economics", "Multimedia Computing and Technology", "Probability and Statistics", "Project and Organization Management", "Theory of Computation"};
                String cardName = "VI Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Artificial Intelligence", "Elective-I: ", "Elective-I: Image Processing and Pattern Recognization", "Elective-I: Mobile Computing", "Entrepreneurship", "Project", "Simulation & Modelling", "Software Engineering"};
                String cardName = "VII Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Advanced Computer Architecture", "Cryptography: ", "Data Mining & Data Warehousing", "Elective-II: Geographical Information System", "Elective-II: VB.Net, C#", "Engineering Professional Practice", "Project-IV"};
                String cardName = "VIII Semester";
                openSubArchActivity(subNames, cardName);
            }
        });
    }

    private void openSubArchActivity(String[] subNames, String cardName) {
        // Save the selected card name in SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("SELECTED_CARD_NAME", cardName);
        editor.apply();

        // Start the Sub_Arch_Activity
        Intent intent = new Intent(Sem_Comp_Activity.this, Sub_Comp_Activity.class);
        intent.putExtra("SUB_NAMES", subNames);
        intent.putExtra("CARD_NAME", cardName);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle ActionBar's up arrow (back button) press
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
