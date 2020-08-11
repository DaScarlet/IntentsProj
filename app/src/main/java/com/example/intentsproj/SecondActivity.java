package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView result;
    //EditText number1, number2;
    Button add, subtract, divide, multiply;

    float sum;
    int num_one, num_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LayoutInflater li = getLayoutInflater();
        final View layout = li.inflate(R.layout.customtoast, (ViewGroup)findViewById(R.id.custom_toast_layout));

        result = (TextView)findViewById(R.id.result);
        //number1 = (EditText)findViewById(R.id.num3);
        //number2 = (EditText)findViewById(R.id.num4);

        add = (Button)findViewById(R.id.add);
        subtract = (Button)findViewById(R.id.subtract);
        divide = (Button)findViewById(R.id.divide);
        multiply = (Button)findViewById(R.id.multiply);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final String number1 = String.valueOf(extras.getInt("number1"));
        final String number2 = String.valueOf(extras.getInt("number2"));

        EditText num3 = (EditText)findViewById(R.id.num3);
        EditText num4 = (EditText)findViewById(R.id.num4);

        num3.setText(number1);
        num4.setText(number2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num_one = Integer.parseInt(number1);
                num_two = Integer.parseInt(number2);
                sum = num_one + num_two;

                result.setText(number1 + "+" + number2 + "=" + String.valueOf(sum));

            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num_one = Integer.parseInt(number1);
                num_two = Integer.parseInt(number2);

                if (num_one < num_two) {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setView(layout);
                    toast.show();
                }
                sum = num_one - num_two;

                result.setText(number1 + "-" + number2 + "=" + String.valueOf(sum));
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_one = Integer.parseInt(number1);
                num_two = Integer.parseInt(number2);
                sum = num_one * num_two;

                result.setText(number1 + "*" + number2 + "=" + String.valueOf(sum));
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_one = Integer.parseInt(number1);
                num_two = Integer.parseInt(number2);
                sum = num_one / num_two;

                result.setText(number1 + "/" + number2 + "=" + String.valueOf(sum));
            }
        });
    }
}