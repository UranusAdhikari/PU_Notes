package com.notes.pu_notes_app.ui.home;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.notes.pu_notes_app.R;
import com.notes.pu_notes_app.Sem_Arch_Activity;
import com.notes.pu_notes_app.Sem_Civil_Activity;
import com.notes.pu_notes_app.Sem_Comp_Activity;
import com.notes.pu_notes_app.Sem_Elex_Activity;
import com.notes.pu_notes_app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private Activity context; // Changed variable name to avoid confusion with getContext() method
    private FragmentHomeBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.context = (Activity) context;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        CardView crd1 = (CardView) context.findViewById(R.id.card1);
        CardView crd2 = (CardView) context.findViewById(R.id.card2);
        CardView crd3 = (CardView) context.findViewById(R.id.card3);
        CardView crd4 = (CardView) context.findViewById(R.id.card4);

        // Card1
        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Sem_Arch_Activity.class);
                startActivity(intent);
            }
        });

// Card2
        crd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Sem_Civil_Activity.class);
                startActivity(intent);
            }
        });

// Card3
        crd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Sem_Comp_Activity.class);
                startActivity(intent);
            }
        });

// Card4
        crd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Sem_Elex_Activity.class);
                startActivity(intent);
            }
        });

    }
}
