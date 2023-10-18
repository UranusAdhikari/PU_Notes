package com.notes.pu_notes_app.ui.share_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.notes.pu_notes_app.databinding.FragmentShareAppBinding;

public class ShareAppFragment extends Fragment {

    private FragmentShareAppBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ShareAppViewModel shareViewModel =
                new ViewModelProvider(this).get(ShareAppViewModel.class);

        binding = FragmentShareAppBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Purbanchal University Notes");
            i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.notes.pu_notes_app");
            startActivity(Intent.createChooser(i, "Share with"));
        }catch(Exception e){
            Toast.makeText(getActivity(), "Unable to share this app", Toast.LENGTH_SHORT).show();
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}