package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

/**
 * Created by Spring-Sama on 11-Feb-15.
 */
public class Edit extends ActionBarActivity {

    //String[] medical;
    String[] edit_medical;
    int position;

    String temp="";

    public EditText edittext;
    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);



        Bundle extras = getIntent().getExtras();
        this.position = extras.getInt("position");
        //this.medical = extras.getStringArray("medicall");
        this.edit_medical=extras.getStringArray("edit_medical");

        edittext = (EditText) findViewById(R.id.edittext);
        edittext.setText(edit_medical[position]);

        Button save = (Button) findViewById(R.id.save);
        Button cancell = (Button) findViewById(R.id.cancell);

        txt = (TextView) findViewById(R.id.detail);
//        final String URLsend = "http://202.44.12.175/doolae-response/edit_medical.php";

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Edit.this, "Save Success", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(),Medical.class);
                edit_medical[position] = edittext.getText().toString();
                temp = edit_medical[position];
                Log.d("CheckString", String.valueOf(position));
                Log.d("CheckString", temp);
                it.putExtra("edit_medical",edit_medical);
                it.putExtra("position",position);

                String intPos = String.valueOf(position);
                String data = String.valueOf(edit_medical);

                new SendHTTP().execute(String.valueOf(position+1),temp);
                startActivity(it);
            }

        });


    }
}
