package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
<<<<<<< Updated upstream
        button1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AktaActivity.class)));
=======
        button1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
>>>>>>> Stashed changes
    }
}