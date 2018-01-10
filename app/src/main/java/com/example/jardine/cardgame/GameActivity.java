package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView playerName;
    TextView playerScore;
    TextView computerName;
    TextView computerScore;
    TextView resultText;

    ImageView playerCard1;
    ImageView playerCard2;
    ImageView playerCard3;
    ImageView playerCard4;
    ImageView playerCard5;
    ArrayList<ImageView> playerCards;

    ImageView computerCard1;
    ImageView computerCard2;
    ImageView computerCard3;
    ImageView computerCard4;
    ImageView computerCard5;
    ArrayList<ImageView> computerCards;

    Button hitButton;
    Button compareButton;
    Button playAgainButton;

    Game game;

    public void getInfo() {
        playerScore.setText(Integer.toString(game.getPlayer().handValue()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        playerCards = new ArrayList<>();
        computerCards = new ArrayList<>();

        playerCard1 = findViewById(R.id.player_card_1);
        playerCard2 = findViewById(R.id.player_card_2);
        playerCard3 = findViewById(R.id.player_card_3);
        playerCard4 = findViewById(R.id.player_card_4);
        playerCard5 = findViewById(R.id.player_card_5);
        playerCards.add(playerCard1);
        playerCards.add(playerCard2);
        playerCards.add(playerCard3);
        playerCards.add(playerCard4);
        playerCards.add(playerCard5);

        computerCard1 = findViewById(R.id.computer_card_1);
        computerCard2 = findViewById(R.id.computer_card_2);
        computerCard3 = findViewById(R.id.computer_card_3);
        computerCard4 = findViewById(R.id.computer_card_4);
        computerCard5 = findViewById(R.id.computer_card_5);
        computerCards.add(computerCard1);
        computerCards.add(computerCard2);
        computerCards.add(computerCard3);
        computerCards.add(computerCard4);
        computerCards.add(computerCard5);

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

        computerName = findViewById(R.id.computer_name);
        computerScore = findViewById(R.id.computer_score);

        playerName.setText(game.getPlayer().getName());
        computerName.setText(game.getComputer().getName());

        game.startGame();
        getInfo();

        displayHand(game.getPlayer());


    }

    public void hit(View button) {
        if (game.getPlayer().handCount() < 5) {
            game.dealCards();
            displayHand(game.getPlayer());
            getInfo();
        }
        if (game.getPlayer().handCount() == 5) {
            compare(compareButton);
        }
    }

    public void compare(View button) {
        computerScore.setText(Integer.toString(game.getComputer().handValue()));
        displayHand(game.getComputer());

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

    public void displayHand(Player player) {
        ArrayList<Card> hand = player.getHand();
        for(int i = 0; i < hand.size(); i++) {
            String imagePath = hand.get(i).getImage();
            int resource = getResources().getIdentifier(imagePath, "drawable", this.getPackageName());
            if(player.getName().equals("Android")) {
                computerCards.get(i).setImageResource(resource);
            } else {
                playerCards.get(i).setImageResource(resource);
            }
        }

    }

}
