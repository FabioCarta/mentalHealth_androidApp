package com.example.epws2122_prototype_a4.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;


public class SectionPageAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();




    public SectionPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public SectionPageAdapter(FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public CharSequence getFragmentTitle(int position){
        return titleList.get(position);
    }

    public void addFragment(Fragment fragment, String  title){
        fragmentList.add(fragment);
        titleList.add(title);
    }

}
