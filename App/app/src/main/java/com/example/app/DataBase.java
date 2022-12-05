package com.example.app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

// set variables
    public static final String USER_TABLE = "USER_INFO";
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_EMAIL = "USER_EMAIL";
    public static final String USER_PWORD = "USER_PWORD";

    public DataBase(Context context) {
        super(context, "plant.db", null, 1);
    }          // constructor

    //this is called the first time database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME + " TEXT, " + USER_EMAIL + " TEXT, " + USER_PWORD + " TEXT)" ;  // long way

        db.execSQL(createTableStatement);
    }

    //this is called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Credentials");  // short way
        onCreate(db);
    }

    // add/insert values
    public boolean addOne(Credentials credential) {

        //mandatory entries, works like Intent
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_NAME, credential.getName());
        cv.put(USER_EMAIL, credential.getEmail().toLowerCase());
        cv.put(USER_PWORD, credential.getPassword());

        long insert = db.insert(USER_TABLE, null, cv);
        return insert != -1;
    }

    // delete account
    public boolean deleteOne(Credentials credentials) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + USER_TABLE + " WHERE " + USER_EMAIL + " = ?";
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(queryString, new String[] {credentials.getEmail()});
        return cursor.moveToFirst();
    }

    // check email
    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + USER_EMAIL + " = ?" , new String[] {email} );
        return cursor.getCount() > 0;
    }

    // check password
    public boolean checkPassword(String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + USER_PWORD + " = ?" , new String[] {password} );
        return cursor.getCount() > 0;
    }

    // check both
    public boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + USER_EMAIL + " = ? AND " + USER_PWORD + " = ?", new String[] {email, password} );
        return cursor.getCount() > 0;
    }

    // change pass
    public void updatePassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("UPDATE " + USER_TABLE + " SET " + USER_PWORD + " = ? " + " WHERE " + USER_EMAIL + " = ?", new String[] {password, email} );
        cursor.getCount();
    }

    public String getName(String email) {         // unused currently, returns name of currently logged in user
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT " + USER_NAME + " FROM " + USER_TABLE + " WHERE " + USER_EMAIL + " = ?", new String[] {email} );
        String name = "test";
        if (cursor.moveToFirst())
            name = cursor.getString(0);
        return name;
    }

    //accessible through the home page > settings > accounts > databaseButton (shows all collected info)
    public List<Credentials> getAll() {        // this is unused currently in the app, only use for admin bug fixing

        List<Credentials> returnList = new ArrayList<>();

        //pull data
        String queryString = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop thru the cursor and enter them into the list
            do {
                String userName = cursor.getString(1);
                String userPword = cursor.getString(3);
                String userEmail = cursor.getString(2);

                Credentials newUser = new Credentials(userName, userEmail, userPword);
                returnList.add(newUser);
            } while (cursor.moveToNext());
        }
        else {
           System.out.println("Something went wrong.");
        }

        cursor.close();               // always close this!
        db.close();
        return returnList;   // spit out list
    }

}
