package com.example.spring_sama.doo_lae;

/**
 * Created by Spring-Sama on 2/5/2015.
 */
        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
public class CustomListAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] itemname;
    private final int[] imgid;
    public CustomListAdapter(Activity context,String[] itemname, int[] imgid) {
        super(context, R.layout.mylist, itemname);
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.mylist, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        txtTitle.setText( itemname[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;
    }
}