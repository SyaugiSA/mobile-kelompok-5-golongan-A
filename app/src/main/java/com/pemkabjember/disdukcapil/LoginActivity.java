package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button loginButton, registerButton;
    EditText formEmail, formPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.button_login);
        formEmail = findViewById(R.id.form_email);
        formPassword = findViewById(R.id.form_pass);

        /*menjalankan method actionLogin() jika tombol signIn di keyboard disentuh*/
        formPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE||actionId == EditorInfo.IME_NULL){
                    actionLogin();
                    return true;
                }
                return false;
            }
        });

        /*menjalankan method actionLogin() jika tombol signIN disentuh*/
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionLogin();
            }
        });

        /*menuju halaman registerasi jika tombol registrasi disentuh*/
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),/*RegisterActivity.class*/));
            }
        });
    }

    /**menuju mainActivity jika logedin status true*/
    @Override
    protected void onStart() {
        super.onStart();
        if(Preferences.getLoggedInStatus(getBaseContext() )){
            startActivity(new Intent(getBaseContext(),MainActivity.class));finish();
        }
    }

    /**check inputan user*/
    private void actionLogin() {
        formEmail.setError(null);
        formPassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        //mengambil data dari form dan mengubah menjadi string
        String id = formEmail.getText().toString();
        String password = formPassword.getText().toString();

        //jika form kosong maka akan fokus
        if (TextUtils.isEmpty(id)){
            formEmail.setError("Form ini tidak boleh kosong");
            fokus = formEmail;
            cancel = true;
        }
        if (TextUtils.isEmpty(password)){
            formPassword.setError("Form ini tidak boleh kosong");
            fokus = formPassword;
            cancel = true;
        }
        if(cancel) fokus.requestFocus();
        else masuk();
    }

    /**masuk halaman Mainactifity*/
    private void masuk() {
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.etLoggedInStatus(getBaseContext(), true);
        startActivity(new Intent(getBaseContext(),MainActivity.class));finish();
    }
}