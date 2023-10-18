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

public class Sub_Elex_Activity extends AppCompatActivity implements FragmentChangeListener {

    private LinearLayout cardContainer;
    private String[] subNames; // Declare the array to store subNames

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_elex);

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
        Intent intent = new Intent(Sub_Elex_Activity.this, Topic_Activity.class);
        intent.putExtra("SUB_NAME", subNames[fragmentNumber]);

        // Retrieve the selected card name from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String cardName = sharedPreferences.getString("SELECTED_CARD_NAME", "");

        // Combine fragmentNumber and cardName into a single identifier
        String combinedIdentifier = cardName + "_" + fragmentNumber;

        // Pass the data based on the selected card and fragment number
        switch (combinedIdentifier) {
            case "I Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1hEIDSn5EWRJ3in-aEBBCfGoY0dVvyh95");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1h-vBuqsDUGRkhMYkH0g4AdzF7V7xhxV8");
                break;
            case "I Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1_jELMnaQ9etVw3MjObW7xRowPn94E32A");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1h-vBuqsDUGRkhMYkH0g4AdzF7V7xhxV8");
                break;
            case "I Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1UEVYh8JgjJuFAKC2Rrzk-qIJLEYq39t6");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1h-vBuqsDUGRkhMYkH0g4AdzF7V7xhxV8");
                break;
            case "I Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1faFN2Vd2bk8YtX6RxmXadbOQA0AdiPYj");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1h-vBuqsDUGRkhMYkH0g4AdzF7V7xhxV8");
                break;
            case "I Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1aiyp_0cKGlHDDdPrQZHCvmhVYVe7lUx0");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1h-vBuqsDUGRkhMYkH0g4AdzF7V7xhxV8");
                break;
            case "I Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Qs8vldh3InC-YDQI5eFKR5rSg2a8Ky5H");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1h-vBuqsDUGRkhMYkH0g4AdzF7V7xhxV8");
                break;
            case "II Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1UrymSdCh3LwsTel3Lb1Zb4--YseCo18J");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1nb9gA28uI9FsdXglOdkFown9pppeZZIL");
                break;
            case "II Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1rPOgnS1LIJDFUKtHG5wwHp93sygsKncD");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1nb9gA28uI9FsdXglOdkFown9pppeZZIL");
                break;
            case "II Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1zhR08DyDohNy70XjKTsg_ZmBVBjc_ax4");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1nb9gA28uI9FsdXglOdkFown9pppeZZIL");
                break;
            case "II Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1BJVMDPkkwkMOa_BnTa_GtsEpW4n96CFr");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1nb9gA28uI9FsdXglOdkFown9pppeZZIL");
                break;
            case "II Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1lVifUEks-wEgQApRB8xz_30_HGL8jVF0");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1nb9gA28uI9FsdXglOdkFown9pppeZZIL");
                break;
            case "II Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1YYex3cVl3xpVUm-t9DM_z-yuZvIka8oi");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1nb9gA28uI9FsdXglOdkFown9pppeZZIL");
                break;
            case "III Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1KdesLMFxvsIfTharSGVWfxfpB4rmscZ_");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1PhQKTykwu-F8JI3UD-o8VS4txwNbZc-S");
                break;
            case "III Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1TdafzWeS9ev3qAmNy7KQ-L-rT9ZobgVB");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1PhQKTykwu-F8JI3UD-o8VS4txwNbZc-S");
                break;
            case "III Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/13WJcC7kVmjODs3DycJowmDN7seF-mDR_");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1PhQKTykwu-F8JI3UD-o8VS4txwNbZc-S");
                break;
            case "III Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1IMC3YgBPCmkYpDANZ0qEPKmGelzQ0wnr");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1PhQKTykwu-F8JI3UD-o8VS4txwNbZc-S");
                break;
            case "III Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1yhAcU-AxJl03euq4SEE1n0OqB4j9x0s2");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1PhQKTykwu-F8JI3UD-o8VS4txwNbZc-S");
                break;
            case "III Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1yiQVMOGuZXC9YUmO18NQ2CgxsQhx7AS3");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1PhQKTykwu-F8JI3UD-o8VS4txwNbZc-S");
                break;
            case "IV Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/Zozx7GCHzpZfzG4");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1qH17RFqssfHUnd6xBv4chnqr-k5DqJdl");
                break;
            case "IV Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/Z7M8XCmNaqWgDJD");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1qH17RFqssfHUnd6xBv4chnqr-k5DqJdl");
                break;
            case "IV Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/tQpFn2ANwDpZnjJ");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1qH17RFqssfHUnd6xBv4chnqr-k5DqJdl");
                break;
            case "IV Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/YkFCAgFSATiHWLo");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1qH17RFqssfHUnd6xBv4chnqr-k5DqJdl");
                break;
            case "IV Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/CjTmQgKA76aTg4S");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1qH17RFqssfHUnd6xBv4chnqr-k5DqJdl");
                break;
            case "IV Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/A3ETPNq2QpL2H8r");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1qH17RFqssfHUnd6xBv4chnqr-k5DqJdl");
                break;
            case "V Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1daMuJ214yVnPvRO07NE2rvH1izu0Aazw");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1StlLGoQ8e_jHSQkjQqoVltkPAPlPb1IZ");
                break;
            case "V Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1XbC_Qah43BT0qRJW9FSzCCxMq-0xRLsM");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1StlLGoQ8e_jHSQkjQqoVltkPAPlPb1IZ");
                break;
            case "V Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1SZN4yjclUqSkvzWEuJWZGIqSCMqgli-d");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1StlLGoQ8e_jHSQkjQqoVltkPAPlPb1IZ");
                break;
            case "V Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/14wN28YYCFJ_Z8FC6CfTsxNLAzm4AOz3k");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1StlLGoQ8e_jHSQkjQqoVltkPAPlPb1IZ");
                break;
            case "V Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1ahw5mEXbthLR98kZWIHNlVDSp1-XCKKC");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1StlLGoQ8e_jHSQkjQqoVltkPAPlPb1IZ");
                break;
            case "V Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1tdM-fZMwHUlo-SgponeBXJnXyWjJyoMN");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1StlLGoQ8e_jHSQkjQqoVltkPAPlPb1IZ");
                break;
            case "VI Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/12sQ_zyFFvMvhbZEYq8zeo3dKuYb3sRZ5");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mqO9Za8faafKvYylr3N4LVxfLH8HRbVS");
                break;
            case "VI Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1eUVDaxUdIJuk8KNUllDHwLKO1W-87eZ-");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mqO9Za8faafKvYylr3N4LVxfLH8HRbVS");
                break;
            case "VI Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1CQJ2wq8ON5H1wXzG53rBhmiomt8hL3t3");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mqO9Za8faafKvYylr3N4LVxfLH8HRbVS");
                break;
            case "VI Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1xYCnpEI6MjdwlMpb71fl28mxCnuzUybg");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mqO9Za8faafKvYylr3N4LVxfLH8HRbVS");
                break;
            case "VI Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1isy0yq2CtAPRIHugh-9Ud2NLb4GtDixZ");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mqO9Za8faafKvYylr3N4LVxfLH8HRbVS");
                break;
            case "VI Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/19yys19jqULrfas3OYlthEgz0yx_6TPEN");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1mqO9Za8faafKvYylr3N4LVxfLH8HRbVS");
                break;
            case "VII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1KUDPoU2FEwtW-Oi8SWTIMpzVrPXOahiW");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1muYxsdlSk2VQ5SS23pAt2wYBUfF0Af5c");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/16yvGvdyQrukCoqI4BHIFn7K4AHDfQs6m");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/19O9CK7xvrf7TjRFtp3Wr8twDWLZIeQVp");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1JmgAaBjKIAWtu5rtjxuaGZK6FBmVHXsR");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/16mweZjazk3YmjhcFJcmwufU0frIAN3AW");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1bAHtFiNGEjT8jy-M0ra0m7rn2r-p0JdT");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1YERuxdqFiBKGc6Pex_91SmDZ4_rRSpBF");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_8":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1fxH5OpuD4rsCSufn9ErBL70w5LZEIKCP");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_9":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1ckgOuJa8epvEieLqNPNacBpMghxgMpJ_");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_10":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Rzvd6gEKjJLKSq_0_Hvz1sFmLMoF72B5");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_11":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1frmI9EFX48RHuHbes9R1Ooxi8Lv6czqg");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_12":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Y77lLFZ9E98jFa_XJg7BJIFC5u2hNkTp");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_13":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1bzBcaVbW0Z3H3QdQSUotaeaYdXoXUG7Y");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_14":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1MhDVnmgLQByE7nuX49SuUoIC4mRqBHZw");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VII Semester_15":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/12yk0p4stT1MMSUssBN9ZU3z4rG2SIe2X");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/16ZUEJYOn3BcEnrV4mrmskdh452IyGgW2");
                break;
            case "VIII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1EEy58Bb1xTw3AWP6lKLsK-WI8BIAmDpw");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/15MrE4DoQfmFpYm5AT7BMQAogK-kNiGRK");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1REfKvXgr8x_3zz5DI4ffCCLpVkEhJJPG");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1cirKaiaVdunBXPBdYtpyftUdpcCDCPw4");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/133kEm9AM7Xbk-dVauALRrWc2DVvlONnO");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1vXYkQLbemqQUU4EmhPb1TDCbtoALfHxC");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1XifZbfmAxta_U6EbpB1okM4jz9MlRXKg");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1txOtia6Cn87JUZICAZ8ie9CLS5DvVnpy");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;
            case "VIII Semester_8":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1RKcmaX7Asr1qMD17oUlWbIYOAamUrNOQ");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1ATN4dJmjTuqituIJuq9MTsTgQCxT8VlZ");
                break;


        }

        startActivity(intent);
    }
}