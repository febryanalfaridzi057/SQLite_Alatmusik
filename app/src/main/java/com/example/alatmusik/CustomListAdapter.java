package com.example.alatmusik;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<AlatMusik> movieItems;
    public CustomListAdapter(Activity activity, List<AlatMusik> movieItems)
    {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView buka = (TextView)
                convertView.findViewById(R.id.text_kondisi);
        TextView tutup = (TextView)
                convertView.findViewById(R.id.text_harga);

        AlatMusik t = movieItems.get(position);
        nama.setText("Nama AlatMusik : "+ t.get_nama());
        buka.setText("Kondisi : "+ t.get_kondisi());
        tutup.setText("Harga : "+ t.get_harga());
        return convertView;
    }
}