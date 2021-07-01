package com.example.android.chattingapp;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new chatFragment();
        }
        else if(position==1){
            return new statusFragment();
        }
        else if(position==2){
            return new callFragment();
        }
        else{
            return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
