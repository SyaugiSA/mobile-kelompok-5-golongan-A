package com.pemkabjember.disdukcapil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dispenduk.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE dispenduk(no integer primary key, nik text null, nama text null, tgl text null, status text null);";
        Log.d("Data", "onCreate:" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO dispenduk (no, nik, nama, tgl, status) VALUES ('1', '3509123456789012', 'Wardhatul Jannah', '2005-06-17', 'Menunggu');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
