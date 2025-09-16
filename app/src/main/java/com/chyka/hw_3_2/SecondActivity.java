package com.chyka.hw_3_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {
    public TextView tvResult;
    public Button heart_pink;
    public ImageView heart_blue;
    public MaterialButton btn_category;
    public MaterialButton btn_next;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        heart_blue = findViewById(R.id.blue_heart);
        tvResult = findViewById(R.id.tv_ex);
        heart_pink = findViewById(R.id.heart_pink);
        btn_category = findViewById(R.id.btn_category);
        btn_next = findViewById(R.id.btn_next);
        Intent intent = getIntent();
        if (heart_blue.getVisibility() == View.GONE) {
            heart_pink.setOnClickListener(v -> {
                heart_pink.setVisibility(View.GONE);
                heart_blue.setVisibility(View.VISIBLE);
                btn_category.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.blue)));
            });
        } else {
            heart_blue.setOnClickListener(v -> {
                heart_blue.setVisibility(View.GONE);
                heart_pink.setVisibility(View.VISIBLE);
                btn_category.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.pink)));
            });
        }
        btn_next.setOnClickListener(v -> {
            finishAffinity();
        });

    }
}