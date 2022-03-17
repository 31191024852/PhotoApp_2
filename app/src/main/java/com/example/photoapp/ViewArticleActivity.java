package com.example.photoapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ViewArticleActivity extends AppCompatActivity {
    ImageView iv_detail;
    TextView tv_detail_title, tv_detail_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_article);

        iv_detail = findViewById(R.id.iv_detail);
        tv_detail_title = findViewById(R.id.tv_detail_title);
        tv_detail_description = findViewById(R.id.tv_detail_description);

        String id = String.valueOf(getIntent().getLongExtra("id", 0));
        Article art = (Article) getIntent().getSerializableExtra("art");

        Picasso.get().load(art.getArticle_image()).resize(400, 500).centerCrop().into(iv_detail);
        tv_detail_title.setText(art.getArticle_title());
        tv_detail_description.setText(art.getArticle_description());
    }
}
