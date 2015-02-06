package com.example.spring_sama.doo_lae;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Spring-Sama on 2/6/2015.
 */
public class CustomMember extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final int[] imgid;
    public CustomMember(Activity context,String[] itemname, int[] imgid) {
        super(context, R.layout.member, itemname);
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View View= inflater.inflate(R.layout.member, null, true);
        TextView txtTitle = (TextView) View.findViewById(R.id.textView);
        ImageView imageView = (ImageView) View.findViewById(R.id.imageView);
        txtTitle.setText( itemname[position]);
        imageView.setImageResource(imgid[position]);
        return View;
    }



}
