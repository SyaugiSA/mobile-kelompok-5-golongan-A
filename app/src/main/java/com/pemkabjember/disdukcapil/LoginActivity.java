package com.pemkabjember.disdukcapil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText formEmail, formPassword;
    TextView register;
    private RequestQueue requestQueue;
    private Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.button_login);
        formEmail = findViewById(R.id.form_email);
        formPassword = findViewById(R.id.form_pass);
        register = findViewById(R.id.akun_baru);

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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });
    }

    /**check inputan user*/
    public void actionLogin() {
        String id = String.valueOf(formEmail.getText());
        String password = String.valueOf(formPassword.getText());

        formEmail.setError(null);
        formPassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        //mengambil data dari form dan mengubah menjadi string

        //jika form kosong maka akan fokus
        if (TextUtils.isEmpty(password)){
            formPassword.setError("Form ini tidak boleh kosong");
            fokus = formPassword;
            cancel = true;
        }else if(!cekPassword(password)){
            formPassword.setError("Password salah");
            fokus = formPassword;
            cancel = true;
        }

        if (TextUtils.isEmpty(id)){
            formEmail.setError("Form ini tidak boleh kosong");
            fokus = formEmail;
            cancel = true;
        }else if(!cekUser(id)){
            formEmail.setError("Akun tidak tersedia");
            fokus = formEmail;
            cancel = true;
        }

        if(cancel) fokus.requestFocus();
        else masuk();
    }

    private boolean cekUser(String id) {
        return id.equals(Preferences.getRegisteredUser(getBaseContext()));
    }

    private boolean cekPassword(String password) {
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    private void masuk() {
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.etLoggedInStatus(getBaseContext(), true);
        startActivity(new Intent(getBaseContext(),MainActivity.class));finish();
    }

}