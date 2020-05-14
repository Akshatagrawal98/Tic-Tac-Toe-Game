package com.example.tictactoegame;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Exception;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //0-x//1-0
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    boolean gameActive=true;
    boolean f=false;
    //State meanings
    //0-x
    //1-0
    //2-Null
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view){
        if(!gameActive)
        {
            gameReset(view);
            TextView status=findViewById(R.id.status);
            status.setText("X's Turn - Tap to play");
        }
        try {
            ImageView img = (ImageView) view;
            int tappedImage = Integer.parseInt(img.getTag().toString());
            if (gameState[tappedImage] == 2 && gameActive) {
                gameState[tappedImage] = activePlayer;
                img.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.x);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's Turn - Tap to play");
                } else {
                    img.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText("X's Turn - Tap to play");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            //check if any player won
            for (int[] winPosition : winPositions) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && (gameState[winPosition[0]] != 2)) {
                    String winnerStr;
                    gameActive = false;
                    if (gameState[winPosition[0]] == 0) {
                        winnerStr = "X has Won";
                    } else {
                        winnerStr = "O has Won";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                }

            }


        } catch (Exception e) {
            TextView status = findViewById(R.id.status);
            status.setText("Try again");

        }
    }
    public void gameReset(View view){
        try{

        gameActive=true;
        activePlayer=0;
            TextView status=findViewById(R.id.status);
            status.setText("X's Turn - Tap to play");
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    }
    catch (Exception e)
    {
        TextView status = findViewById(R.id.status);
        status.setText("Try again");
    }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
