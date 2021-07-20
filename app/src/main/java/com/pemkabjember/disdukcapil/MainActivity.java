package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        BelumLogin();
    }

    private void BelumLogin() {
        if(! Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),LoginActivity.class));finish();
        }
    }
}