package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {


    public static final String USER_INFO = "USER_INFO";
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_EMAIL = "USER_EMAIL";
    public static final String USER_PWORD = "USER_PWORD";
    public static final String COLUMN_ID = "COLUMN_ID";

    public DataBase(@Nullable Context context) {
        super(context, "plant.db", null, 1);
    }

    //this is called the first time database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_INFO + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME + " TEXT, " + USER_EMAIL + " TEXT, " + USER_PWORD + " TEXT)";

        db.execSQL(createTableStatement);
    }

    //this is called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Credentials credential) {

        //mandatory entries, works like Intent
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_NAME, credential.getName());
        cv.put(USER_EMAIL, credential.getEmail());
        cv.put(USER_PWORD, credential.getPassword());

        long insert = db.insert(USER_INFO, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

}
