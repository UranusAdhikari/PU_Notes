package com.notes.pu_notes_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Yt_LinkFragment extends Fragment {

    public static Yt_LinkFragment newInstance(String ytLinkUrl) {
        Yt_LinkFragment fragment = new Yt_LinkFragment();
        Bundle args = new Bundle();
        args.putString("ANIMAL_YT_LINK", ytLinkUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_yt__link, container, false);

        WebView webView = rootView.findViewById(R.id.webView);
        String ytLinkUrl = getArguments().getString("ANIMAL_YT_LINK");

        if (ytLinkUrl != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(ytLinkUrl);
        }

        return rootView;
    }
}
