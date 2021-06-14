package com.example.readandwritejson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    private TextView showData;
    File file;
    private static final String FILE_NAME="sample2.json";
    private JSONObject data;
    FileReader fileReader=null;
    FileWriter fileWriter=null;
    BufferedReader bufferedReader=null;
    BufferedWriter bufferedWriter=null;
    String response=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showData=findViewById(R.id.showData);
        file=new File(this.getFilesDir(),FILE_NAME);
        if(!file.exists()){
            try {
                file.createNewFile();
                fileWriter=new FileWriter(file.getAbsoluteFile());
                bufferedWriter=new BufferedWriter(fileWriter);
                bufferedWriter.write("{}");
                bufferedWriter.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        findViewById(R.id.WriteJSON).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteJSON();
            }
        });

        findViewById(R.id.ReadJSON).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  ReadJSON();
            }
        });
    }

    public void WriteJSON(){
        try {
            data=new JSONObject(response);
            Boolean isUserExisting=data.has("Anuj");
            if(!isUserExisting){
                JSONArray newUser=new JSONArray();
                newUser.put("9548098789");
                data.put("Anuj",newUser);
            }
            else{
                JSONArray user=(JSONArray)data.get("Anuj");
                user.put("9875674930");
            }
            fileWriter=new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw=new BufferedWriter(fileWriter);
            bw.write(data.toString());
            bw.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadJSON() {
        try {
            StringBuffer output=new StringBuffer();
            file=new File(this.getFilesDir(),FILE_NAME);
            fileReader=new FileReader(file.getAbsoluteFile());
            bufferedReader=new BufferedReader(fileReader);
            String line="";
            while((line=bufferedReader.readLine())!=null){
                output.append(line+"\n");
            }
            response=output.toString();
            bufferedReader.close();
            if(response!=null)
            showData.setText(response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}