package com.example.bankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.bankingapp.UserContract.UserEntry;
public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserContract.UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(12340,'Asgar Alam', 'asgar@gmail.com','7854029658','7895641238', 35000)");
        db.execSQL("insert into " + TABLE_NAME + " values(12341,'Dale Phillip', 'dale@gmail.com','5402971258','8995641238', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(12342,'Ismail Sarr', 'ismail9@gmail.com','8896764889','7595645896', 19000)");
        db.execSQL("insert into " + TABLE_NAME + " values(12342,'Rafiq Alam', 'rafiq2@gmail.com','7752965002','9995640038', 18000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Surya Kumar', 'surya@gmail.com','3660077669','9095648962', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Piyush Tiwari', 'piyush@gmail.com','3077229985','8855640238', 13000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Ahmed Raza', 'raza@gmail.com','1118748207','8895640215', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Michael Edward', 'edward@gmail.com','4522529650','9985021539', 21500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Foster Fraser', 'fraser@gmail.com','6567648882','9309565238', 9999)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Ryan Hakimi', 'ryan@gmail.com','5450785489','8292591201', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Anup Desai', 'anup@gmail.com','2652252956','9015641200', 18000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Ram Prasad', 'ram234@gmail.com','1203118748','9995641999', 14522)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}