package com.pemkabjember.disdukcapil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    private  Context context;
    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";
    static final String id = "id";
    static SharedPreferences sharedPreference;

    public Preferences(Context context){
        this.sharedPreference = context.getSharedPreferences("login Session", Context.MODE_PRIVATE);
        this.context = context;
    }

    public  String getId(){
        return sharedPreference.getString(id,"");
    }

    public void setId(String id){
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(this.id, id);
        editor.commit();
    }
}
