package com.example.teste4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Button checkButton;
    private TextView resultTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.input_number);
        checkButton = findViewById(R.id.check_button);
        resultTextView = findViewById(R.id.result_text_view);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumber.getText().toString().trim();

                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    boolean isPerfect = isPerfectNumber(number);
                    String result = isPerfect ? "O número é perfeito!" : "O número não é perfeito!";
                    resultTextView.setText(result);
                }
            }
        });
    }

    private boolean isPerfectNumber(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }
}