package com.example.readandwritejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        findViewById(R.id.CV1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutActivity.this,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.CV2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutActivity.this,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.CV3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutActivity.this,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.CV4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutActivity.this,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.CV5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutActivity.this,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.CV6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridLayoutActivity.this,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}