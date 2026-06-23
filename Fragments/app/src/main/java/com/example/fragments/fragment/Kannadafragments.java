package com.example.fragments.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Kannadafragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Kannadafragments extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kannadafragments, container, false);
    }
}