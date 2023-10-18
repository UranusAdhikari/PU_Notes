package com.notes.pu_notes_app;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Sem_Arch_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_arch);

        // Action bar
        getSupportActionBar().setTitle("B. Architecture");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set click listeners for the cards
        findViewById(R.id.c1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"An Introduction to Architecture", "Architectural Drafting-I", "Art & Graphics-I", "Basic Design-I", "Building Material and Construction-I", "Mathematics-I", "Workshop-I(Model and Sculpture)"};
                String cardName = "I Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Architectural Drafting-II", "Arts & Graphics-II", "Basic Design-II", "Building Material & Construction-II", "History of Nepalese Architecture", "Mathematics-II", "Workshop-II"};
                String cardName = "II Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Applied Mechanics", "Building Material and Construction-III", "Building Science-II", "Computer Aided Design & Drafting (CADD)", "Design Studio-III", "History of Eastern Architecture", "Surveying & Leveling"};
                String cardName = "III Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Building Construction-IV", "Building Services-I", "Computer Aided Design & Drafting (CADD)", "Design Studio-IV", "Eastern Architecture", "Sociology of Architecture", "Theory of Structure-II"};
                String cardName = "IV Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Building Science-III", "Building Services-II", "Design of Steel, Wood & Masonry Structure", "Design Studio-V", "Design Theory-I", "Interior Design", "Western Architecture"};
                String cardName = "V Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Design of Reinforced Concrete Structure(RCC)", "Design Studio-VI", "Design Theory-II", "Elective I: Low Cost Housing", "Elective I: Vernacular Architecture", "Landscape Architecture", "Specifications, Quantity, Surveying & Estimation", "Working Dwgs & Detailing"};
                String cardName = "VI Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String[] subNames = new String[]{"Architectural Conservation", "Building Construction-V", "Design Studio-VII", "Elective II: Energy Efficient Building Design", "Elective II: Nepalese Architecture in Kathmandu Valley", "Engineering Economics", "Modern Architecture", "Urban Settelment Planning"};
                String cardName = "VII Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Build Environment(Research)", "Construction Project Management", "Design Studio-VIII", "Disaster Risk Management", "Professional Practice", "Seminar", "Urban Design"};
                String cardName = "VIII Semester";
                openSubArchActivity(subNames, cardName);
            }
        });
        findViewById(R.id.c9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Professional Training Practice(Practical)"};
                String cardName = "IX Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Thesis Project"};
                String cardName = "X Semester";
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
        Intent intent = new Intent(Sem_Arch_Activity.this, Sub_Arch_Activity.class);
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
