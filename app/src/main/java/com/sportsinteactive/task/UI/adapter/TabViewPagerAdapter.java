package com.sportsinteactive.task.UI.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabViewPagerAdapter extends FragmentPagerAdapter {


    Context context;
    ArrayList<Fragment> fragmentArrayList;
    String team1Name ="";
    String team2Name ="";



    public TabViewPagerAdapter(Context context, @NonNull FragmentManager fm, ArrayList<Fragment> fragmentArrayList,String team1Name,String team2Name) {
        super(fm);
        this.context = context;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.fragmentArrayList = fragmentArrayList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentArrayList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = team1Name;
        } else if (position == 1) {
            title = team2Name;
        }
        return title;
    }
}
