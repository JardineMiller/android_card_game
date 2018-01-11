package com.example.jardine.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView playerName;
    TextView playerScore;
    TextView playerWallet;
    String playerWalletAmount;
    String potValueAmount;

    TextView computerName;
    TextView computerScore;
    TextView resultText;
    TextView potValue;

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

    ImageView pot;

    ImageButton betButton;
    ImageButton hitButton;
    Button compareButton;
    Button playAgainButton;

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int oldPlayerWallet = getIntent().getIntExtra("player_wallet", 50);
        int oldAndroidWallet = getIntent().getIntExtra("android_wallet", 50);

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

        betButton = findViewById(R.id.bet_button);
        pot = findViewById(R.id.pot);
        potValue = findViewById(R.id.pot_value);

        resultText = findViewById(R.id.result_text);
        playAgainButton = findViewById(R.id.play_again_button);

        hitButton = findViewById(R.id.hit_button);
        compareButton =  findViewById(R.id.compare_button);

        playerName = findViewById(R.id.player_name);
        playerScore = findViewById(R.id.player_score);
        playerWallet = findViewById(R.id.player_wallet);

        computerName = findViewById(R.id.computer_name);
        computerScore = findViewById(R.id.computer_score);

        resultText.setVisibility(View.GONE);
        playAgainButton.setVisibility(View.GONE);

        String name = getIntent().getStringExtra("name");

        game = new Game(name, oldPlayerWallet, oldAndroidWallet);

        playerName.setText(game.getPlayer().getName());
        computerName.setText(game.getComputer().getName());

        game.startGame();
        game.placeBets(2);

        potValueAmount = "£" + Integer.toString(game.getPot());
        potValue.setText(potValueAmount);

        playerWalletAmount = "£" + Integer.toString(game.getPlayer().getWallet().getAmount());
        playerWallet.setText(playerWalletAmount);

        getInfo(game.getPlayer());
        displayHand(game.getPlayer());
    }

    public void getInfo(Player player) {
        if(player.getName().equals("Android")) {
            computerScore.setText(Integer.toString(game.getComputer().handValue()));
        } else {
            playerScore.setText(Integer.toString(game.getPlayer().handValue()));
        }

    }

    public void hit(View button) {
        int maxCards = 5;

        if (game.getPlayer().handCount() < maxCards) {
            game.dealCards();
            displayHand(game.getPlayer());
            for(int i = (game.getPlayer().handCount() - 1); i < game.getPlayer().handCount(); i++) {
                computerCards.get(i).setImageResource(R.drawable.back);
            }
            getInfo(game.getPlayer());
        }
        if (game.getPlayer().handCount() == maxCards) {
            compare(compareButton);
        }
    }

    public void compare(View button) {
        getInfo(game.getComputer());
        displayHand(game.getComputer());

        hitButton.setVisibility(View.GONE);
        compareButton.setVisibility(View.GONE);
        pot.setVisibility(View.GONE);
        potValue.setVisibility(View.GONE);

        resultText.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
        computerScore.setVisibility(View.VISIBLE);

        game.determineWinner();
        game.payOut();

        String resultMessage = game.printWinner();
        resultText.setText(resultMessage);
    }

    public void playAgain(View button) {
        Intent intent = new Intent(this, GameActivity.class);
        String name = playerName.getText().toString();

        intent.putExtra("name", name);
        intent.putExtra("player_wallet", game.getPlayer().getWallet().getAmount());
        intent.putExtra("dealer_wallet", game.getComputer().getWallet().getAmount());

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

    public void betButton(View button) {
        game.placeBets(5);
        potValueAmount = "£" + Integer.toString(game.getPot());
        potValue.setText(potValueAmount);
        playerWalletAmount = "£" + Integer.toString(game.getPlayer().getWallet().getAmount());
        playerWallet.setText(playerWalletAmount);
    }

}
