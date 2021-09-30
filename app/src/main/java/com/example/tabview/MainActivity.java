package com.example.tabview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        loadFragment(new FragmentOne());
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("tabs","" + tab.getPosition());
                if(tab.getPosition()==0)
                {
                    loadFragment(new FragmentOne());
                }
                else if(tab.getPosition()==1)
                {
                    loadFragment(new FragmentTwo());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void loadFragment(Fragment fragment)
    {
        FragmentManager fm =getFragmentManager();
        final FragmentTransaction ft =fm.beginTransaction();
        ft.replace(R.id.frmLayout, fragment);
        ft.commit();

    }
}