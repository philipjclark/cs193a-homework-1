package com.example.philipclark.rpspc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
        Random ran = new Random();
        int computerPick = ran.nextInt(3);
        String compObject;

        if(computerPick == 0) {
            compObject = "rock";
        } else if(computerPick == 1) {
            compObject = "paper";
        } else {
            compObject = "scissors";
        }

        int id = view.getId();

        final int WIN;

        //0 = rock, 1 = paper, 2 = scissors
        if (id == R.id.rock) {
            if(computerPick == 0) {
                WIN = 1;
            } else if(computerPick == 1) {
                WIN = 0;
            } else {
                WIN = 2;
            }
        } else if (id == R.id.paper) {
            if(computerPick == 0) {
                WIN = 2;
            } else if(computerPick == 1) {
                WIN = 1;
            } else {
                WIN = 0;
            }
        } else {
            if(computerPick == 0) {
                WIN = 0;
            } else if(computerPick == 1) {
                WIN = 2;
            } else {
                WIN = 1;
            }
        }


        if(WIN == 0) {
            points--;
            Toast.makeText(this, "You lose! Computer chose " + compObject, Toast.LENGTH_SHORT).show();

        } else if(WIN == 1) {
            Toast.makeText(this, "You tie! Computer chose " + compObject, Toast.LENGTH_SHORT).show();

        } else {
            points++;
            Toast.makeText(this, "You win! Computer chose " + compObject, Toast.LENGTH_SHORT).show();

        }
        TextView pointsView = (TextView) findViewById(R.id.pointsView);
        pointsView.setText("Points: " + points);
    }
}
