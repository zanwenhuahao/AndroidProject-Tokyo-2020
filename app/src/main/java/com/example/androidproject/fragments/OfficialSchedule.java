package com.example.androidproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.ScriptC;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


import com.example.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class OfficialSchedule extends Fragment {

        View Scheduleview;

        public OfficialSchedule() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            this.Scheduleview = inflater.inflate(R.layout.fragment_official_schedule, container, false);
            WebView webviewFAQ = (WebView) Scheduleview.findViewById(R.id.ScheduleWebview);
            webviewFAQ.loadUrl("https://tokyo2020.org/en/schedule/");

            return Scheduleview;

        }
    }