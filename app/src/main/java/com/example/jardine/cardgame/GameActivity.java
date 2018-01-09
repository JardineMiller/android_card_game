package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView playerName;
    TextView playerScore;
    TextView playerCards;
    TextView computerName;
    TextView computerScore;
    TextView computerCards;
    TextView resultText;

    Button hitButton;
    Button compareButton;
    Button playAgainButton;

    Game game;

    public void getInfo() {
        playerCards.setText(game.getPlayer().getAllCards());
        playerScore.setText(Integer.toString(game.getPlayer().handValue()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        resultText = findViewById(R.id.result_text);
        resultText.setVisibility(View.GONE);
        playAgainButton = findViewById(R.id.play_again_button);
        playAgainButton.setVisibility(View.GONE);

        String name = getIntent().getStringExtra("name");
        game = new Game(name);

        hitButton = findViewById(R.id.hit_button);
        compareButton =  findViewById(R.id.compare_button);

        playerName = findViewById(R.id.player_name);
        playerScore = findViewById(R.id.player_score);
        playerCards = findViewById(R.id.player_cards);

        computerName = findViewById(R.id.computer_name);
        computerScore = findViewById(R.id.computer_score);
        computerCards = findViewById(R.id.computer_cards);

        playerName.setText(game.getPlayer().getName());
        computerName.setText(game.getComputer().getName());

        game.startGame();
        getInfo();

    }

    public void hit(View button) {
        if (game.getPlayer().handCount() < 5) {
            game.dealCards();
            getInfo();
        }
        if (game.getPlayer().handCount() == 5) {
            compare(compareButton);
        }
    }

    public void compare(View button) {
        computerCards.setText(game.getComputer().getAllCards());
        computerScore.setText(Integer.toString(game.getComputer().handValue()));
        
        hitButton.setVisibility(View.GONE);
        compareButton.setVisibility(View.GONE);
        String resultMessage = game.determineWinner();
        resultText.setText(resultMessage);
        resultText.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
    }

    public void playAgain(View button) {
        Intent intent = new Intent(this, GameActivity.class);
        String name = playerName.getText().toString();
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
