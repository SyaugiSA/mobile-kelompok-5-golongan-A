package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notLogedIn();

        user = findViewById(R.id.bg_header);
        user.setText(Preferences.getLoggedInUser(getBaseContext()));

        findViewById(R.id.btn_buka).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wsjti.id/Bersama/public/")));
            }
        });

        findViewById(R.id.btn_akta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AktaActivity.class));
            }
        });

        findViewById(R.id.btn_ktp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), KartuTandaPendudukActivity.class));
            }
        });

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        findViewById(R.id.btn_akun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AkunActivity.class));
            }
        });
    }

    private void notLogedIn(){
        if (!Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),LoginActivity.class));
            finish();
        }
    }
}