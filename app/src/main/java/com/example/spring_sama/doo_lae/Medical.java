package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Spring-Sama on 09-Feb-15.
 */
public class Medical extends ActionBarActivity {

    String[] itemname;
    int position;
    String[] medicall = {"a","b","c","d","e"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical);

        Bundle extras = getIntent().getExtras();
        this.itemname =  extras.getStringArray("itemname");
        this.position = extras.getInt("position");


        TextView medi = (TextView) findViewById(R.id.mede);
        medi.setText(itemname[position] + " Medical Detail");
        TextView det = (TextView) findViewById(R.id.detail);
        det.setText(medicall[position]);
        Button edit = (Button) findViewById(R.id.editmed);
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(getApplicationContext(),Edit.class);
                startActivity(it);
            }
        });

    }
}
