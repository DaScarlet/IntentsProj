package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        okButton = findViewById(R.id.okbutton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity2();

                Context context = getApplicationContext();
                CharSequence message = "You just clicked the OK button";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
                toast.show();

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                Bundle extras = new Bundle();

                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);

                int number1 = Integer.parseInt(num1.getText().toString());
                int number2 = Integer.parseInt(num2.getText().toString());

                extras.putInt("number1", number1);
                extras.putInt("number2", number2);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }

    private void goToActivity2() {

        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
    }



}