package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fragments.fragment.Englishfragments;
import com.example.fragments.fragment.Hindifragments;
import com.example.fragments.fragment.Kannadafragments;
import com.example.fragments.fragment.Otherfragments;


public class MyViewPageAdapter extends FragmentStateAdapter {
    public MyViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Kannadafragments();

            case 1:
                return new Hindifragments();
            case 2:
                return new Englishfragments();
            case 3:
                return new Otherfragments();
            default:
                return new Kannadafragments();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
