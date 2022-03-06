package com.example.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Subject> {
    public ListAdapter(Context context, ArrayList<Subject> userArrayList){
        super(context,R.layout.list_item,userArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Subject subject = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView name = convertView.findViewById(R.id.name);
        TextView information = convertView.findViewById(R.id.information);
        imageView.setImageResource(subject.imageId);
        name.setText(subject.name);
        information.setText(subject.information);
        return convertView;
    }
}
