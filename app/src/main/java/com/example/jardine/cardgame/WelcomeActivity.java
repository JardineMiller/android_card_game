package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        nameEditText = findViewById(R.id.name_string);
    }

    public void onGoButtonClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        String name = nameEditText.getText().toString();
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
