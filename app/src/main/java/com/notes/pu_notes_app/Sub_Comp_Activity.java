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

public class Sub_Comp_Activity extends AppCompatActivity implements FragmentChangeListener {

    private LinearLayout cardContainer;
    private String[] subNames; // Declare the array to store subNames

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_comp);

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
        Intent intent = new Intent(Sub_Comp_Activity.this, Topic_Activity.class);
        intent.putExtra("SUB_NAME", subNames[fragmentNumber]);

        // Retrieve the selected card name from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String cardName = sharedPreferences.getString("SELECTED_CARD_NAME", "");

        // Combine fragmentNumber and cardName into a single identifier
        String combinedIdentifier = cardName + "_" + fragmentNumber;

        // Pass the data based on the selected card and fragment number
        switch (combinedIdentifier) {
            case "I Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1CF7qC8Pp_9KzwWcI2ca5oH10jaGsyONZ");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "I Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1XkF3oqL3xM43Vtgv0djEw35zN1SGlPKR");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "I Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1C8tD_r6XyYtoDBRYC36DssmcGjr83KSD");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "I Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1JwfBc3mMu1m1ComK20-LHGNvGchPX5da");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "I Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1DZBZOBpKotYUlXVgVh8kcnRxVJ18Lw1m");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "I Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1ffLmQVIrmnLVIku7E0mH5DmDCg1u0YqW");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "I Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1usom5nm70n5B5RVtK3nTImCfOAcrAA6O");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "II Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1dnkfiU-eLnz3M13av1zN9rOACE0-c5Ap");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "II Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1QuSpKJsepj32N1nfNMK5uxb_JHPKR0Su");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "II Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/145YbdkXRKkLi94A6DoRVxg2kL4KksWD2");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "II Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1D05nE4YD1JA-BPIKkKYIg-gb741PQT_p");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "II Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1xxBSUP5Ma6H61AjNUeH-pUuKtv9tc2vl");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "II Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1TEZdK_6sIYQFD65GyqBAIUPTMOq6o4eW");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1KbrQi_PhXci7CNtj_1d262TSOTeWxI2z");
                break;
            case "III Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1uOVlifuL6qK74Rr9_ALdIj4NC_FBgKDO");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19mC2Cf7lDSh8iBhkOCG5k-yrGqf6JMLt");
                break;
            case "III Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1WkEirxiSculPJwtESei9wwg0XF2flXiJ");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19mC2Cf7lDSh8iBhkOCG5k-yrGqf6JMLt");
                break;
            case "III Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1k6a7GwtMFGHGP-lfn_Wl3exft7JGq2Xu");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19mC2Cf7lDSh8iBhkOCG5k-yrGqf6JMLt");
                break;
            case "III Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Jaa00gob36iaDIlakHT6tJ0BG1zmvXBe");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19mC2Cf7lDSh8iBhkOCG5k-yrGqf6JMLt");
                break;
            case "III Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1f1KdTARBbCiw05LBUShuXBz3c6lBFcvp");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19mC2Cf7lDSh8iBhkOCG5k-yrGqf6JMLt");
                break;
            case "III Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1xVjPJ-JfsMng-UYGr09B0mI79Y_l4hzH");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19mC2Cf7lDSh8iBhkOCG5k-yrGqf6JMLt");
                break;
            case "IV Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/jXst7ZcTaP6zWmq");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1M1LI3j90RqrhcVnyfKD4F9iayCPYNotN");
                break;
            case "IV Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/wtcw4i8QC9oePr2");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1M1LI3j90RqrhcVnyfKD4F9iayCPYNotN");
                break;
            case "IV Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/cxESJ7ydWfw49o5");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1M1LI3j90RqrhcVnyfKD4F9iayCPYNotN");
                break;
            case "IV Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/Z67PkZtMJ4wKSbP");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1M1LI3j90RqrhcVnyfKD4F9iayCPYNotN");
                break;
            case "IV Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/dD3zre78HjRJDmy");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1M1LI3j90RqrhcVnyfKD4F9iayCPYNotN");
                break;
            case "IV Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/B6wrR8EqHxet6Sj");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1M1LI3j90RqrhcVnyfKD4F9iayCPYNotN");
                break;
            case "V Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1sG-7Vjvl9aPvmGUbWtnglsosrRWWt_TL");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18dDRFfkt9rCZYcMT-LglSIQUoHGYx65q");
                break;
            case "V Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1TFnrRI_YTdU5xdyweXsTPBu41Ky0M88j");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18dDRFfkt9rCZYcMT-LglSIQUoHGYx65q");
                break;
            case "V Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1QPsT13AyUcv6dQ72-MtnLRLMdd8Giwwj");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18dDRFfkt9rCZYcMT-LglSIQUoHGYx65q");
                break;
            case "V Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Im4_rIoh0qhKzUmcPuoFlSroD4z-dccq");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18dDRFfkt9rCZYcMT-LglSIQUoHGYx65q");
                break;
            case "V Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1jSmaiDrn6GQ5gCWkOlSsbnsgQCLhm_Gw");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18dDRFfkt9rCZYcMT-LglSIQUoHGYx65q");
                break;
            case "V Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1KROmum2NPd_WTwURO-CrPXvcmaXlGCQy");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/18dDRFfkt9rCZYcMT-LglSIQUoHGYx65q");
                break;
            case "VI Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1G03FI6bNdbyGDes--y04NPfCaVeLOC0k");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19ykWSgQGKoy6sWvSjKl8Cty6p7oOS6oX");
                break;
            case "VI Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Z7Y-_9_AmBFRWDwQZ_iHID3-z-LAPCx_");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19ykWSgQGKoy6sWvSjKl8Cty6p7oOS6oX");
                break;
            case "VI Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/14k42JgtavhOgVBllcprJ8rciQV_lIFl_");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19ykWSgQGKoy6sWvSjKl8Cty6p7oOS6oX");
                break;
            case "VI Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1wF9VgIkLPjV-Gd5yV3HFXZd9aW-lSsuD");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19ykWSgQGKoy6sWvSjKl8Cty6p7oOS6oX");
                break;
            case "VI Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1n7Sb5HUreov91jS5eq5jmdUzPP5bXp0O");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19ykWSgQGKoy6sWvSjKl8Cty6p7oOS6oX");
                break;
            case "VI Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1JtS18GCnnOkyTV_hoel-lYvEoAqdP-5F");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/19ykWSgQGKoy6sWvSjKl8Cty6p7oOS6oX");
                break;
            case "VII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1HW6v9AQ3FE6z37HWQpc9kepVM1J4giVe");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1lOjIQaBCQ9JgNRthL5SxA3FxfVsRixzQ");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1pNjp4ECFYsGtLdaQtIP5gkVh4tfkMEOr");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1N8pFwW_m2PxRnYvkNHx4QmO054l8zl0M");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1L0l0nRoQP2VQVCDUFeq3YFEFeykRskc-");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/14z00xESRuN-rMdmthIqJyRFGpnHZ5DL7");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/13vKbays7uRnQZLyYt75tUo67-RdeiyUo");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VII Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1UDNzvGS0jyGF3g0emKhDEUNsBK-9wp9o");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1-zxmToDBLmIhkbXtq4np00GXr8bWbwWn");
                break;
            case "VIII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1eBAdGWJDCw7CN1cEhaYf-_ITcfuoeLJy");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;
            case "VIII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1TIza3Mwj2pBpUGbq4uukKGB_xnEA2uOE");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;
            case "VIII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1To4FFxixP7xsflIv_PMOFxt7tAe1jgJM");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;
            case "VIII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1MfcaQr2MKf0f98nkD2L1T1pFdq09Sz6U");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;
            case "VIII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1HoPSICoMF0PTBrdrI2GxjToJWpzlVdjH");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;
            case "VIII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1aLio6cnviUCLYjn_Dojk5-6CO-l3Zam-");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;
            case "VIII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1OYcfmIH0gEEckXdNBoKgFMdbAwMX6Zqb");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/11ogruV9NT0YRXKg6CTIhf64OCfrfZsOJ");
                break;


        }

        startActivity(intent);
    }
}