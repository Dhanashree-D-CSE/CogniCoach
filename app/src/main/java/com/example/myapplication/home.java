package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    ImageButton locb,remb,lov,vault;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        locb = (ImageButton)findViewById(R.id.locbtn);
        remb = (ImageButton)findViewById(R.id.rembtn);
        lov = (ImageButton)findViewById(R.id.lovbtn);
        vault = (ImageButton)findViewById(R.id.vaultbtn);
        locb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentm= new Intent(home.this,location.class);
                startActivity(intentm);

            }
        });
        remb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentr= new Intent(home.this,rem_main.class);
                startActivity(intentr);
            }
        });
        lov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentl= new Intent(home.this,lovedones.class);
                startActivity(intentl);
            }
        });
        vault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentv= new Intent(home.this,vault_show.class);
                startActivity(intentv);

            }
        });


    }
}