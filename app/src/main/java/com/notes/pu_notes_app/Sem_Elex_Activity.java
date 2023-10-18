package com.notes.pu_notes_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Sem_Elex_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_elex);


        // Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("B.E. Electronics and Communication");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Set click listeners for the cards
        findViewById(R.id.c1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Basic Electronic Engineering", "Computer Programming", "Engineering Drawing-I", "English for Technical Communication", "Mathematics-I", "Physics"};
                String cardName = "I Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Basic Electrical Engineering", "CAD and Rapid Prototyping", "Digital Electronics", "Chemistry", "Mathematics-II", "Object Oriented Programming with C++"};
                String cardName = "II Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Electromagnetic", "Electronics Circuit", "Database Management System(DBMS)", "Mathematics-III", "Microprocessor", "Network Analysis"};
                String cardName = "III Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Advanced Electronics", "Applied Mathematics", "Electromagnetic", "Integrated Digital Electronics", "Microprocessor", "Power Electronics & Drives"};
                String cardName = "IV Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Antenna and Propagation", "Control System", "Data Communication and Computer Network", "Embedded System", "Numerical Methods", "Signal and System"};
                String cardName = "V Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Analog Communication", "Engineering Economics", "Filter Design", "Probability & Statistics", "Research Methodology", "Surveying"};
                String cardName = "VI Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Digital Communication System", "Digital Signal Processing", "Elective-I: Avionics", "Elective-I: Bio-Medical Instrumentation", "Elective-I: Information Security", "Elective-I: Next Generation Network", "Elective-I: Optical Fiber Communication", "Elective-I: Radar Engineering", "Elective-I: RF & Microwave Engineering", "Elective-I: Satellite Communication", "Elective-I: Solar Photovoltaic Technology", "Elective-I: Spread Spectrum & CDMA", "Elective-I: VLSI Design", "Microwave Devices, Circuits & System", "Project & Organization Management", "Project Work"};
                String cardName = "VII Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Elective II: Avionics", "Elective-II: Biomedical Instrumentation", "Elective II: Next Generation Network", "Elective II: Optical Fiber Communication", "Elective II: Satellite Communication", "Engineering Professional Practice & Sociology", "Project Work", "Telecommunication Traffic & Network", "Wireless Communication"};
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
        Intent intent = new Intent(Sem_Elex_Activity.this, Sub_Elex_Activity.class);
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
