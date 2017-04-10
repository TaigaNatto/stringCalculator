package com.example.yuusuke.stringcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float number1;
    float number2;
    float answer;
    TextView textView;
    String numStr ="";

    String PLUS = "+";
    String MINUS = "-";
    String MULTIPLY = "×";
    String DIVIDE = "÷";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("0");
    }
    public void click(View v) {
        String tag = (String) v.getTag();
        numStr = numStr +tag;
        textView.setText(numStr);
    }

    public void plus(View v) {
        numStr = numStr + PLUS;
        textView.setText(numStr);
    }

    public void minus(View v) {
        numStr = numStr + MINUS;
        textView.setText(numStr);

    }

    public void multiply(View v) {
        numStr = numStr + MULTIPLY;
        textView.setText(numStr);
    }

    public void divide(View v) {
        numStr = numStr + DIVIDE;
        textView.setText(numStr);
    }

    public void equal(View v) {
        if (String.valueOf(numStr).contains(PLUS)){
            String str[] = String.valueOf(numStr).split("\\"+PLUS);
            number1 = Float.valueOf(str[0]);
            number2 = Float.valueOf(str[1]);
            answer = number1 + number2;
        }
        if (String.valueOf(numStr).contains(MINUS)){
            String str[] = String.valueOf(numStr).split("\\"+MINUS);
            number1 = Float.valueOf(str[0]);
            number2 = Float.valueOf(str[1]);
            answer = number1 - number2;
        }
        if (String.valueOf(numStr).contains(MULTIPLY)){
            String str[] = String.valueOf(numStr).split("\\"+MULTIPLY);
            number1 = Float.valueOf(str[0]);
            number2 = Float.valueOf(str[1]);
            answer = number1 * number2;
        }
        if (String.valueOf(numStr).contains(DIVIDE)){
            String str[] = String.valueOf(numStr).split("\\"+DIVIDE);
            number1 = Float.valueOf(str[0]);
            number2 = Float.valueOf(str[1]);
            answer = number1 / number2;
        }
        textView.setText(ansText(answer));
    }

    public void clear(View v) {
        number1 = 0;
        number2 = 0;
        answer = 0;
        numStr ="";
        textView.setText("0");
    }
    public void delete(View v){
        if(numStr != null && numStr.length() > 0){
            numStr = numStr.substring(0, numStr.length()-1);
            textView.setText(numStr);
        }
    }
    String ansText (float ans){
        if (String.valueOf(ans).contains(".0")) {
            String ansText[] = String.valueOf(ans).split("\\.");
            return ansText[0];
        }
        return String.valueOf(ans);
    }
}
