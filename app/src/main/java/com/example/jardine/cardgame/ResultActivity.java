package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String numPlayers = getIntent().getExtras().getString("numOfPlayers");
        String numCards = getIntent().getExtras().getString("numOfCards");

        TextView playerText = findViewById(R.id.player_count);
        TextView cardText = findViewById(R.id.card_count);

        playerText.setText(numPlayers);
        cardText.setText(numCards);
    }
}
