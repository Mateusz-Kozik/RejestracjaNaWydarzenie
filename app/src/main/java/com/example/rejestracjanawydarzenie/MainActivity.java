package com.example.rejestracjanawydarzenie;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private Spinner spinnerTicket;
    private CheckBox checkBoxAgreement;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        spinnerTicket = findViewById(R.id.spinnerTicket);
        checkBoxAgreement = findViewById(R.id.checkBoxAgreement);
        buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {

        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Podaj imię");
            return;
        }

        if (TextUtils.isEmpty(email) || !email.contains("@")) {
            editTextEmail.setError("Podaj poprawny email");
            return;
        }

        if (!checkBoxAgreement.isChecked()) {
            Toast.makeText(this,
                    "Musisz zaakceptować regulamin",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,
                "Dane poprawne",
                Toast.LENGTH_SHORT).show();
    }
}