package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int team_1 = 0, team_2 = 0;

    public void addOne_1(View view){
        team_1 += 1;
        display_1(team_1);
    }

    public void addTwo_1(View view){
        team_1 += 2;
        display_1(team_1);
    }

    public void addThree_1(View view){
        team_1 += 3;
        display_1(team_1);
    }

    public void addOne_2(View view){
        team_2 += 1;
        display_2(team_2);
    }

    public void addTwo_2(View view){
        team_2 += 2;
        display_2(team_2);
    }

    public void addThree_2(View view){
        team_2 += 3;
        display_2(team_2);
    }

    public void reset(View view){
        team_1 = 0;
        team_2 = 0;
        display_1(0);
        display_2(0);
    }

    private void display_1(int value){
        TextView score = (TextView) findViewById(R.id.score_1);
        score.setText("" + value);
    }

    private void display_2(int value){
        TextView score = (TextView) findViewById(R.id.score_2);
        score.setText("" + value);
    }
}
