package com.notes.pu_notes_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Sem_Civil_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_civil);

        // Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("B.E. Civil");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Set click listeners for the cards
        findViewById(R.id.c1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Applied Mechanics-I(Statics)", "Basic Electrical Engineering", "Chemistry", "Civil Engineering Materials", "Engineering Drawing-I", "Mathematics-I", "Workshop Technology"};
                String cardName = "I Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Applied Mechanics-I(Dynamics)", "Building Technology", "Engineering Drawing-II", "Fundamental of Thermodynamics and Heat Transfer", "Mathematics-II", "Physics"};
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
                String[] subNames = new String[]{"Basic Electronics Engineering", "Computer Programming", "Engineering Geology", "Fluid Mechanics", "Mathematics-III", "Strength of Materials", "Survey-I"};
                String cardName = "IV Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Concrete Technology and Masonry Structures", "Numerical Methods", "Soil Mechanics", "Survey Camp", "Theory of Structure-II", "Transportation Engineering-I", "Water Supply Engineering"};
                String cardName = "V Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Design of Steel and Timber Structure", "Engineering Economics", "Foundation Engineering", "Irrigation Engineering", "Sanitary Engineering", "Transportation Engineering-II"};
                String cardName = "VI Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"An Introduction to Earthquake Engineering", "Applied Sociology", "Construction Project Management", "Design of RCC structures", "Elective-I: Design of RCC Bridge", "Elective-I: Environment Impact Assessment", "Elective-I: Ground Water Engineering", "Elective-I: Hill Irrigation Engineering", "Elective I: Rock Engineering", "Elective-I: Structural Dynamics", "Elective-I: Transport Planning and Engineering", "Estimation and valuation", "Hydro-power Engineering"};
                String cardName = "VII Semester";
                openSubArchActivity(subNames, cardName);
            }
        });

        findViewById(R.id.c8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] subNames = new String[]{"Civil Engineering Project", "Elective-III: Bio-Engineering", "Elective-II: Design of RCC Bridge", "Elective-II: Environmental Impact Assessment", "Elective-III: GIS(Geographical Information System)", "Elective-II: Rock Slope Engineering", "Elective-II: Rural Road Engineering", "Elective-II: Seismic Resistance Design of Structure", "Engineering Professional Practice", "Safety Engineering and Disaster risk Management"};
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
        Intent intent = new Intent(Sem_Civil_Activity.this, Sub_Civil_Activity.class);
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
