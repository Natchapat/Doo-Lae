package com.example.spring_sama.doo_lae;

/**
 * Created by Spring-Sama on 10-Feb-15.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomListSchedule extends ArrayAdapter<String>{
    private final Activity context;
    private final String timer;
    private final String even;
    public CustomListSchedule(Activity context,String timer,String even) {
        super(context, R.layout.notificationbar);
        this.context = context;
        this.timer = timer;
        this.even = even;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.notificationbar, null, true);
        TextView time = (TextView) rowView.findViewById(R.id.time);
        TextView event = (TextView) rowView.findViewById(R.id.event);
        time.setText(timer);
        event.setText(even);
        return rowView;
    }
}