package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.custom_listview.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String information = intent.getStringExtra("information");
            int imageid = intent.getIntExtra("imageid",R.drawable.a);
            binding.nameSubject.setText(name);
            binding.informationSubject.setText(information);
            binding.imageSubject.setImageResource(imageid);
        }

    }
}