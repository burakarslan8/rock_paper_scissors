package com.burakarslan8.taskagitmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button rock,paper,scissors;
    TextView computerScore, playerScore, textWinner, computersChoice;
    int comScr=0,plyrScr=0,comChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock=findViewById(R.id.btnRock);
        paper=findViewById(R.id.btnPaper);
        scissors=findViewById(R.id.btnScissors);
        computerScore=findViewById(R.id.computerScore);
        playerScore=findViewById(R.id.playerScore);
        textWinner=findViewById(R.id.textWinner);
        computersChoice=findViewById(R.id.computersChoice);
    }

    public void mainBtnClick(View view) {
        switch (view.getId()){
            case R.id.btnRock:
                setComChoice(1);
                break;
            case R.id.btnPaper:
                setComChoice(2);
                break;
            case R.id.btnScissors:
                setComChoice(3);
                break;
        }
    }

    public void setComChoice(int playerChoice){
        comChoice=(int) (Math.random()*3+1);

        switch (comChoice){
            case 1:
                computersChoice.setText("Computer's choice: ROCK");
                break;
            case 2:
                computersChoice.setText("Computer's choice: PAPER");
                break;
            case 3:
                computersChoice.setText("Computer's choice: SCISSORS");
                break;
        }
        if ((comChoice==1 && playerChoice==1) || (comChoice==2 && playerChoice==2) || (comChoice==3 && playerChoice==3)){
            textWinner.setText("IT'S DRAW!");
        }
        if ((comChoice==1 && playerChoice==3) || (comChoice==2 && playerChoice==1) || (comChoice==3 && playerChoice==2)){
             textWinner.setText("COMPUTER WINS!");
             comScr++;
             computerScore.setText(String.valueOf(comScr));
        }
        if ((comChoice==3 && playerChoice==1) || (comChoice==1 && playerChoice==2) || (comChoice==2 && playerChoice==3)){
            textWinner.setText("PLAYER WINS!");
            plyrScr++;
            playerScore.setText(String.valueOf(plyrScr));
        }
    }
}