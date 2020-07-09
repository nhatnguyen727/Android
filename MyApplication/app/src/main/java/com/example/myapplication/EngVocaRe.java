package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EngVocaRe  extends AppCompatActivity {
    Button next;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        init();
    }
    void init(){
        // Event when click on next button
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new intent
                Intent intent = new Intent(EngVocaRe.this, EngVoca.class);
                startActivity(intent);
            }
        });
    }
}
