package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Spring-Sama on 11-Feb-15.
 */
public class MenuList extends ActionBarActivity {
    ListView list;

    String[] itemname ={
            "Mac",
            "Boom",
            "Moo",
            "Taming",
            "Micky"
    };

    String homename;

    int[] imgid= {R.drawable.g,R.drawable.d,R.drawable.f,R.drawable.a,R.drawable.r};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulist);

        Bundle extras = getIntent().getExtras();
        this.homename = extras.getString("homeName");

        CustomListAdapter adapter = new CustomListAdapter(MenuList.this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(MenuList.this, "You Clicked at " + itemname[+position], Toast.LENGTH_SHORT).show();

                Intent it = new Intent(getApplicationContext(),Member.class);
                it.putExtra("position", position);
                it.putExtra("itemname", itemname);
                it.putExtra("imgid", imgid);
                it.putExtra("homename",homename);
                startActivity(it);

            }
        });
    }

}
