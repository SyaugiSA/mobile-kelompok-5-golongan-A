package com.pemkabjember.disdukcapil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AktaActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    TextView user, noReg, Nama, Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akta);

        user = findViewById(R.id.bg_header);
        user.setText(Preferences.getLoggedInUser(getBaseContext()));

        noReg = findViewById(R.id.no_reg);
        Nama = findViewById(R.id.nama);
        Status = findViewById(R.id.status);

        jsonData();

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), DetailAktaActivity.class));
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

    private void jsonData() {
//        String url = dataApi.api+"/aktakelahiran/"+user;
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray array = response.getJSONArray("aktakelahiran");
//
//                            for (int i = 0; i <= array.length(); i++) {
//                                JSONObject nik = array.getJSONObject(i);
//
//                                String no_reg = nik.getString("No_Reg");
//                                String nama = nik.getString("nama_lengkap");
//                                String status = nik.getString("status");
//
////                                noReg.append(no_reg);
////                                Nama.setText(nama);
////                                Status.setText(status);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        requestQueue.add(request);
    }
}