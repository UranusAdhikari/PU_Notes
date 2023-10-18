package com.notes.pu_notes_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifImageView;

public class Old_QuesFragment extends Fragment {

    public static Old_QuesFragment newInstance(String oldQuesUrl) {
        Old_QuesFragment fragment = new Old_QuesFragment();
        Bundle args = new Bundle();
        args.putString("ANIMAL_OLD_QUES", oldQuesUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_old__ques, container, false);

        final GifImageView loadingGifImageView = rootView.findViewById(R.id.loadingGifImageView);
        final WebView webView = rootView.findViewById(R.id.webView);
        String oldQuesUrl = getArguments().getString("ANIMAL_OLD_QUES");

        if (oldQuesUrl != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    // Show the custom loading animation when the page starts loading
                    loadingGifImageView.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.INVISIBLE); // Hide the WebView until the page is fully loaded
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    // Once the page is loaded, hide the custom loading animation and show the WebView
                    loadingGifImageView.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }
            });

            // Set a DownloadListener to handle file downloads
            webView.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                    // Handle the download request here
                    // You can use an intent to initiate the download
                    Uri uri = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });

            webView.loadUrl(oldQuesUrl);
        }

        return rootView;
    }
}
