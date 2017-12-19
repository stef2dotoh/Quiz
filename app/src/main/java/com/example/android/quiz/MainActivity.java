package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {

        // Check question 1: radio button
        RadioButton q1_answer = findViewById(R.id.q1_answer);
        if (q1_answer.isChecked()) {
            addPoint();
        }

        // Check question 2: text entry
        EditText q2_answer = findViewById(R.id.q2_answer);
        String q2Answer = q2_answer.getText().toString();

        if (q2Answer.equalsIgnoreCase("Aliens")) {
            addPoint();
        }

        // Check question 3: radio button
        RadioButton q3_answer = findViewById(R.id.q3_answer);
        if (q3_answer.isChecked()) {
            addPoint();
        }

        // Check question 4: text entry
        EditText q4_answer = findViewById(R.id.q4_answer);
        String q4Answer = q4_answer.getText().toString();

        if (q4Answer.equalsIgnoreCase("Ghostbusters")) {
            addPoint();
        }

        // Check question 5: check box
        CheckBox q5_answer_1 = findViewById(R.id.q5_answer_1);
        CheckBox q5_answer_2 = findViewById(R.id.q5_answer_2);
        CheckBox q5_answer_3 = findViewById(R.id.q5_answer_3);
        CheckBox q5_answer_4 = findViewById(R.id.q5_answer_4);

        if ((q5_answer_1.isChecked() && q5_answer_3.isChecked()) && !q5_answer_2.isChecked() && !q5_answer_4.isChecked()) {
            addPoint();
        }

        displayPoints(getPoints());

    }

    /**
     * Add point to score for correct answer
     */

    public void addPoint() {
        points++;
    }

    /**
     * Get total points earned
     *
     * @return points
     */

    public int getPoints() {
        return points;
    }

    /**
     * Display total points earned in a toast pop-up
     *
     * @param totalPoints the total number of points earned
     */

    public void displayPoints(int totalPoints) {

        if (totalPoints == 5) {
            Toast.makeText(this, "Total Points: " + totalPoints + " Great job!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Total Points: " + totalPoints, Toast.LENGTH_SHORT).show();
        }

        // Reset points to 0 to play again
        points = 0;
    }
}
