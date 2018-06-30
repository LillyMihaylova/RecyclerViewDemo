package com.example.demo.recyclerviewdemoapplication.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.recyclerviewdemoapplication.R;
import com.example.demo.recyclerviewdemoapplication.models.Contact;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyContactViewHolder> {

    private ArrayList<Contact> contactsList;
    private MyContactViewHolder.OnContactItemClick listener;

    public ContactsAdapter(MyContactViewHolder.OnContactItemClick listener) {
        contactsList = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_contact, parent, false);

        return new MyContactViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactViewHolder holder, final int position) {
        holder.txtName.setText(contactsList.get(position).getName());
        holder.txtPhone.setText(contactsList.get(position).getPhoneNumber());

        holder.grpContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContactClick(position);
            }
        });
    }

    public void addItems(ArrayList<Contact> contacts) {
        this.contactsList = contacts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public static class MyContactViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtPhone;
        private LinearLayout grpContact;

        public MyContactViewHolder(View itemView, OnContactItemClick listener) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPhone = itemView.findViewById(R.id.txt_phone);
            grpContact = itemView.findViewById(R.id.grp_contact);
        }

        public interface OnContactItemClick {
            void onContactClick(int position);
        }
    }

}
