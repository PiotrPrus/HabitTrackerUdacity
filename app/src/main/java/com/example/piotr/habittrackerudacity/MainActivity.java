package com.example.piotr.habittrackerudacity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static com.example.piotr.habittrackerudacity.HabitsContract.HabitEntry.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitsDbHelper dbHelper = new HabitsDbHelper(this);
        dbHelper.insertHabit(HABIT_ANDROID_DEVELOPMENT, "2 hours", SATISFY);
        dbHelper.insertHabit(HABIT_WALKING_WITH_A_DOG, "30 minutes", QUITE_SATISFY);
        dbHelper.insertHabit(HABIT_PLAYING_WITH_A_DOG, "1 hour", VERY_SATISFY);
        dbHelper.insertHabit(HABIT_CLEANING, "10 minutes", NO_SATISFY_AT_ALL);

        Cursor cursor = dbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "Habit " + cursor.getInt(0) + " " + cursor.getInt(1) + " "
                    + cursor.getInt(2) + " " + cursor.getInt(3));
        }
    }
}
