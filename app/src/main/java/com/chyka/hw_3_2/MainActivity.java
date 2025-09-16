package com.chyka.hw_3_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btn_next;
    private int a, b, result;
    private boolean isOperationClick;
    private String currentOperation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.result);
        btn_next = findViewById(R.id.next);
        btn_next.setVisibility(View.GONE);

        initListeners();
    }

    private void initListeners() {
        findViewById(R.id.one).setOnClickListener(this::onNumberClick);
        findViewById(R.id.two).setOnClickListener(this::onNumberClick);
        findViewById(R.id.tree).setOnClickListener(this::onNumberClick);
        findViewById(R.id.four).setOnClickListener(this::onNumberClick);
        findViewById(R.id.five).setOnClickListener(this::onNumberClick);
        findViewById(R.id.six).setOnClickListener(this::onNumberClick);
        findViewById(R.id.seven).setOnClickListener(this::onNumberClick);
        findViewById(R.id.eight).setOnClickListener(this::onNumberClick);
        findViewById(R.id.nine).setOnClickListener(this::onNumberClick);
        findViewById(R.id.zero).setOnClickListener(this::onNumberClick);
        findViewById(R.id.ac).setOnClickListener(this::onNumberClick);

        findViewById(R.id.plus).setOnClickListener(v -> { onOperation("+"); });
        findViewById(R.id.minus).setOnClickListener(v -> { onOperation("-"); });
        findViewById(R.id.multiply).setOnClickListener(v -> { onOperation("*"); });
        findViewById(R.id.divide).setOnClickListener(v -> { onOperation("/"); });
        findViewById(R.id.equal).setOnClickListener(this::onEqualClick);
    }

    private void onNumberClick(View view) {
        btn_next.setVisibility(View.GONE);
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            a = b = 0;
            currentOperation = "";
            tvResult.setText("0");
        } else if (tvResult.getText().toString().equals("0") || isOperationClick) {
            tvResult.setText(text);
        } else {
            tvResult.append(text);
        }
        isOperationClick = false;
    }

    private void onOperation(String op) {
        a = Integer.parseInt(tvResult.getText().toString());
        currentOperation = op;
        isOperationClick = true;
        btn_next.setVisibility(View.GONE);
    }

    private void onEqualClick(View view) {
        b = Integer.parseInt(tvResult.getText().toString());
        switch (currentOperation) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = (b != 0) ? a / b : 0; break;
        }
        tvResult.setText(String.valueOf(result));
        btn_next.setVisibility(View.VISIBLE);
        btn_next.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("result", tvResult.getText().toString());
            startActivity(intent);
        });
        isOperationClick = true;
    }
}
