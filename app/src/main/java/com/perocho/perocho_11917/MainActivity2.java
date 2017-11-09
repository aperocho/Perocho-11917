package com.perocho.perocho_11917;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {

    TextView tv_Data;
    FileInputStream fis;
    BufferedReader br;
    Button btn_Shared, btn_IS, btn_IC, btn_EC, btn_ES, btn_EPS, btn_Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.MainActivity2);

        tv_Data = (TextView) findViewById(R.id.tvData);
        btn_Shared = (Button) findViewById(R.id.btnSP);
        btn_IS = (Button) findViewById(R.id.btnIS);
        btn_IC = (Button) findViewById(R.id.btnIC);
        btn_EC = (Button) findViewById(R.id.btnEC);
        btn_ES = (Button) findViewById(R.id.btnES);
        btn_EPS = (Button) findViewById(R.id.btnEPS);
        btn_Next = (Button) findViewById(R.id.btnprevious);

    }

    public void previous (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loadSP(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        String data = preferences.getString("data","");
        tv_Data.setText(data);
    }

    public void loadIS (View view) throws IOException {
        String newline = "";
        String data = "";
        try{
            fis = openFileInput("storage.txt");
            br = new BufferedReader(new InputStreamReader(fis));
            if ((newline = br.readLine()) != null)
                data = newline;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tv_Data.setText(data);
    }

    public void loadInternalCache(View view) throws FileNotFoundException {
        String newline = "";
        String data = "";
        File folder = getCacheDir();
        File file = new File(folder, "storage.txt");
        fis = new FileInputStream(file);
        try{
            br = new BufferedReader(new InputStreamReader(fis));
            if ((newline = br.readLine()) != null)
                data = newline;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tv_Data.setText(data);
    }

    public void loadEC(View view) throws FileNotFoundException {
        String newline = "";
        String data = "";
        File folder = getExternalCacheDir();
        File file = new File(folder, "storage.txt");
        fis = new FileInputStream(file);
        try{
            br = new BufferedReader(new InputStreamReader(fis));
            if ((newline = br.readLine()) != null)
                data = newline;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tv_Data.setText(data);
    }

    public void loadES (View view) throws FileNotFoundException {
        String newline = "";
        String data = "";
        File folder = getExternalFilesDir("<PANGALAN MO DITO>");
        File file = new File(folder, "storage.txt");
        fis = new FileInputStream(file);
        try{
            br = new BufferedReader(new InputStreamReader(fis));
            if ((newline = br.readLine()) != null)
                data = newline;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tv_Data.setText(data);
    }

    public void loadEP (View view) throws FileNotFoundException {
        String newline = "";
        String data = "";
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File (folder, "storage.txt");
        fis = new FileInputStream(file);
        try{
            br = new BufferedReader(new InputStreamReader(fis));
            if ((newline = br.readLine()) != null)
                data = newline;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tv_Data.setText(data);

    }
}