package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int ActivePlayer = 0;

    int[] GameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] WinPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public void PlayerTap(View view) {
        ImageView Img = (ImageView) view;
        int TappedImage = Integer.parseInt(Img.getTag().toString());

        if (GameState[TappedImage] == 2) {
            GameState[TappedImage] = ActivePlayer;
            Img.setTranslationY(-1000f);
            if (ActivePlayer == 0){
                Img.setImageResource(R.drawable.wrong2);
                ActivePlayer = 1;
            }else {
                Img.setImageResource(R.drawable.o);
            }
        }
        Img.animate().translationYBy(1000f).setDuration(300);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}