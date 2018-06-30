package com.example.levon.zakuskiproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Items> arrayList = new ArrayList<>();
        arrayList.add(new Items("Tolma", "Armenia", "https://gotovim-doma.ru/images/recipe/3/32/332df778cdc8f5b1e4440fe1f3eda652.jpg", "https://en.wikipedia.org/wiki/Dolma"));
        arrayList.add(new Items("Sushi", "Japan", "https://halfoff.adspayusa.com/wp-content/uploads/2018/03/sushi_and_sashimi_for_two.0.jpg", "https://en.wikipedia.org/wiki/Sushi"));
        arrayList.add(new Items("Pasta", "Italy", "https://www.seriouseats.com/recipes/images/2016/08/20160827-cherry-tomato-pasta-13-1500x1125.jpg", "https://en.wikipedia.org/wiki/Pasta"));
        arrayList.add(new Items("Pizza", "Italy", "https://i.ytimg.com/vi/1X6OAucemtE/maxresdefault.jpg", "https://en.wikipedia.org/wiki/Pizza"));
        ItemsAdapter itemsAdapter = new ItemsAdapter(this,R.layout.list_item_maket,arrayList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(arrayList.get(position).getWikiUrl()));
                startActivity(intent);
            }
        });
    }
}
