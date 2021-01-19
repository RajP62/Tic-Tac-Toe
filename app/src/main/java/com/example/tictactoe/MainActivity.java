package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;

    int ActivePlayer = 0;

    int[] GameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] WinPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public void PlayerTap(View view) {
        ImageView Img = (ImageView) view;
        int TappedImage = Integer.parseInt(Img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (GameState[TappedImage] == 2) {
            GameState[TappedImage] = ActivePlayer;
            Img.setTranslationY(-1000f);
            if (ActivePlayer == 0) {
                Img.setImageResource(R.drawable.ic_croxx);
                ActivePlayer = 1;
                TextView status = findViewById(R.id.Game_Status);
                status.setText("Player 2 : Tap to play");
            } else {
                Img.setImageResource(R.drawable.ic_right);
                ActivePlayer = 0;
                TextView status = findViewById(R.id.Game_Status);
                status.setText("Player 1 : Tap to play");
            }
            Img.animate().translationYBy(1000f).setDuration(300);

        }
        for (int[] winPosition : WinPositions) {
            if (GameState[winPosition[0]] == GameState[winPosition[1]] &&
                    GameState[winPosition[1]] == GameState[winPosition[2]] &&
                    GameState[winPosition[0]] != 2) {
                String Winner;
                gameActive = false;
                if (GameState[winPosition[0]] == 0) {
                    Winner = "Player 1 has won";
                } else {
                    Winner = "Player 2 has won";
                }
                TextView status = findViewById(R.id.Game_Status);
                status.setText(Winner);

                ((ImageView) findViewById(R.id.box_first)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_second)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_third)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_fourth)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_fifth)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_six)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_seventh)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_eight)).setImageResource(0);
                ((ImageView) findViewById(R.id.box_nine)).setImageResource(0);

            }

        }


    }

    private void gameReset(View view) {
        gameActive = true;
        ActivePlayer = 0;
        for (int i = 0; i < GameState.length; i++) {
            GameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.box_first)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_second)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_third)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_fourth)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_fifth)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_six)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_seventh)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_eight)).setImageResource(0);
        ((ImageView) findViewById(R.id.box_nine)).setImageResource(0);


        TextView status = findViewById(R.id.Game_Status);
        status.setText("Player 1 : Tap to play");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}