package com.ewillian.morpion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
                //Get id with format button_ij
                String buttonId = "button_"+ i + j;
                //Get location
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                //Get buttons
                buttonArray[i][j] =  findViewById(resId);
                buttonArray[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.btn_reset);
        //OnClickListener reset button
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //OnClickListener plays buttons
    @Override
    public void onClick(View v) {
        //if already used
        if (!((Button) v).getText().toString().equals("")){
            return;
        }

        if (playerOneTurn){
            ((Button) v).setText("X");
        }
        else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if(isWin()) {
            if(playerOneTurn){
                playerOneWins();
            }else {
                playerTwoWins();
            }
        }
        else if(roundCount == 9){
            draw();
        } else {
            playerOneTurn = !playerOneTurn;
        }
    }

    private boolean isWin (){
        String[][] field = new String[3][3];
        for (int i = 0; i <3 ; i++){
            for (int j = 0; j < 3 ; j++){
                field[i][j] = buttonArray[i][j].getText().toString();
            }
        }

        //Horizontal
        for (int i = 0; i < 3; i++){
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")){
                return true;
            }
        }

        //Vertical
        for (int i = 0; i < 3; i++){
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")){
                return true;
            }
        }

        //diagonal from high left corner
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")){
            return true;
        }

        //diagonal from high right corner
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
            return true;
        }

        return false;
    }

    private void playerOneWins(){
        scoreOne++;
        Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void playerTwoWins(){
        updatePointsText();
        resetBoard();
    }
    
    private void draw(){
        Toast.makeText(this, "Draw !", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i <3 ; i++){
            for (int j = 0; j < 3 ; j++){
                buttonArray[i][j].setText("");
            }
        }
        roundCount = 0;
        playerOneTurn = true;
    }

    private void updatePointsText() {
        textViewOne.setText("Player 1: "+scoreOne);
        textViewOne.setText("Player 1: "+scoreTwo);
    }

}
