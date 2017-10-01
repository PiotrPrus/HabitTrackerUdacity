package com.example.piotr.habittrackerudacity;

import android.provider.BaseColumns;

/**
 * Created by Piotr on 28.09.2017.
 */

public class HabitsContract {
    public HabitsContract() {
    }

    public class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits_database";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_TIME = "time";
        public final static String COLUMN_SATISFACTION = "satisfaction";

        public final static int HABIT_WALKING_WITH_A_DOG = 0;
        public final static int HABIT_PLAYING_WITH_A_DOG = 1;
        public final static int HABIT_ANDROID_DEVELOPMENT = 2;
        public final static int HABIT_CLEANING = 3;

        public final static int NO_SATISFY_AT_ALL = 4;
        public final static int QUITE_SATISFY = 5;
        public final static int SATISFY = 6;
        public final static int VERY_SATISFY = 7;

    }
}
