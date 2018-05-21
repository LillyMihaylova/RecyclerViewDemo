package com.example.demo.recyclerviewdemoapplication.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.demo.recyclerviewdemoapplication.R;
import com.example.demo.recyclerviewdemoapplication.models.Contact;
import com.example.demo.recyclerviewdemoapplication.ui.adapters.ContactsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        ContactsAdapter.MyContactViewHolder.OnContactItemClick {

    private ArrayList<Contact> contacts;
    private Contact contact;
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts = new ArrayList<>();

        buildContactsList();
        setupRecyclerView();
    }

    private void buildContactsList() {
        for (int i = 0; i < 100; i++) {
            contact = new Contact();
            contact.setName("George" + i);
            contact.setPhoneNumber("08754564" + i);
            contacts.add(contact);
        }
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactsAdapter(this, contacts, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onContactClick(int position) {
        String toastText = "Contact position: " + position;
        Toast.makeText(this, toastText,
                Toast.LENGTH_SHORT).show();
    }
}
