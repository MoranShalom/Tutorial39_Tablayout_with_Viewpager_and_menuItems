package com.example.tablayoutwithviewpagerandmenuitems;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;



public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    PageAdapter pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_title);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.chatstab);
        tabStatus = findViewById(R.id.statustab);
        tabCalls = findViewById(R.id.callstab);

        viewPager = findViewById(R.id.viewPager);

        //define PageAdapter.
        //Here you pass 2 arguments: Android getSupportFragmentManager()
        // and the total number of tabs in Android Tablayout.
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Now you can use pageAdapter as the adapter for Android ViewPager.
        viewPager.setAdapter(pageAdapter);

        //ow you got the swipe function working, but the problem is Android
        // Tablayout indicator doesn’t change while you swipe to other tabs!
        //This line will fix it by attaching Android Tablayout with Viewpager,
        // so when you try to swipe it will sync with Tablayout tabs indicator.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
