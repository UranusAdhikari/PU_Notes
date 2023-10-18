package com.notes.pu_notes_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class Sub_Arch_Activity extends AppCompatActivity implements FragmentChangeListener {
    private LinearLayout cardContainer;
    private String[] subNames; // Declare the array to store subNames

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_arch);

        // Retrieve the subject name and card name from the intent
        subNames = getIntent().getStringArrayExtra("SUB_NAMES");
        String cardName = getIntent().getStringExtra("CARD_NAME");

        // Set the card name as the title of the ActionBar (navigation bar)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(cardName);
            actionBar.setDisplayHomeAsUpEnabled(true);

            // Create and add CardViews for each subName
            cardContainer = findViewById(R.id.card_container);
            if (subNames != null) {
                for (int i = 0; i < subNames.length; i++) {
                    addNewCardView(subNames[i], i);
                }
            }
        }
    }

    private void addNewCardView(String text, final int fragmentNumber) {
        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dpToPx(70) // Set the height directly to 60dp
        );
        cardParams.setMargins(10, 10, 10, 1);
        cardView.setLayoutParams(cardParams);
        cardView.setCardElevation(5);
        cardView.setMaxCardElevation(5);
        cardView.setRadius(10);
        cardView.setUseCompatPadding(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        ));

        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textParams.addRule(RelativeLayout.CENTER_VERTICAL); // Set vertical centering
        textParams.setMargins(dpToPx(8), 0, dpToPx(8), 0);
        textView.setLayoutParams(textParams);
        textView.setText(text);
        textView.setTextSize(20);
        textView.setTextColor(ContextCompat.getColor(this, R.color.black));

        // Use TypefaceCompat for compatibility with lower API levels
        Typeface typeface = ResourcesCompat.getFont(this, R.font.amaranth_bold);
        textView.setTypeface(typeface);

        relativeLayout.addView(textView);
        cardView.addView(relativeLayout);
        cardContainer.addView(cardView);

        // Set OnClickListener for the CardView
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notify the activity that a fragment change event occurred
                onFragmentChange(fragmentNumber);
            }
        });
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
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

    // ...

    @Override
    public void onFragmentChange(int fragmentNumber) {
        // Start the "Topic_Arch_Activity" with the selected subject name
        Intent intent = new Intent(Sub_Arch_Activity.this, Topic_Activity.class);
        intent.putExtra("SUB_NAME", subNames[fragmentNumber]);

        // Retrieve the selected card name from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String cardName = sharedPreferences.getString("SELECTED_CARD_NAME", "");

        // Combine fragmentNumber and cardName into a single identifier
        String combinedIdentifier = cardName + "_" + fragmentNumber;

        // Pass the data based on the selected card and fragment number
        switch (combinedIdentifier) {
            case "I Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/15k7Z5Nf-W0lRlpONJHbxpAyfQDMGFKEv");
                intent.putExtra("ANIMAL_YT_LINK", "https://www.facebook.com/");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "I Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1w7jSpvsxFEXu9DE1MojFX7GcCxF78QKe");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "I Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1-br_I7M0l8KQaCth2w0z6KvDmIRbb6jb");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "I Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1_naZylHwPV_4wlRHXEg9LpMwLMRDrNH9");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "I Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1AiFz-i9k85OnullYjWHwjF0yU6zPqXWD");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "I Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/18e-KujfxnYjCBy3qlPSc8N7rLWnrVwWf");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "I Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1tQ34pDiLCBUa3VRET1GneuOVHvVPQQVH");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mxeZ2GZ3veZL2j3UIwb0ndtPODp4tYkm");
                break;
            case "II Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1s4FSbenz5cB-F1PfSOXRKsPiZSA50zJ4");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "II Semester_1":
                intent.putExtra("ANIMAL_NOTES", "hhttps://drive.google.com/drive/u/2/folders/1_pjGqLsk_k80vfhR6FSqob0JWSDhX_Qm");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "II Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Jh78ivOHrPkBHRvY-0goit8WnJnSDjfT");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "II Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1AKpW6OaTSRVx7Uin3lkyCgUDYiSznXKu");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "II Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1uIjdbHqb1Nip_S1j43fbqC3zhe5lHjUM");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "II Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1cFL4bjlp_dO44klojpoQOvri0Xm4nooh");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "II Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/18L8DJl80yN1Mk8WyZC7iZYzwuEQW5AX7");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1P7L6O1gCRgW4mNEbILHCAnR-szKFfXFn");
                break;
            case "III Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1X_ynckMlq4HaAZU7YUMtzz8nHHRTaA0t");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "III Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Mh2TUd0oT5Dhk0DJe1Aq6FMImEieA5-Z");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "III Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1RLrSNljXs5TgNSzFsxtDYZOojjmPIdin");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "III Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/12QUHEcApPK8jTsgek9YqSwJ03A5ZSMMp");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "III Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1FRFlKxDjK9TXUxWo1QLneVdmfw6nt_XC");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "III Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1YxWWfcwCP1yTgw4zVpxtyZsIynzjkitb");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "III Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1PJ5MTO-JE3YGq0L6AuQrljPVAm6D55V4");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-V7myTUgVlh4KQS9TRplheTUCrLIBjrZ");
                break;
            case "IV Semester_0":
                intent.putExtra("ANIMAL_NOTES", "Tiger");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "IV Semester_1":
                intent.putExtra("ANIMAL_NOTES", "Hen");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "IV Semester_2":
                intent.putExtra("ANIMAL_NOTES", "Fish");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "IV Semester_3":
                intent.putExtra("ANIMAL_NOTES", "Tiger");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "IV Semester_4":
                intent.putExtra("ANIMAL_NOTES", "Hen");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "IV Semester_5":
                intent.putExtra("ANIMAL_NOTES", "Fish");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "IV Semester_6":
                intent.putExtra("ANIMAL_NOTES", "Hen");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ik9hefYZIDtp6XxQtAjfXAU3DBGklmnc");
                break;
            case "V Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1JrrxZrNpUEwzqyebLEWPf9fwUlmq3kK0");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "V Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1tBIEX90FTNeJA2BJBt74UmcOjLVurEI1");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "V Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1oQktMiS8ynEv7zHh80mXiW1bzhenMB7M");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "V Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1rOXKOqNFTHj9V1-X7Aa-KGXHdMzFNV-6");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "V Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1v9PMMuQSTUGoUII8knEbOXIoqsu3rUsE");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "V Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1sPWFKVM6aQ6XUHUX-XclPzktm-J80QJ4");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "V Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1G6IOJ9U83yazksCiZmC7TnoYc-ngof8n");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Zsfft4tLgzW33OFlrzblXeUl6sgq8sim");
                break;
            case "VI Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/18V4cjNzvbeNC_XkQzvwBXPs_au5WlczX");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1KhYxxtbQzjS65yj26_fDp7vUdiAlaTlZ");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1ZM_sFJNSdQ9PuGiU1UZPDwfPBRETPcmR");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1VIybBbiVc9tfwNpBXfnIJVBmE4GNUnWg");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1E0RbjlUBmuwAFAFHIkzLITU07Ox4c2Of");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1rIIV1Gbx0UlZyZWbZxa-fgkdmWW5oJ93");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1FpO5D9tCMIda9aGPofdJDANCIMPSNimd");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VI Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/12AidnVgVEAInIWUCdJydeZFWEdOfD9dS");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1EAoFcYD8KoWsSeZH5MYnvb5MK1trAL4S");
                break;
            case "VII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1T2fJK_qfnnv6_J55cbjjkb2UuR-ozpOZ");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1I0y5mtBm36NMp7cP2C7QKezNMWcmFtHB");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1u6OXScf2KLGaD2Ht0ofa86YXdykHLp1y");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1kkOtCPgCawrBzIdBZTBPsX2dWppBXOYp");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1VI85H4QaVii6UOHmZJFu4SSJwfA6Fapp");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1qK6VQUrT3NM8KwQSwfIz-6Zv9SD2yJLZ");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1kpb8kqVFbKqDjFMyWj1Q8PJVOt8YT-k-");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VII Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/12sKkpcSEFccn_LQRerXhokryizT4m1ni");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14uPv7IEu6Cy7SThkii8YCoPK86kNXFSF");
                break;
            case "VIII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1TLfqndnrkucx9Q9QGC0FyQ0flIbFdutE");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "VIII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1fo8TMgMHtHNYe7617uOE8q09NQ1cuP-e");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "VIII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1UW81g1Eh8L4m1R6zRPKsOj8f6q2vhGTx");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "VIII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1DX5iYv-jLj1p6xCioeYVC6uCfVH8fjdM");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "VIII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1KYYszJr08sXjO1zc0lPVqUHy4883gUyu");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "VIII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1zTbc0w0WqPTp0VxWRUlFHO4l4-SnBekG");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "VIII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1XwnKY74lBZOaz2PYU3X3oae6sZ7LAYvU");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18L7kt1GNZ2i6e_WKJHSbQYBxU6TtzkVQ");
                break;
            case "IX Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1_tdFkJrdq239xn9EH-gfey-LHxYUJOMB");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/14JevUY5dVM4YNJk2GfGilRoMhjk945BG");
                break;
            case "X Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/130-m0qar70idkrN6r8rVZrWBhWRxQfuE");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1Q1Ax8uA7tBZ_t_7IHnR79UXKr5HxZkFw");
                break;
        }


        startActivity(intent);
    }
}