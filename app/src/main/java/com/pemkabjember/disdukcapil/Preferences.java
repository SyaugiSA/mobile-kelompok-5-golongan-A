package com.pemkabjember.disdukcapil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    static final String KEY_USER_TEREGISTEER = "ID", KEY_PASS_TEREGISTER = "pass";
    static final String KEY_USERNAME_SEDANG_LOGIN = "ID_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";

    public static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setRegisteredUser(Context context,String ID){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USER_TEREGISTEER, ID);
        editor.apply();
    }

    public static String getRegisteredUser(Context context){
        return getSharedPreferences(context).getString(KEY_USER_TEREGISTEER, "");
    }

    public static void setRegisteredPass(Context context,String password){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_PASS_TEREGISTER, password);
        editor.apply();
    }

    public static String getRegisteredPass(Context context){
        return getSharedPreferences(context).getString(KEY_PASS_TEREGISTER,"");
    }

    public static void setLoggedInUser(Context context, String ID){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USERNAME_SEDANG_LOGIN, ID);
        editor.apply();
    }

    public static String getLoggedInUser(Context context){
        return getSharedPreferences(context).getString(KEY_USERNAME_SEDANG_LOGIN,"");
    }

    public static void etLoggedInStatus(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN, status);
        editor.apply();
    }

    public static Boolean getLoggedInStatus(Context context){
        return getSharedPreferences(context).getBoolean(KEY_STATUS_SEDANG_LOGIN, false);
    }

    public static void ClearLoggedInUser(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();
    }
}