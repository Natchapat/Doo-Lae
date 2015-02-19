package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

/**
 * Created by Spring-Sama on 09-Feb-15.
 */
public class Medical extends ActionBarActivity {

    public TextView det;
    public  TextView medi;
    String[] edit_med;
    String[] itemname;
    int position;

    String result ="";
    //String[] medicall = {"a","b","c","d","e"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical);

        android.support.v7.app.ActionBar setActionBar = getSupportActionBar();
        setActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#184e8e")));
        setActionBar.setDisplayShowCustomEnabled(true);
        setActionBar.setCustomView(R.layout.action_bar);

        Bundle extras = getIntent().getExtras();
        this.itemname =  extras.getStringArray("itemname");
        this.position = extras.getInt("position");
        this.edit_med = extras.getStringArray("edit_medical");

        medi = (TextView) findViewById(R.id.mede);
        medi.setText(itemname[position] + " Medical Detail");

        det = (TextView) findViewById(R.id.detail);
        det.setText("Loading..");
        GetMedicalDetail();
        //det.setText(edit_med[position]);
        //medicall[position] = edit_med[position];
        Button edit = (Button) findViewById(R.id.editmed);
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(getApplicationContext(),Edit.class);
                it.putExtra("edit_medical", result);
                //it.putExtra("position",position);
                it.putExtra("name",itemname[position]);
                startActivity(it);
                finish();
            }
        });

    }

    public void GetMedicalDetail()
    {
        Thread thread = new Thread(){
            public void run(){
                String link = "http://202.44.12.175/doolae-response/fetch_medical_detail.php?name=" +itemname[position];
                DownloadData content = new DownloadData();
                content.execute(link);

                Log.d("link", link);

                result = "";
                try {
                    result = content.get().toString();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                Log.d("abc",result);
                SetMedical();
            }
        };
        thread.start();
    }

    public void SetMedical()
    {
        runOnUiThread(new Runnable() {
            public void run()
            {

                det.setText(result);
            }
        });
    }

}
