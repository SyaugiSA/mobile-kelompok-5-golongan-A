package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Preferences preferences;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = new Preferences(this);

        button1 = findViewById(R.id.button1);

        if (preferences.getId() == null || preferences.getId().isEmpty()){
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
        }
    }
}