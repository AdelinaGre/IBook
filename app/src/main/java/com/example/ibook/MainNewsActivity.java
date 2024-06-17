package com.example.ibook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ibook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainNewsActivity extends AppCompatActivity {
ActivityMainBinding binding;
ListAdapter listAdapter;
ArrayList<ListNews> dataArrayList = new ArrayList<>();
ListNews listNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList={R.drawable.cover_1,R.drawable.cover_2,R.drawable.cover_3,R.drawable.cover_4 };
        String[] title_news = getResources().getStringArray(R.array.title_news);

        String[] short_description_news=getResources().getStringArray(R.array.short_description_news);

        String[] date_news=getResources().getStringArray(R.array.date_news);

        String[] author_name_news=getResources().getStringArray(R.array.author_name_news);

        String[] full_description_news=getResources().getStringArray(R.array.full_description_news);

        for (int i=0; i< imageList.length; i++){
            listNews=new ListNews(title_news[i],short_description_news[i],date_news[i], author_name_news[i],full_description_news[i],imageList[i]);
            dataArrayList.add(listNews);
        }
        listAdapter =new ListNewsAdapter(MainNewsActivity.this,dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable( true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainNewsActivity.this,DetailedNewsActivity.class);
                intent.putExtra("title",title_news[i]);
                intent.putExtra("short_description_news",short_description_news[i]);
                intent.putExtra("date_news",date_news[i]);
                intent.putExtra("author_name_news",author_name_news[i]);
                intent.putExtra("full_description_news",full_description_news[i]);
                intent.putExtra("image",imageList[i]);
                startActivity(intent);

            }
        });
    }
}