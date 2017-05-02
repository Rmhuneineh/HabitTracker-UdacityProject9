package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rmhuneineh on 02/05/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habit.db";
    private SQLiteDatabase db;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " +
                HabitContract.HabitEntry.HABIT_TABLE_NAME + "(" +
                HabitContract.HabitEntry.HABIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitContract.HabitEntry.HABIT_NAME + " TEXT NOT  NULL," +
                HabitContract.HabitEntry.HABIT_DURATION + " INT NOT NULL DEFAULT 0, " +
                HabitContract.HabitEntry.HABIT_DATE + " TEXT NOT NULL)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DELETE TABLE IF EXISTS " + HabitContract.HabitEntry.HABIT_TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }


    public void insertData(ContentValues contentValues) {
        db = getWritableDatabase();
        db.insert(HabitContract.HabitEntry.HABIT_TABLE_NAME, null, contentValues);
    }

    public Cursor readData(int id) {
        Cursor cursor;
        String selection = HabitContract.HabitEntry.HABIT_ID + " = ?";
        String[] selectionArgs = new String[]{Integer.toString(id)};
        db = getReadableDatabase();
        cursor = db.query(true, HabitContract.HabitEntry.HABIT_TABLE_NAME, null, selection,
                selectionArgs, null, null, null, null);
        cursor.moveToFirst();
        cursor.close();
        db.close();
        return cursor;
     }
}
