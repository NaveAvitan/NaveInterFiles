package com.example.naveinterfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * main activity' here you can do what the app designed for
 */
public class MainActivity extends AppCompatActivity {
    EditText edt;
    TextView tvx;
    String str,str1;
    /**
     * set the options menu
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    /**
     * here you move to credit activity
     *
     * @param menu
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if ((st.equals("credits"))) {
            Intent si = new Intent(this, credits.class);
            startActivity(si);
        }


        return true;
    }
    @Override
    /**
     * here you check the inter files
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.editText);
        tvx = findViewById(R.id.textView);

        try {
            FileInputStream fis= openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            str1 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * save button
     * @param view
     * @throws IOException
     */
    public void save(View view) throws IOException {
        str= edt.getText().toString();

        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            str1= str1+str;
            bw.write(str1);
            bw.close();
            tvx.setText(str1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * reset all the parameters
     * @param view
     */
    public void res(View view) {
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            str1="";
            bw.write(str1);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        edt.setText("");
        tvx.setText("");

    }

    /**
     * exit button
     * @param view
     */
    public void ex(View view) {
        str= edt.getText().toString();

        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            str1= str1+str;
            bw.write(str1);
            bw.close();
            tvx.setText(str1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();

    }
    }

