package cz.inturist.easterquiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitAnswer(View view) {
        RadioButton correctQuestion1 = (RadioButton) findViewById(R.id.radio_1_question_1);
        RadioButton correctQuestion2 = (RadioButton) findViewById(R.id.radio_1_question_2);
        RadioButton correctQuestion4 = (RadioButton) findViewById(R.id.radio_1_question_4);
        RadioButton correctQuestion5 = (RadioButton) findViewById(R.id.radio_2_question_5);
        RadioButton correctQuestion6 = (RadioButton) findViewById(R.id.radio_1_question_6);
        RadioButton correctQuestion7 = (RadioButton) findViewById(R.id.radio_1_question_7);
        RadioButton correctQuestion8 = (RadioButton) findViewById(R.id.radio_1_question_8);
        RadioButton correctQuestion9 = (RadioButton) findViewById(R.id.radio_1_question_9);
        CheckBox correctQuestion3_1 = (CheckBox) findViewById(R.id.question_3_checkbox_1);
        CheckBox correctQuestion3_2 = (CheckBox) findViewById(R.id.question_3_checkbox_2);
        CheckBox correctQuestion3_3 = (CheckBox) findViewById(R.id.question_3_checkbox_3);
        CheckBox correctQuestion3_4 = (CheckBox) findViewById(R.id.question_3_checkbox_4);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        boolean hasCorrectQuestion1 = correctQuestion1.isChecked();
        boolean hasCorrectQuestion2 = correctQuestion2.isChecked();
        boolean hasCorrectQuestion4 = correctQuestion4.isChecked();
        boolean hasCorrectQuestion5 = correctQuestion5.isChecked();
        boolean hasCorrectQuestion6 = correctQuestion6.isChecked();
        boolean hasCorrectQuestion7 = correctQuestion7.isChecked();
        boolean hasCorrectQuestion8 = correctQuestion8.isChecked();
        boolean hasCorrectQuestion9 = correctQuestion9.isChecked();
        boolean hasCorrectQuestion3_1 = correctQuestion3_1.isChecked();
        boolean hasCorrectQuestion3_2 = correctQuestion3_2.isChecked();
        boolean hasCorrectQuestion3_3 = correctQuestion3_3.isChecked();
        boolean hasCorrectQuestion3_4 = correctQuestion3_4.isChecked();
        String name = editText.getText().toString();
        int totalScore = calculateTotalScore(hasCorrectQuestion1, hasCorrectQuestion2, hasCorrectQuestion4, hasCorrectQuestion5, hasCorrectQuestion6, hasCorrectQuestion7, hasCorrectQuestion8, hasCorrectQuestion9, hasCorrectQuestion3_1, hasCorrectQuestion3_2, hasCorrectQuestion3_3, hasCorrectQuestion3_4);
        String totalScoreMessage = createQuizSummary(name, totalScore);
        Toast.makeText(this, totalScoreMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * Calculates total Score.
     *
     * @param addCorrectQuestion1   correct answer for question 1
     * @param addCorrectQuestion2   correct answer for question 2
     * @param addCorrectQuestion4   correct answer for question 4
     * @param addCorrectQuestion5   correct answer for question 5
     * @param addCorrectQuestion6   correct answer for question 6
     * @param addCorrectQuestion7   correct answer for question 7
     * @param addCorrectQuestion8   correct answer for question 8
     * @param addCorrectQuestion9   correct answer for question 9
     * @param addCorrectQuestion3_1 1-st box checked for question 3
     * @param addCorrectQuestion3_2 2-nt box checked for question 3
     * @param addCorrectQuestion3_3 3-rd box checked for question 3
     * @param addCorrectQuestion3_4 4-th box checked for question 3
     * @return total score
     */
    public int calculateTotalScore(boolean addCorrectQuestion1, boolean addCorrectQuestion2, boolean addCorrectQuestion4, boolean addCorrectQuestion5, boolean addCorrectQuestion6, boolean addCorrectQuestion7, boolean addCorrectQuestion8, boolean addCorrectQuestion9, boolean addCorrectQuestion3_1, boolean addCorrectQuestion3_2, boolean addCorrectQuestion3_3, boolean addCorrectQuestion3_4) {
        int score = 0;
        if (addCorrectQuestion1) {
            score = score + 1;
        }
        if (addCorrectQuestion2) {
            score = score + 1;
        }
        if (addCorrectQuestion4) {
            score = score + 1;
        }
        if (addCorrectQuestion5) {
            score = score + 1;
        }
        if (addCorrectQuestion6) {
            score = score + 1;
        }
        if (addCorrectQuestion7) {
            score = score + 1;
        }
        if (addCorrectQuestion8) {
            score = score + 1;
        }
        if (addCorrectQuestion9) {
            score = score + 1;
        }
        if (addCorrectQuestion3_1) {
            if (addCorrectQuestion3_2) {
                if (addCorrectQuestion3_3) {
                    if (addCorrectQuestion3_4) {
                        score = score;
                    } else {
                        score = score + 1;
                    }
                }
            }
        }
        return score;
        /**
         * Create the summary of the quiz.
         * @param name of the player
         *@param score of correct answers
         * @return totalScoreMessage summury
         */
    }

    private String createQuizSummary(String name, int score) {
        String totalScoreMessage = " ";
        if (score == 9) {
            totalScoreMessage = getString(R.string.Congratulations, name);
        } else {
            totalScoreMessage = getString(R.string.tryAgain, name);
        }
        totalScoreMessage += "\n";
        totalScoreMessage += getString(R.string.scoreMessage, score);
        return totalScoreMessage;
    }

}

