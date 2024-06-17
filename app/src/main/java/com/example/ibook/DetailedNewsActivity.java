// DetailedNewsActivity.java
package com.example.ibook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ibook.databinding.ActivityDetailedNewsBinding;

public class DetailedNewsActivity extends AppCompatActivity {
    ActivityDetailedNewsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedNewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String short_description_news = intent.getStringExtra("short_description_news");
            String date_news = intent.getStringExtra("date_news");
            String author_name_news = intent.getStringExtra("author_name_news");
            String full_description_news = intent.getStringExtra("full_description_news");
            int image = intent.getIntExtra("image", R.drawable.cover_1);

            binding.detailNewsTitle.setText(title);
            binding.detailImage.setImageResource(image);
            binding.detailFullDescription.setText(full_description_news);
            binding.detailData.setText(date_news);
            binding.detailAuthor.setText(author_name_news);
        }

        // Set the OnClickListener for the back button
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    public void goBack() {
        Intent intent = new Intent(DetailedNewsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
