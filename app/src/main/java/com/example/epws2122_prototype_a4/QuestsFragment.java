package com.example.epws2122_prototype_a4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.epws2122_prototype_a4.Adapter.SectionPageAdapter;
import com.google.android.material.tabs.TabLayout;


public class QuestsFragment extends Fragment {

    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        myFragment = inflater.inflate(R.layout.fragment_quests, container, false);

        viewPager = myFragment.findViewById(R.id.viewpager);
        tabLayout = myFragment.findViewById(R.id.tab_layout);


        return myFragment;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Offene");
        tabLayout.getTabAt(1).setText("Aktive");
        tabLayout.getTabAt(2).setText("Absolvierte");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new QuestsFragment_Offene(), "Offene" );
        adapter.addFragment(new QuestsFragment_Aktive(), "Aktiv");
        adapter.addFragment(new QuestsFragment_Absolvierte(), "Absolvierte");

        viewPager.setAdapter(adapter);
    }


}