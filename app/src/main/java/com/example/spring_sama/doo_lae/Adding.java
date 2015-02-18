package com.example.spring_sama.doo_lae;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Spring-Sama on 10-Feb-15.
 */
public class Adding extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding);

        android.support.v7.app.ActionBar setActionBar = getSupportActionBar();
        setActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#184e8e")));
        setActionBar.setDisplayShowCustomEnabled(true);
        setActionBar.setCustomView(R.layout.action_bar);

    }
}
