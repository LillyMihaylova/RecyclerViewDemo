package com.example.demo.recyclerviewdemoapplication.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.demo.recyclerviewdemoapplication.models.Contact;
import com.example.demo.recyclerviewdemoapplication.ui.fragments.PhoneFragment;
import com.example.demo.recyclerviewdemoapplication.ui.fragments.SimFragment;

import java.util.ArrayList;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private int numOfTabs;
    private SimFragment simFragment;
    private PhoneFragment phoneFragment;

    public FragmentPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
        simFragment = new SimFragment();
        phoneFragment = new PhoneFragment();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return getSimFragment();
            case 1:
                return getPhoneFragment();
            default:
                return null;
        }
    }

    @NonNull
    private Fragment getSimFragment() {
        if (simFragment == null) {
            simFragment = new SimFragment();
        }
        return simFragment;
    }

    @NonNull
    private Fragment getPhoneFragment() {
        if (phoneFragment == null) {
            phoneFragment = new PhoneFragment();
        }
        return phoneFragment;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        if (simFragment != null) {
            simFragment.setContacts(contacts);
        }

        if (phoneFragment != null) {
            phoneFragment.setContacts(contacts);
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
