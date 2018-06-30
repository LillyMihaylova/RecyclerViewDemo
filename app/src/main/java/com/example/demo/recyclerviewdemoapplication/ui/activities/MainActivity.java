package com.example.demo.recyclerviewdemoapplication.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.demo.recyclerviewdemoapplication.R;
import com.example.demo.recyclerviewdemoapplication.models.Contact;
import com.example.demo.recyclerviewdemoapplication.ui.adapters.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Contact> contacts;
    private Contact contact;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragmentPagerAdapter pagerAdapter;
    private Toolbar toolbar;
    private boolean isTabsCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupTabs();
        buildContactsList();
    }

    private void buildContactsList() {
        for (int i = 1; i <= 30; i++) {
            contact = new Contact();
            contact.setName("George" + i);
            contact.setPhoneNumber("08754564" + i);
            if (i % 2 == 0) {
                contact.setInPhone(true);
            } else {
                contact.setInPhone(false);
            }
            contacts.add(contact);
        }
        pagerAdapter.setContacts(contacts);

    }

    private void setupTabs() {
        if (!isTabsCreated) {
            tabLayout.addTab(tabLayout.newTab().setText("SIM"));
            tabLayout.addTab(tabLayout.newTab().setText("PHONE"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            isTabsCreated = true;
        }

        pagerAdapter = new FragmentPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        pagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(pagerAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                pagerAdapter.setContacts(contacts);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }


}
