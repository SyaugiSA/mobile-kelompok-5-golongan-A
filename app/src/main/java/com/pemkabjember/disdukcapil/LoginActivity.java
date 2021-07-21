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
//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
//            }
//        });
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
        }
        if (TextUtils.isEmpty(id)){
            formEmail.setError("Form ini tidak boleh kosong");
            fokus = formEmail;
            cancel = true;
        }

        if(cancel) fokus.requestFocus();

        String Url = dataApi.login;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        requestQueue.getCache().clear();
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            if (jsonObject.optString("user").equals("user")) {
//                                JSONObject jsonObject1 = jsonObject.getJSONObject("user");
//                                preferences.setId((jsonObject1.getString("id")));
//
//                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
//                                startActivity(new Intent(getBaseContext(), MainActivity.class));
//                                finish();
//                            } else {
//                                Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> params = new HashMap<>();
                params.put("id", formEmail.getText().toString());
                params.put("password", formPassword.getText().toString());
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }
}