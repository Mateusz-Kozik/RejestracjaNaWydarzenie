package com.example.rejestracjanawydarzenie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView textSummary;
    private Button buttonConfirm;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textSummary = findViewById(R.id.textSummary);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonCancel = findViewById(R.id.buttonCancel);

        String name = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        String email = getIntent().getStringExtra(MainActivity.EXTRA_EMAIL);
        String ticket = getIntent().getStringExtra(MainActivity.EXTRA_TICKET);

        textSummary.setText(
                "Imię: " + name +
                        "\nEmail: " + email +
                        "\nBilet: " + ticket
        );

        buttonConfirm.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        buttonCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}