package com.ewillian.morpion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button [][] buttonArray = new Button[3][3];
    private boolean playerOneTurn = true;
    private int roundCount;
    private int scoreOne;
    private int scoreTwo;

    private TextView textViewOne;
    private TextView textViewTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Views
        textViewOne = findViewById(R.id.tv_player1);
        textViewTwo = findViewById(R.id.tv_player2);

        //Get buttons
        for (int i = 0; i <3 ; i++){
            for (int j = 0; j < 3 ; j++){

            }
        }
    }
}
