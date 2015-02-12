package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {

    public EditText user;
    public EditText home;

    String userName;
    String homeName;

    Button ChkLoginBtn;

    boolean NoConfig = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.username);
        home = (EditText) findViewById(R.id.homename);

        ChkLoginBtn = (Button) findViewById(R.id.button_login);
        ChkLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (NoConfig) {
                    userName = user.getText().toString();
                    homeName = home.getText().toString();
                }
                String link = "http://202.44.12.175/doolae-response/care_check_login.php?username=" + userName + "&homename=" + homeName;
                DownloadData content = new DownloadData();
                content.execute(link);

                Log.d("link", link);

                String result = "";
                try {
                    result = content.get().toString();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                //check
                if (result.equals("true")) {
                    //do in this
                    writer(userName + "," + homeName, false, "doolae_config");
                    Intent it = new Intent(getApplicationContext(), MenuList.class);
                    it.putExtra("userName", userName);
                    it.putExtra("homeName", homeName);
                    startActivity(it);
                    Toast.makeText(getApplicationContext(), "ยินดีต้อนรับ " + userName, Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid input, Please Check and try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, "doolae_config");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String sCurrentLine;
            int line = 1;
            while ((sCurrentLine = br.readLine()) != null) {
                if (line == 1) {
                    String[] temp = sCurrentLine.split(",");
                    userName = temp[0];
                    homeName = temp[1];
                }
            }
            NoConfig = false;
            ChkLoginBtn.performClick();
        } catch (IOException e) {
            NoConfig = true;
        }

    }

    public void writer(String msg, Boolean newfile, String filename) {
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, filename); // log file


        FileWriter writer;
        //String msg = "hello222";

        try {        // write log
            path.mkdirs();
            writer = new FileWriter(file, newfile);     // true = continue , false = new file
            PrintWriter printer = new PrintWriter(writer);
            printer.append(msg);
            //printer.println();
            printer.close();
        } catch (IOException e) {
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

