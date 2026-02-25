package com.example.rejestracjanawydarzenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private Spinner spinnerTicket;
    private CheckBox checkBoxAgreement;
    private Button buttonNext;
    private ActivityResultLauncher<Intent> launcher;
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_TICKET = "extra_ticket";

    public static final int REQUEST_CODE = 1;

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

        // Launcher do odbierania wyniku z SummaryActivity
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    if (result.getResultCode() == RESULT_OK) {
                        Toast.makeText(this,
                                "Rejestracja potwierdzona",
                                Toast.LENGTH_SHORT).show();
                    }

                    if (result.getResultCode() == RESULT_CANCELED) {
                        Toast.makeText(this,
                                "Rejestracja anulowana",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
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

        String ticket = spinnerTicket.getSelectedItem().toString();

        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_EMAIL, email);
        intent.putExtra(EXTRA_TICKET, ticket);

        launcher.launch(intent);
    }
}