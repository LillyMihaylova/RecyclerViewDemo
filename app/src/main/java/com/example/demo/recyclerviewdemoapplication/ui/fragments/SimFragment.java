package com.example.demo.recyclerviewdemoapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.demo.recyclerviewdemoapplication.R;
import com.example.demo.recyclerviewdemoapplication.models.Contact;
import com.example.demo.recyclerviewdemoapplication.ui.adapters.ContactsAdapter;

import java.util.ArrayList;

public class SimFragment extends Fragment implements ContactsAdapter.MyContactViewHolder.OnContactItemClick {

    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private ArrayList sortedContacts;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_sim, container, false);
        adapter = new ContactsAdapter(this);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        sortedContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if (!contacts.get(i).isInPhone()) {
                sortedContacts.add(contacts.get(i));
            }
        }
        adapter.addItems(sortedContacts);
    }

    @Override
    public void onContactClick(int position) {
        Toast.makeText(getActivity(), "Contact position: " + position, Toast.LENGTH_LONG).show();
    }
}
