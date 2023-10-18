package com.notes.pu_notes_app;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Topic_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        // Retrieve the subject name and animal names from the intent
        String subName = getIntent().getStringExtra("SUB_NAME");
        String animalNotes = getIntent().getStringExtra("ANIMAL_NOTES");
        String animalYtLink = getIntent().getStringExtra("ANIMAL_YT_LINK");
        String animalOldQues = getIntent().getStringExtra("ANIMAL_OLD_QUES");

        // Set the card name as the title of the ActionBar (navigation bar)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(subName); // Set the title dynamically
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Show the fragments with the appropriate animal names
        NotesFragment fragment1 = NotesFragment.newInstance(animalNotes);
        Yt_LinkFragment fragment2 = Yt_LinkFragment.newInstance(animalYtLink);
        Old_QuesFragment fragment3 = Old_QuesFragment.newInstance(animalOldQues);

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction[] transaction = {fragmentManager.beginTransaction()};
        transaction[0].replace(R.id.fragment_container, fragment1);
        transaction[0].commit();

        // Set click listeners for the buttons
        findViewById(R.id.btnFragment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction[0] = fragmentManager.beginTransaction();
                transaction[0].replace(R.id.fragment_container, fragment1);
                transaction[0].commit();
            }
        });

        /*
        findViewById(R.id.btnFragment2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction[0] = fragmentManager.beginTransaction();
                transaction[0].replace(R.id.fragment_container, fragment2);
                transaction[0].commit();
            }
        });

         */

        findViewById(R.id.btnFragment3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction[0] = fragmentManager.beginTransaction();
                transaction[0].replace(R.id.fragment_container, fragment3);
                transaction[0].commit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the back arrow button click in the navigation bar
        if (item.getItemId() == android.R.id.home) {
            // Finish the current activity and return to the previous activity
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Handle the Up button (back button) press
        return true;
    }
}
