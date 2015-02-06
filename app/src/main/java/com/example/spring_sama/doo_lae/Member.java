package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Spring-Sama on 2/6/2015.
 */
public class Member extends ActionBarActivity {

    String[] itemname;
    int[] imgid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

//        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        this.itemname =  extras.getStringArray("itemname");
        this.imgid =  extras.getIntArray("imgid");

        TextView txtTitle = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        //txtTitle.setText(itemname[]);
        //txtTitle.setText( itemname[position]);
        // imageView.setImageResource(imgid[position]);

        //CustomMember adapter = new CustomMember(Member.this, itemname, imgid);

    }
}
