package com.natalia.lifecycle_counter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Natalia";
    private static final String KEY_COUNT = "saved_count";

    private int count = 5;
    private final String firstName = "Clinton Clarke";

    private TextView countText;
    private Button countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate called");

        countText = findViewById(R.id.count_text);
        countButton = findViewById(R.id.count_button);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, count);
        }

        updateCountDisplay();

        countButton.setOnClickListener(v -> {
            count++;
            updateCountDisplay();
        });

        Button openPart2Button = findViewById(R.id.open_part2_button);
        openPart2Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EventRegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void updateCountDisplay() {
        countText.setText(firstName + "'s Count: " + count);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
        Log.d(TAG, "onSaveInstanceState called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
    }
}
