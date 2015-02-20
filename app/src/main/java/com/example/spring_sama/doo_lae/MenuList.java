package com.example.spring_sama.doo_lae;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Spring-Sama on 11-Feb-15.
 */
public class MenuList extends ActionBarActivity {

    private ArrayList<String> output = new ArrayList<String>();
    private ArrayList<String> index = new ArrayList<String>();
    private ArrayList<String> type = new ArrayList<String>();

    ListView list;

    //String[] itemname ={"Mac","Boom","Moo","Taming","Micky"};

    String homename;

    int[] imgid= {R.drawable.boy,R.drawable.girl,R.drawable.boy,R.drawable.boy,R.drawable.boy,R.drawable.boy};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulist);

        android.support.v7.app.ActionBar setActionBar = getSupportActionBar();
        setActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#184e8e")));
        setActionBar.setDisplayShowCustomEnabled(true);
        setActionBar.setCustomView(R.layout.action_bar);

        String link = "http://202.44.12.175/doolae-response/fetch_data.php";
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

        JsonToArray(result);
        String[] itemname = new String[output.size()];
        itemname = output.toArray(itemname);

        Bundle extras = getIntent().getExtras();
        this.homename = extras.getString("homeName");

        CustomListAdapter adapter = new CustomListAdapter(MenuList.this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        final String[] finalItemname = itemname;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(MenuList.this, "You Clicked at " + finalItemname[+position], Toast.LENGTH_SHORT).show();

                Intent it = new Intent(getApplicationContext(),Member.class);
                it.putExtra("position", position);
                it.putExtra("itemname", finalItemname);
                it.putExtra("imgid", imgid);
                it.putExtra("homename",homename);
                startActivity(it);
            }
        });
    }
    public void JsonToArray(String input)
    {
        if(input.substring(0,1).equals("{")&&input.substring(input.length()-1,input.length()).equals("}"))
        {
            //System.out.println(input.substring(1,input.length()-1));
            String[] parts =input.substring(1,input.length()-1).split(",");
            for(int i=0;i<parts.length;i++)
            {
                String[] part2 = parts[i].split(":");
                for(int j=0;j<2;j++)
                {
                    //System.out.println(part2[j]);
                    String[] part3 = part2[j].split("\"");
                    //System.out.println(part3.length);
                    if(part3[0].equals(""))
                    {
                        if(j==0)
                        {
                            index.add(part3[1]);
                        }else{
                            output.add(part3[1]);
                            type.add("String");
                        }
                        //System.out.println(part3[1]);
                    }else{
                        if(j==0)
                        {
                            index.add(part3[0]);
                        }else{
                            output.add(part3[0]);
                            type.add("Number");
                        }
                        //System.out.println(part3[0]);
                    }
                }

            }
        }else{
            System.out.println("test2");
        }
    }

}
