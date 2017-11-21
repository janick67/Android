package com.example.android.volleyballcounter;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.volleyballcounter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int team_1 = 0, team_2 = 0, serve_1 = 0, serve_2 = 0, attack_1 = 0, attack_2 = 0, fault_1 = 0, fault_2 = 0, teamSet_1 = 0, teamSet_2 = 0;

    public void serve_1(View view){
        addScoreToTeamA();
        serve_1 += 1;
    }

    public void serve_2(View view){
        addScoreToTeamB();
        serve_2 += 1;
    }

    public void attack_1(View view){
        addScoreToTeamA();
        attack_1 += 1;
    }

    public void attack_2(View view){
        addScoreToTeamB();
        attack_2 += 1;
    }

    public void fault_1(View view){
        addScoreToTeamB();
        fault_1 += 1;
    }

    public void fault_2(View view){
        addScoreToTeamA();
        fault_2 += 1;
    }

    public void reset(View view){
        reset();
        display();
    }

    public void reset(){
        team_1 = 0;
        team_2 = 0;
        serve_1 = 0;
        serve_2 = 0;
        attack_1 = 0;
        attack_2 = 0;
        fault_1 = 0;
        fault_2 = 0;
        teamSet_1 = 0;
        teamSet_2 = 0;
        setServe(0);
    }

    private void addScoreToTeamA(){
        team_1 += 1;
        setServe(1);
        display();
        if (team_1 >= 25 || (team_2 >= 15 && teamSet_1 + teamSet_2 == 4)){ // 25 pkt lub 15 w 5 secie
            if (team_2 + 1 < team_1) {//różnica 2 pkt w siatkówce
                winSet(1);
            }
        }
    }

    private void addScoreToTeamB(){
        team_2 += 1;
        setServe(2);
        display();

        if (team_2 >= 25 || (team_2 >= 15 && teamSet_1 + teamSet_2 == 4)){ // 25 pkt lub 15 w 5 secie
            if (team_1 + 1 < team_2) {//różnica 2 pkt w siatkówce
                winSet(2);
            }
        }
    }

    public void setServe(int team) {
        TextView text1 = (TextView) findViewById(R.id.tServe_1);
        TextView text2 = (TextView) findViewById(R.id.tServe_2);
        if (team == 1) {
            text1.setBackgroundColor(Color.rgb(255, 144, 00));
            text2.setBackgroundColor(Color.TRANSPARENT);
        } else if(team == 2) {
            text1.setBackgroundColor(Color.TRANSPARENT);
            text2.setBackgroundColor(Color.rgb(255, 144, 00));
        } else {
            text1.setBackgroundColor(Color.TRANSPARENT);
            text2.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void winSet(int team){
        TextView win = (TextView) findViewById(R.id.win);
        win.setVisibility(View.VISIBLE);
        if (team == 1){
            teamSet_1 += 1;
            win.setText("Set win\nTeamA");
        }else {
            teamSet_2 += 1;
            win.setText("Set win\nTeamA");
        }
        team_1 = 0;
        team_2 = 0;
        setServe(0);


        if (teamSet_1 == 3 || teamSet_2 == 3) {
            winGame(team);
        }
    }

    private void winGame(int team){
        TextView win = (TextView) findViewById(R.id.win);
        win.setVisibility(View.VISIBLE);
        if (team == 1){
            win.setText("Win\nTeamA");
        }else{
            win.setText("Win\nTeamB");
        }
        reset();
    }



    private void display(){
        TextView win = (TextView) findViewById(R.id.win);
        win.setVisibility(View.INVISIBLE);
        TextView sets = (TextView) findViewById(R.id.tSets);
        sets.setText(teamSet_1 + "   :   " + teamSet_2);
        TextView score1 = (TextView) findViewById(R.id.score_1);
        score1.setText("" + team_1);
        TextView score2 = (TextView) findViewById(R.id.score_2);
        score2.setText("" + team_2);
        TextView serve1 = (TextView) findViewById(R.id.serve_1);
        serve1.setText("" + serve_1);
        TextView serve2 = (TextView) findViewById(R.id.serve_2);
        serve2.setText("" + serve_2);
        TextView attack1 = (TextView) findViewById(R.id.attack_1);
        attack1.setText("" + attack_1);
        TextView attack2 = (TextView) findViewById(R.id.attack_2);
        attack2.setText("" + attack_2);
        TextView fault1 = (TextView) findViewById(R.id.fault_1);
        fault1.setText("" + fault_1);
        TextView fault2 = (TextView) findViewById(R.id.fault_2);
        fault2.setText("" + fault_2);
    }

}
