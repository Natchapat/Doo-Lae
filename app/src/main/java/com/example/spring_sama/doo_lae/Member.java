package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Spring-Sama on 2/6/2015.
 */
public class Member extends ActionBarActivity {

    int position;
    String[] itemname;
    int[] imgid;
    String[] medical;
    String homename;
    String[] edit_medical = {"a","b","c","d","e"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

//        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        this.position = extras.getInt("position");
        this.itemname =  extras.getStringArray("itemname");
        this.imgid =  extras.getIntArray("imgid");
        this.homename=extras.getString("homename");


        TextView name = (TextView) findViewById(R.id.name);
        ImageView icon = (ImageView) findViewById(R.id.icon);
        TextView home_name = (TextView) findViewById(R.id.home);


        name.setText( itemname[position]);
        icon.setImageResource(imgid[position]);
        home_name.setText(homename);

        Button medicaldetail = (Button) findViewById(R.id.medical);
        medicaldetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Member.this,itemname[+position]+" Medical Detail", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(),Medical.class);
                it.putExtra("position", position);
                it.putExtra("itemname", itemname);
                it.putExtra("edit_medical",edit_medical);
                startActivity(it);
            }
        });

        Button schedulist = (Button) findViewById(R.id.schedule);
        schedulist.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Toast.makeText(Member.this,itemname[+position]+" Schedule", Toast.LENGTH_SHORT).show();
               Intent it = new Intent(getApplicationContext(),Schedule.class);
               startActivity(it);
            }
        });

        Button locational = (Button) findViewById(R.id.location);
        locational.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(Member.this,"Location "+itemname[+position], Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(),Location.class);
                startActivity(it);
            }
        });

        ImageView calling = (ImageView) findViewById(R.id.call);
        calling.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(Member.this,"Calling to "+itemname[+position], Toast.LENGTH_SHORT).show();
            }
        });




    }

    //this method used to get index of string output will be index of string in array and will return -1 if not found.
    /*private int GetStringArrayIndex(String[] set, String input){
        for(int i=0;i<set.length;i++){
            if(set.equals(input)){
                return i;
            }
        }
        return -1;
    }*/
}
