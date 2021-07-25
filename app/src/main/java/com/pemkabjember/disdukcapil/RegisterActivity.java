package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText formNik, formEmail, formPassword, formConfirmPassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        formNik = findViewById(R.id.form_nik);
        formEmail = findViewById(R.id.form_email);
        formPassword = findViewById(R.id.form_pass);
        formConfirmPassword = findViewById(R.id.form_confirm_pass);
        register = findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register() {
        String nik, email, password, confirmPassword;
        View fokus = null;
        boolean cancel = false;

        nik = formNik.getText().toString();
        email = formEmail.getText().toString();
        password = formPassword.getText().toString();
        confirmPassword = formConfirmPassword.getText().toString();

        if (TextUtils.isEmpty(nik)){
            formNik.setError("Silahkan isi form ini");
            fokus = formNik;
            cancel = true;
        }else if(cekUser(nik)){
            formNik.setError("NIK sudah terdaftar");
            fokus = formNik;
            cancel = true;
        }
        if (TextUtils.isEmpty(email)){
            formEmail.setError("Silahkan isi form ini");
            fokus = formEmail;
            cancel = true;
        }
        if (TextUtils.isEmpty(password)){
            formPassword.setError("Silahkan isi form ini");
            fokus = formPassword;
            cancel = true;
        } else if(!cekPassword(password, confirmPassword)){
            formConfirmPassword.setError("Password tidak esuai");
            fokus = formConfirmPassword;
            cancel = true;
        }

        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setRegisteredUser(getBaseContext(),nik);
            Preferences.setRegisteredPass(getBaseContext(),password);
            finish();
        }
    }
    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
    private Boolean cekPassword (String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
}