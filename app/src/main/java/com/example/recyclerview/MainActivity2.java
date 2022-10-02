package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String Title = intent.getStringExtra("Title");
        String description = intent.getStringExtra("Description");
       int image = intent.getIntExtra("Image", 0);


        TextView title = findViewById(R.id.txtTitle2);
        TextView Description = findViewById(R.id.txtdescription2);
        ImageView imageView2 = findViewById(R.id.imageView2);

        title.setText(Title);
        Description.setText(description);
        imageView2.setImageResource(image);

    }

}