package com.example.readandwritejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadImageActivity extends AppCompatActivity {

    private int[] ImageViewIds= new int[]{R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6};
    private int[] TextViewIds= new int[]{R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6};
    private String[] TextTitle=new String[]{"Fruits","Furnitures","Grocery","Lunchbox","Moon","Noodles"};
    private int[] ImagesId=new int[]{R.drawable.ic_fruits,R.drawable.ic_furnitures,R.drawable.ic_grocery,R.drawable.ic_lunchbox,
            R.drawable.ic_moon,R.drawable.ic_noodles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        for(int i=0;i<ImageViewIds.length;i++){
         ImageView imageView=findViewById(ImageViewIds[i]);
         imageView.setImageResource(ImagesId[i]);
         TextView textView=findViewById(TextViewIds[i]);
         textView.setText(TextTitle[i]);
        }
    }
}