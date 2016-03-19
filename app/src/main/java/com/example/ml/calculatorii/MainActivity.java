package com.example.ml.calculatorii;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    /*
    private static final String TAG = "MainActivity";

    private static final String STATE_FIRST_NUMBER = "firstNumber";
    private static final String STATE_SECOND_NUMBER = "secondNumber";
    private static final String STATE_DISPLAY = "display";
    private static final String STATE_ANSWER = "answer";
    private static final String STATE_OPERATION = "operationType";
    private static final String STATE_STEP = "step";
    private static final String STATE_DOT_PRESSED = "dotPressed";

    private CalculatorLogic calculatorLogic;
    */

    private static TextView display;
    private static TextView answer;

    private static String displayCopy;
    private static String answerCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        answer = (TextView) findViewById(R.id.answer);

        display.setText(displayCopy);
        answer.setText(answerCopy);

        /*
        calculatorLogic = new CalculatorLogic();

        if(savedInstanceState != null) {
            if (BuildConfig.DEBUG) { Log.d(TAG, "Restoring state"); }

            calculatorLogic.setFirstNumber(savedInstanceState.getString(STATE_FIRST_NUMBER));
            calculatorLogic.setSecondNumber(savedInstanceState.getString(STATE_SECOND_NUMBER));
            calculatorLogic.setDisplay(savedInstanceState.getString(STATE_DISPLAY));
            calculatorLogic.setAnswer(savedInstanceState.getString(STATE_ANSWER));
            calculatorLogic.setOperationType(savedInstanceState.getInt(STATE_OPERATION));
            calculatorLogic.setStep(savedInstanceState.getInt(STATE_STEP));
            calculatorLogic.setDotPressed(savedInstanceState.getBoolean(STATE_DOT_PRESSED));
        }
        display.setText(calculatorLogic.getDisplay());
        answer.setText(calculatorLogic.getAnswer());
        */

    }

    public void buttonClick(View v) {
        broadcastIntent(v);
    }

    public void broadcastIntent(View view) {
        Button b = (Button) view;
        String id = b.getResources().getResourceName(b.getId());

        Intent intent = new Intent();
        intent.setAction("com.ee.calculatorRequest");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra("buttonId", id);

        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String[] result = getResultData().split("_");
                if (result.length > 0) {
                    display.setText(result[0]);
                    displayCopy = result[0];
                }
                if (result.length > 1) {
                    answer.setText(result[1]);
                    answerCopy = result[1];
                } else {
                    answer.setText("");
                }


            }
        }, null, Activity.RESULT_OK, null, null);
    }

    /*
    public void number(View v) {
        calculatorLogic.number(v.getId());
        display.setText(calculatorLogic.getDisplay());
    }

    public void operation(View v) {
        calculatorLogic.operation(v.getId());
        display.setText(calculatorLogic.getDisplay());
    }

    public void clear(View v) {
        calculatorLogic.clear();
        display.setText(calculatorLogic.getDisplay());
        answer.setText(calculatorLogic.getAnswer());
    }

    public void calculate(View v) {
        calculatorLogic.calculate();
        display.setText(calculatorLogic.getDisplay());
        answer.setText(calculatorLogic.getAnswer());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_FIRST_NUMBER, calculatorLogic.getFirstNumber());
        savedInstanceState.putString(STATE_SECOND_NUMBER, calculatorLogic.getSecondNumber());
        savedInstanceState.putString(STATE_DISPLAY, calculatorLogic.getDisplay());
        savedInstanceState.putString(STATE_ANSWER, calculatorLogic.getAnswer());
        savedInstanceState.putInt(STATE_OPERATION, calculatorLogic.getOperationType());
        savedInstanceState.putInt(STATE_STEP, calculatorLogic.getStep());
        savedInstanceState.putBoolean(STATE_DOT_PRESSED, calculatorLogic.getDotPressed());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onStart called"); }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onResume called"); }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onPause called"); }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onStop called"); }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) { Log.d(TAG, "onDestroy called"); }
    }
    */
}