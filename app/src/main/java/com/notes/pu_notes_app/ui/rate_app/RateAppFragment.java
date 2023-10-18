package com.notes.pu_notes_app.ui.rate_app;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.notes.pu_notes_app.databinding.FragmentRateAppBinding;


public class RateAppFragment extends Fragment {

    private FragmentRateAppBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RateAppViewModel rateAppViewModel =
                new ViewModelProvider(this).get(RateAppViewModel.class);

        binding = FragmentRateAppBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

/*        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=facebook")));
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Phonebook Nepal");
        i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?="+getApplicationContext().getPackageName());
        startActivity(Intent.createChooser(i, "Share with"));
*/

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.notes.pu_notes_app");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(i);
        }catch(Exception e){
            Toast.makeText(getActivity(), "Unable to open\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}