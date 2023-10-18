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

public class Sub_Civil_Activity extends AppCompatActivity implements FragmentChangeListener {

    private LinearLayout cardContainer;
    private String[] subNames; // Declare the array to store subNames

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_civil);

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
        Intent intent = new Intent(Sub_Civil_Activity.this, Topic_Activity.class);
        intent.putExtra("SUB_NAME", subNames[fragmentNumber]);

        // Retrieve the selected card name from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String cardName = sharedPreferences.getString("SELECTED_CARD_NAME", "");

        // Combine fragmentNumber and cardName into a single identifier
        String combinedIdentifier = cardName + "_" + fragmentNumber;

        // Pass the data based on the selected card and fragment number
        switch (combinedIdentifier) {
            case "I Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1BOaiqIzz1ecjsYWGtZT1-h9a_kwrebEr");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "I Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1my-6S-PCnSvxwKo_bTs1hsMiK-FUp-LW");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "I Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1eobr50eyWtWnzAEyBzL0eFb1GB20ATY0");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "I Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1DVYiF0N8liQzdQmwVYIEnzYWHTl5JRCN");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "I Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Rt_pNRCECqI465S-jWsJhwE_Waczo9_e");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "I Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1dn_GIzdKIA7kusIyl7PP8SzGHwmx1jct");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "I Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1GBDipKG2NQTIzPQBpc605GGaNmpibM43");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1FSBJNBmquTu590l4zLyQWV3wj9p0hHal");
                break;
            case "II Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1fS3Vu-I-pW0vo3FvbMo0jnp30i75FQM_");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1pVzeP0PTBg94TvIcDQIj0QoKxkNKOli3");
                break;
            case "II Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1w_JVOd7AyChtEveQidYkBx_m21wPMIsc");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1pVzeP0PTBg94TvIcDQIj0QoKxkNKOli3");
                break;
            case "II Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1-ZX-NUU0YaLkEhpH0zDxFTLgZ4eUOXPH");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1pVzeP0PTBg94TvIcDQIj0QoKxkNKOli3");
                break;
            case "II Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1vmdYVSYZFwDEKwrMrDMO_mQMwTiCRLLD");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1pVzeP0PTBg94TvIcDQIj0QoKxkNKOli3");
                break;
            case "II Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1gyhsp2XzdIC9XHi7YrHldMDSkZjYWd2x");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1pVzeP0PTBg94TvIcDQIj0QoKxkNKOli3");
                break;
            case "II Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1BoXmC67MckJHgzAMbV6vw-_JCMAebghK");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1pVzeP0PTBg94TvIcDQIj0QoKxkNKOli3");
                break;
            case "III Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1ePXcSjScqKM1tROLRKkMgcWvaEAHdmzi");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "III Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1rSxicMBFj8DTrZdLAv3M6qHZQLqE9x-X");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "III Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1YjmtWVhYcLObqErnnuP2T-Cibk7z7zid");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "III Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/16wAP8g3Ta8gShjJqKoaPxxfOZiTpDGD6");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "III Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1igLwnHQgz-47mBih5S8R1kH3IXkZHWZE");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "III Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1h3ATLhnSWdbybnFRQCTBJReNP8vLKFdI");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "III Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1sQhVJZf424uwBaAPSgFD8NjfJ60jvI6a");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/13SyTI6y1oidP3npmeU5pLY_hS8_CQqXU");
                break;
            case "IV Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/JicLsxmEm89NrtJ");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "IV Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/oB2EfCKKy7LEwdC");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "IV Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/FyXqN5K9meBrcs6");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "IV Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/D3JaGkB4mrmnmkN");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "IV Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/XM4p8mKie4tCKYC");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "IV Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/r5EJmTCSiJY2SYY");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "IV Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://space.shahiupendra.com.np/index.php/s/dz43HnzTpbYdEHQ");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1zR4fG8lKeMB2ZKo2kOPMTFOsSdnWvBgy");
                break;
            case "V Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/109TgdweDAJhoTxOucmT_RHA7d1vh4l0c");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "V Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1xQQB4p1VEKYM4jpbvn72TB1XU7ZtL99q");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "V Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1n2BnfSa28aBMt3KdUN-jRLlSaTqgQdAh");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "V Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1yapKXPXnR7QQsJTt3hZUW5TFwumcJRnw");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "V Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1sNRxWDcrqx3QemLJy858UM07Pofqg1WB");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "V Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/17p9fYuvqcvJq_9YoLLx4pFHQ5HbwsHQb");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "V Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/14_VXDHLxZJZ7Tvi9c72NOxp-luSrUoEV");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1LuP2SalIC1a1rWE2ZfOkWYJ3vGXlYgGm");
                break;
            case "VI Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/194kMeEn7W16kbZfiqOCIpMIl7OlOTVmC");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1wC-0xWPoKOeyCUh2Vq27wACEz1AkPH9x");
                break;
            case "VI Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1XLFcRG15NGN5epYzCSbG6G3wee6OKtSd");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1wC-0xWPoKOeyCUh2Vq27wACEz1AkPH9x");
                break;
            case "VI Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1drvKRhYRcKeAFbBB6K_TKoZTdKRtPbdr");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1wC-0xWPoKOeyCUh2Vq27wACEz1AkPH9x");
                break;
            case "VI Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Nnn5r32zSOVTy-vudUtxk4-trlQ4nAqx");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1wC-0xWPoKOeyCUh2Vq27wACEz1AkPH9x");
                break;
            case "VI Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1zNmfygkcJXY2p3nbz10KaDJvPn6vEkQY");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1wC-0xWPoKOeyCUh2Vq27wACEz1AkPH9x");
                break;
            case "VI Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1MTvXpGS7p1qHoMWpiCvugjgm43Xka7Jb");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1wC-0xWPoKOeyCUh2Vq27wACEz1AkPH9x");
                break;
            case "VII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1HZtJUfoI1K6SfU2JGS4__wZcpdo_mfZx");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1rk22SgGYTp7o78SIMk1H9XL7Rmf2ErSz");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1i0niy7ZU3wzYQOB4xHB3j2mQzfzym2gS");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Zder1LyizNQf9gj4ixkRL5PRGiqtLLi0");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1FjnunbyYTXouxwC6xYujenDpWiqQj_YQ");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1sNxltACeip9PBMOStabfMa7UONkdaKDj");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1CgmewqqhZEKL4V5Qni4zOEdWQpnbxxFp");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1GKCfqtjRzjuJkqV_8tT15txRi2JXyvsP");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_8":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1oZV98koqzq3-Pj3XCdpdoYoroWelk6EG");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_9":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1v08_49Nk2x9eGVZ7qTlMS1OwcPQWkgFy");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_10":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1M-9XVCAD5VoQkEyOUULzr5TQQqRQnt1L");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_11":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/16nYCtXBtj9w_BVlrCJkaCQh5HS-m83Ni");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VII Semester_12":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1T-xJlO0G6QXRWWq5v3HujS-YZMl4Vdee");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/12iIky1LoaD53sM8zNUc5Ad-HXho1jKk6");
                break;
            case "VIII Semester_0":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1Lm5T77egOeD4ywD2sqCQmqpt24AhWzv6");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_1":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1DKU2igVnDaj1GK5qHVOKiimEomhKR7XN");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_2":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1S_DnC7RjCwk0rz9obFRoPsLimnvvqmIx");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_3":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1R-m5RMx0-Uynxul5w0kz3hWE1mna9gvK");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_4":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1vQnaurhronEKqLUL5N6EnlGe_CaCWH93");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_5":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/16jpW6rn6HuSesc9ib5BxpPmzwj7H1QDk");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_6":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1usgg9-i86SVPxSCC7Sd9ziuYwIIAARvb");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_7":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/13VJqFwPKSdrvHq8ayJB8PTucu0RrL6gO");
                intent.putExtra("ANIMAL_YT_LINK", "Ostrich");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_8":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1CIpU9YraLP4CSoXtEaYNyaDrH_OccJ9a");
                intent.putExtra("ANIMAL_YT_LINK", "Sir");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
            case "VIII Semester_9":
                intent.putExtra("ANIMAL_NOTES", "https://drive.google.com/drive/u/2/folders/1DGsW4nE1FTthAGlMIMm-pa8yPrdD2PmR");
                intent.putExtra("ANIMAL_YT_LINK", "Lion");
                intent.putExtra("ANIMAL_OLD_QUES", "https://drive.google.com/drive/u/2/folders/1kvIANFVoIWgOgErE8Bps-icnPOEt5lHQ");
                break;
        }
        startActivity(intent);
    }
}