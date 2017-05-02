package com.example.android.habittracker;

import android.provider.BaseColumns;

/**
 * Created by rmhuneineh on 02/05/2017.
 */

public class HabitContract {

    public static final class HabitEntry implements BaseColumns {
        //Table Name
        public static final String HABIT_TABLE_NAME = "habits";
        //Table Columns
        public static final String HABIT_ID = BaseColumns._ID;
        public static final String HABIT_NAME = "name";
        public static final String HABIT_DURATION = "duration";
        public static final String HABIT_DATE = "date";
    }
}
