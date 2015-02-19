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
import android.widget.Toast;

import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by Spring-Sama on 11-Feb-15.
 */
public class Edit extends ActionBarActivity {



    //String[] medical;
    String edit_medical;
    //int position;
    String name;

    public EditText edittext;
    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        android.support.v7.app.ActionBar setActionBar = getSupportActionBar();
        setActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#184e8e")));
        setActionBar.setDisplayShowCustomEnabled(true);
        setActionBar.setCustomView(R.layout.action_bar);

        Bundle extras = getIntent().getExtras();
        //this.position = extras.getInt("position");
        this.edit_medical=extras.getString("edit_medical");
        this.name=extras.getString("name");

        edittext = (EditText) findViewById(R.id.edittext);
        edittext.setText(edit_medical);

        Button save = (Button) findViewById(R.id.save);
        Button cancell = (Button) findViewById(R.id.cancell);

        txt = (TextView) findViewById(R.id.detail);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Edit.this, "Save Success", Toast.LENGTH_SHORT).show();

                final String temp = edittext.getText().toString();
                String link = "http://202.44.12.175/doolae-response/edit_medical.php?name=" +name+"&home=Home-A&data="+temp;
                DownloadData content = new DownloadData();
                content.execute(link);

                Log.d("link", link);
                finish();

            }

        });

        cancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }

        });


    }

}
