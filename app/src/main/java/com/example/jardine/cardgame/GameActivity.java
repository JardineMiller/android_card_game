package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    public String numberOfPlayers;
    public String numberOfCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView numPlayers = findViewById(R.id.num_of_players);
        TextView numCards = findViewById(R.id.num_of_cards);
        numberOfPlayers = numPlayers.getText().toString();
        numberOfCards = numCards.getText().toString();
    }

    public void onPlayButtonClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("numOfPlayers", numberOfPlayers);
        intent.putExtra("numOfCards", numberOfCards);
        startActivity(intent);
    }
}
