package com.tixon.smartschedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = "myLogs";

    private static final String DB_NAME = "smart_schedule_database";
    private static final int DB_VERSION = 1;

    //table names
    private static final String TABLE_SCHEDULE = "table_schedule";
    private static final String TABLE_RINGS = "table_rings";
    private static final String TABLE_HOMEWORK = "table_homework";

    //common fields
    private static final String UID = "_id";

    //schedule fields
    private static final String FIELD_SUBJECT_NAME = "subject_name";
    private static final String FIELD_ROOM = "room";
    private static final String FIELD_TYPE = "type";

    //rings fields
    private static final String FIELD_NUMBER = "count_number";
    private static final String FIELD_START_TIME = "start_time";
    private static final String FIELD_END_TIME = "end_time";

    //creating tables
    private static final String CREATE_TABLE_RINGS = "create table " + TABLE_RINGS + " (" + UID
            + " integer primary key autoincrement, " + FIELD_NUMBER + " integer, "
            + FIELD_START_TIME + " integer, " + FIELD_END_TIME + " integer" + ");";

    private static final String CREATE_TABLE_SCHEDULE = "create table " + TABLE_SCHEDULE + " ("
            + UID + " integer primary key autoincrement, " + FIELD_SUBJECT_NAME + " text, "
            + FIELD_ROOM + " text, " + FIELD_TYPE + " integer, " + FIELD_NUMBER + " integer" + ");";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RINGS);
        db.execSQL(CREATE_TABLE_SCHEDULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //write methods

    public void insertRingScheduleItem(SQLiteDatabase db, int number, long startTime, long endTime) {
        ContentValues cv = new ContentValues();
        cv.put(FIELD_NUMBER, number);
        cv.put(FIELD_START_TIME, startTime);
        cv.put(FIELD_END_TIME, endTime);
        long inserted = db.insert(TABLE_RINGS, null, cv);
        Log.d(LOG_TAG, "inserted in rings = " + inserted + ": " + number + ", " +
        startTime + ", " + endTime);
    }

    public void insertDayScheduleItem(SQLiteDatabase db, String name, String room, int number
            , int type) {
        ContentValues cv = new ContentValues();
        cv.put(FIELD_SUBJECT_NAME, name);
        cv.put(FIELD_ROOM, room);
        cv.put(FIELD_NUMBER, number);
        cv.put(FIELD_TYPE, type);
        long inserted = db.insert(TABLE_SCHEDULE, null, cv);
        Log.d(LOG_TAG, "inserted in schedule = " + inserted + ": " + name + ", " + room + ", " +
        number + ", " + type);
    }
}
