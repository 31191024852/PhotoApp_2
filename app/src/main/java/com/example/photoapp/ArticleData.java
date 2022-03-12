package com.example.photoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Session2Command;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Printer;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.rpc.context.AttributeContext;

import java.util.ArrayList;


public class ArticleData {
    @SuppressLint("StaticFieldLeak")
    private final Context context;
    @SuppressLint("StaticFieldLeak")
    private final GridView gridview;
    public static ArticleList data = new ArticleList();

    public ArticleData(Context context, GridView gridview) {
        this.gridview=gridview;
        this.context=context;

    }
    public static Article getPhotoFromId(String id) {
        for (int i = 0; i <  data.getArticles().size(); i++)
            if (data.getArticles().get(i).getArticle_id() == id)
                return data.getArticles().get(i);
        return null;
    }

    public void execute() {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("articles").addValueEventListener(new ValueEventListener() {
            final ArrayList<Article> Atr = new ArrayList<Article>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    Article art = (Article) snapshot1.getValue(Article.class);
                    assert art != null;
                    Log.d("art",art.getArticle_image());
                    Atr.add(art);
                }
                data.setArticles(Atr);
                if(data!=null){
                    ArticleAdapter adapter = new ArticleAdapter(data.getArticles(), context);
                    gridview.setAdapter(adapter);
                    Log.d("data",data.toString());
                }else{
                    Toast.makeText(context,"Lỗi tải ảnh",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(context, "Lỗi tải ảnh" + error, Toast.LENGTH_LONG).show();
            }
        });
//        database.child("articles").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            ArrayList<Article> a = new ArrayList<Article>();
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if(task.isSuccessful()){
//                    for(DataSnapshot snapshot: task.getResult().getChildren()){
//                        Article article = snapshot.getValue(Article.class);
//                        a.add(article);
//                    }
//                    data.setArticles(a);
//                    if(data!=null){
//                        ArticleAdapter adapter = new ArticleAdapter(data.getArticles(), context);
//                        gridview.setAdapter(adapter);
//                        Log.d("data",data.toString());
//                    }else{
//                        Toast.makeText(context,"Lỗi tải ảnh",Toast.LENGTH_LONG).show();
//                    }
//                }else {
//                    Toast.makeText(context, "Lỗi tải ảnh", Toast.LENGTH_LONG).show();
//                }
//            }
//        });





    }
}
