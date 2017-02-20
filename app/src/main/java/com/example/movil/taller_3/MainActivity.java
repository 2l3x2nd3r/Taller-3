package com.example.movil.taller_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public double first = 0.0;
    public String op;
    public double last = 0.0;
    public boolean recentOperate = false;
    public boolean canOperate = false;

    EditText result;

    Button btnplus;
    Button btnminus;
    Button btnmult;
    Button btndiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.editText);

        btnplus = (Button) findViewById(R.id.btnplus);
        btnminus = (Button) findViewById(R.id.btnminus);
        btnmult = (Button) findViewById(R.id.btnmult);
        btndiv = (Button) findViewById(R.id.btndiv);
    }

    public void numberClick(View view) {
        if(recentOperate) {
            result.setText("");
            recentOperate = false;
        }
        String text = result.getText().toString();
        switch(view.getId())
        {
            case R.id.btn0:
                result.setText(text + "0");
                break;
            case R.id.btn1:
                result.setText(text + "1");
                break;
            case R.id.btn2:
                result.setText(text + "2");
                break;
            case R.id.btn3:
                result.setText(text + "3");
                break;
            case R.id.btn4:
                result.setText(text + "4");
                break;
            case R.id.btn5:
                result.setText(text + "5");
                break;
            case R.id.btn6:
                result.setText(text + "6");
                break;
            case R.id.btn7:
                result.setText(text + "7");
                break;
            case R.id.btn8:
                result.setText(text + "8");
                break;
            case R.id.btn9:
                result.setText(text + "9");
                break;
            case R.id.btnp:
                result.setText(text + ".");
                break;
        }
    }

    public void operationClick(View view) {
        String text = result.getText().toString();
        first = Double.parseDouble(text);
        switch(view.getId())
        {
            case R.id.btnplus:
                op = "+";
                result.setText(text + "+");
                break;
            case R.id.btnminus:
                op = "-";
                result.setText(text + "-");
                break;
            case R.id.btnmult:
                op = "*";
                result.setText(text + "*");
                break;
            case R.id.btndiv:
                op = "/";
                result.setText(text + "/");
                break;
        }
        btnplus.setEnabled(false);
        btnminus.setEnabled(false);
        btnmult.setEnabled(false);
        btndiv.setEnabled(false);
    }



    public void operate(View view){
        String text = result.getText().toString();
        String[] array = text.split("\\" + op);
        last = Double.parseDouble(array[1]);
        switch (op) {
            case "+":
                result.setText((first + last) + "");
                break;
            case "-":
                result.setText((first - last) + "");
                break;
            case "*":
                result.setText((first * last) + "");
                break;
            case "/":
                result.setText((first / last) + "");
                break;
        }
        btnplus.setEnabled(true);
        btnminus.setEnabled(true);
        btnmult.setEnabled(true);
        btndiv.setEnabled(true);
        recentOperate = true;
        op = "";
        first = 0.0;
        last = 0.0;
    }


}
