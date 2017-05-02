package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper dbHelper = new HabitDbHelper(this);

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.HABIT_NAME, "Reading");
        values.put(HabitContract.HabitEntry.HABIT_DURATION, 2); //Note that duration is in hrs and is considered as an integer.
        values.put(HabitContract.HabitEntry.HABIT_DATE, "2/05/2017");
        dbHelper.insertData(values);

        /**
         * In order to check for the insertion, use log messages!
         */
        Cursor cursor = dbHelper.readData(1);
        Log.v("MainActivity", cursor.toString());
    }
}
