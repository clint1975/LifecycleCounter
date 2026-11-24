package com.natalia.lifecycle_counter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EventRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // LinearLayout version (active):
        setContentView(R.layout.activity_event_linear);

        // RelativeLayout version (swap comments to test this one):
        // setContentView(R.layout.activity_event_relative);

        EditText emailInput = findViewById(R.id.email_input);
        Button registerButton = findViewById(R.id.register_button);
        TextView statusText = findViewById(R.id.status_text);

        registerButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();

            if (email.isEmpty()) {
                statusText.setText("Enter your student email first.");
            } else {
                statusText.setText("Registered: " + email);
            }
        });
    }
}
