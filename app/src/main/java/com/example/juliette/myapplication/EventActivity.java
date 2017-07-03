package com.example.juliette.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EventActivity extends AppCompatActivity {
    ImageView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        map = (ImageView) findViewById(R.id.map);
        // set a onclick listener for when the button gets clicked
        map.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent OpenMap = new Intent(EventActivity.this,
                        MapsActivity.class);
                startActivity(OpenMap);
            }
        });
    }
}
