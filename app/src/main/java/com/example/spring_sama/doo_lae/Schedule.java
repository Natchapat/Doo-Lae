package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Spring-Sama on 09-Feb-15.
 */
public class Schedule extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        android.support.v7.app.ActionBar setActionBar = getSupportActionBar();
        setActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#184e8e")));
        setActionBar.setDisplayShowCustomEnabled(true);
        setActionBar.setCustomView(R.layout.action_bar);

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Adding.class);
                startActivity(it);
            }
        });
    }
}
