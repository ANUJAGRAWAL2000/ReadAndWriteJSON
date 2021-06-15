package com.example.readandwritejson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserActivity extends AppCompatActivity {

    TextInputEditText Name,Location,Branch,College;
    File file;
    private static final String FILE_NAME="sample3.json";
    private JSONObject data;
    FileReader fileReader=null;
    FileWriter fileWriter=null;
    BufferedReader bufferedReader=null;
    BufferedWriter bufferedWriter=null;
    String response=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Name=findViewById(R.id.Name);
        Branch=findViewById(R.id.Branch);
        Location=findViewById(R.id.Location);
        College=findViewById(R.id.College);

        response=getIntent().getStringExtra("Response");

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

        findViewById(R.id.Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=Name.getText().toString();
                String location=Location.getText().toString();
                String college=College.getText().toString();
                String branch=Branch.getText().toString();

                try {
                    if(response==null)
                        ReadJSON();

                    data=new JSONObject(response);

                    Boolean isUserExisting=data.has("Users");
                    if(!isUserExisting){
                        JSONArray newUser=new JSONArray();

                        JSONObject newJsonObject=new JSONObject();
                        newJsonObject.put("Name",name);
                        newJsonObject.put("Location",location);
                        newJsonObject.put("Branch",branch);
                        newJsonObject.put("College",college);

                        newUser.put(newJsonObject);

                        data.put("Users",newUser);
                    }
                    else{
                        JSONArray user=(JSONArray)data.get("Users");

                        JSONObject newJsonObject=new JSONObject();
                        newJsonObject.put("Name",name);
                        newJsonObject.put("Location",location);
                        newJsonObject.put("Branch",branch);
                        newJsonObject.put("College",college);

                        user.put(newJsonObject);
                    }
                    fileWriter=new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw=new BufferedWriter(fileWriter);
                    Toast.makeText(UserActivity.this,"Data saved Successfully",Toast.LENGTH_LONG).show();
                    bw.write(data.toString());
                    bw.close();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}