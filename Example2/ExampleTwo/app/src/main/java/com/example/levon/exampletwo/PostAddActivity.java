package com.example.levon.exampletwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostAddActivity extends AppCompatActivity {

    final static String KEY_FOR_GET = "hi";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_add);
        editText = (EditText) findViewById(R.id.pathofimage);
        Button button = (Button) findViewById(R.id.addpath);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imgPath = editText.getText().toString();
                Intent intent = getIntent();
                intent.putExtra(KEY_FOR_GET, imgPath);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
