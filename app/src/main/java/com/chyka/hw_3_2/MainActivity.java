package com.chyka.hw_3_2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    private int a, b;
    private boolean isOperationClick;
    private int result;
    MaterialButton btn_next;
    private String currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvResult = findViewById(R.id.result);
        initListener();
    }

    private void initListener() {
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
        findViewById(R.id.plus).setOnClickListener(v -> {
            onPlusClick();
            currentOperation = "+";
        });
        findViewById(R.id.minus).setOnClickListener(v -> {
            onMinusClick();
            currentOperation = "-";
        });
        findViewById(R.id.multiply).setOnClickListener(v -> {
            onMultiplyClick();
            currentOperation = "*";
        });
        findViewById(R.id.divide).setOnClickListener(v -> {
            onDivideClick();
            currentOperation = "/";
        });
        findViewById(R.id.equal).setOnClickListener(this::onEqualClick);
    }

    private void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            a = 0;
            b = 0;
            currentOperation = "";
            tvResult.setText("0");
        } else if (tvResult.getText().toString().equals("0") || isOperationClick) {
            tvResult.setText(text);
        }else {
            tvResult.append(text);
        }
        isOperationClick = false;
    }

    public void onPlusClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;;

    }

    public void onMinusClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;

    }

    public void onMultiplyClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;

    }

    public void onDivideClick() {
        a = Integer.parseInt(tvResult.getText().toString());
        isOperationClick = true;

    }
    private void onEqualClick(View view) {

        b = Integer.parseInt(tvResult.getText().toString());
        switch (currentOperation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    tvResult.setText("Error");
                    return;
                }
                break;
        }
        tvResult.setText(String.valueOf(result));
        isOperationClick = true;
    }
}