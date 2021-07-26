package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AkunActivity extends AppCompatActivity {
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        user = findViewById(R.id.bg_header);
        user.setText(Preferences.getLoggedInUser(getBaseContext()));

        findViewById(R.id.button_keluar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.ClearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });

        findViewById(R.id.btn_akun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AkunActivity.class));
            }
        });
    }
}