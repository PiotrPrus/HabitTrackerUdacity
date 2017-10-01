package com.example.piotr.habittrackerudacity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.piotr.habittrackerudacity.HabitsContract.HabitEntry;

/**
 * Created by Piotr on 28.09.2017.
 */

public class HabitsDbHelper extends SQLiteOpenHelper {

    private static final String TAG = HabitsDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;

    public HabitsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_HABITS_DB = "CREATE TABLE " + HabitEntry.TABLE_NAME +
                "(" + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitEntry.COLUMN_HABIT + " INTEGER NOT NULL," +
                HabitEntry.COLUMN_TIME + " TEXT," +
                HabitEntry.COLUMN_SATISFACTION + " INTEGER NOT NULL);";
        Log.v(TAG, "create table: " + CREATE_TABLE_HABITS_DB);
        sqLiteDatabase.execSQL(CREATE_TABLE_HABITS_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insertHabit(int habit, String time, int satisfactionLevel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT, habit);
        values.put(HabitEntry.COLUMN_TIME, time);
        values.put(HabitEntry.COLUMN_SATISFACTION, satisfactionLevel);
        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitEntry._ID, HabitEntry.COLUMN_HABIT,
                HabitEntry.COLUMN_TIME, HabitEntry.COLUMN_SATISFACTION
        };
        return db.query(
                HabitEntry.TABLE_NAME,
                projection, null, null, null, null, null);
    }
}
