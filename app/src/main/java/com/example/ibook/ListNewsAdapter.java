package com.example.ibook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListNewsAdapter extends ArrayAdapter<ListNews> {
    public ListNewsAdapter(@NonNull Context context, ArrayList<ListNews> dataArrayList) {
        super(context, R.layout.activity_main_news, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListNews listNews=getItem(position);
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_main_news,parent,false);
        }

        ImageView newsImage=view.findViewById(R.id.newsImage);
        TextView news_title=view.findViewById(R.id.news_title);
        TextView news_data=view.findViewById(R.id.news_data);
        TextView news_short_description=view.findViewById(R.id.news_short_description);

        newsImage.setImageResource(listNews.image_news);
        news_title.setText(listNews.title_news);
        news_data.setText(listNews.date_news);
        news_short_description.setText(listNews.short_description_news);
        return view;
    }
}
