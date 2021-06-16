package com.example.readandwritejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoadImageActivity extends AppCompatActivity {

    private String[] TextTitle=new String[]{"Fruits","Furnitures","Grocery","Lunchbox","Moon","Noodles"};
    private int[] LinearLayoutIds=new int[]{R.id.ll1,R.id.ll2,R.id.ll3,R.id.ll4,R.id.ll5,R.id.ll6};
    private int[] ImagesId=new int[]{R.drawable.ic_fruits,R.drawable.ic_furnitures,R.drawable.ic_grocery,R.drawable.ic_lunchbox,
            R.drawable.ic_moon,R.drawable.ic_noodles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        for(int i=0;i<LinearLayoutIds.length;i++){
            LayoutInflater layoutInflater=getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.showlayout,null);
            LinearLayout linearLayout=findViewById(LinearLayoutIds[i]);
            linearLayout.addView(view);

         ImageView imageView=view.findViewById(R.id.imageView);
         imageView.setImageResource(ImagesId[i]);
         TextView textView=view.findViewById(R.id.textView);
         textView.setText(TextTitle[i]);
        }
    }
}