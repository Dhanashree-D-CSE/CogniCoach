package com.example.myapplication;


import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showallimages extends AppCompatActivity {
    DatabaseReference reference;

    RecyclerView recyclerview;
    ArrayList<uploadinfo> list;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showallimages);

        recyclerview=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<uploadinfo>();
        adapter = new ImageAdapter(list, showallimages.this);
        recyclerview.setAdapter(adapter);
        reference = FirebaseDatabase.getInstance().getReference().child("Images");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot1: snapshot.getChildren())
                {
                    uploadinfo u= dataSnapshot1.getValue(uploadinfo.class);
                    list.add(u);
                }

                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(showallimages.this,"OOPSSSS....:(",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
