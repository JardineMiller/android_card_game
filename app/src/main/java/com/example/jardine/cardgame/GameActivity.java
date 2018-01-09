package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    String numberOfPlayers;
    String numberOfCards;
    public EditText numPlayers;
    public EditText numCards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        numPlayers = findViewById(R.id.num_of_players);
        numCards = findViewById(R.id.num_of_cards);

    }

    public void onPlayButtonClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        numberOfPlayers = numPlayers.getText().toString();
        numberOfCards = numCards.getText().toString();
        intent.putExtra("numOfPlayers", numberOfPlayers);
        intent.putExtra("numOfCards", numberOfCards);
        startActivity(intent);
    }
}
