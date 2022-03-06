package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.custom_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageId = {R.drawable.a,R.drawable.b};
        String[] name = {"Sistemas gestores de bases de datos ","Desarrollo en dispositivos móviles"};
        String[] information = {"Class on Monday","Class on Thursday"};
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        for(int i = 0;i< 2;i++){
            Subject subject = new Subject(name[i],information[i],imageId[i]);
            subjectArrayList.add(subject);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,subjectArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("information",information[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}