package com.example.juliette.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;

import android.view.View;
import android.view.ViewGroup;

public class Tab1Calendario extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1calendario, container, false);

        return rootView;
    }
}
