package com.dev.yassr.easypeasy;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDBManager extends  SQLiteOpenHelper
{
    public static final String TAG = "DBHelper";
    // These are the names of the columns the table will contain
    public static final String DATABASE_TABLE = "Task";
    public static final String KEY_ROWID = "_id";
    public static final String KEY_TASK_NAME = "task_name";
    public static final String KEY_TASK_DESC = "task_desc";


    //Food Table
    public static final String DATABASE_TABLEFOOD = "Food";
    public static final String FOOD_ID = KEY_ROWID;
    public static final String FOOD_NAME = "food_name";
    public static final String FOOD_QUAN = "food_quan";
    public static final String FOOD_DESC = "food_desc";
    public static final String BOX_GLUTEN = "check_gluten";
    public static final String BOX_LACTOSE = "check_lactose";
    public static final String BOX_NUTS = "check_nuts";
    public static final String FOOD_TASK_ID ="task_id";

    private static final String DATABASE_NAME = "TaskList.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_FOOD_TABLE =
            "create table " + DATABASE_TABLEFOOD +
                    " (" + FOOD_ID + " integer primary key autoincrement, " +
                    FOOD_NAME + " text not null, " +
                    FOOD_DESC+ " text not null, " +
                    FOOD_QUAN+ " text not null, "+
                    BOX_GLUTEN+" integer not null, "+
                    BOX_LACTOSE+"   integer not null, "+
                    BOX_NUTS+" integer not null"+
                    FOOD_TASK_ID+" integer not null "+
                    " );";


    // This is the string containing the SQL database create statement
    private static final String DATABASE_CREATE =
            "create table " + DATABASE_TABLE +
                    " (" + KEY_ROWID + " integer primary key autoincrement, " +
                    KEY_TASK_NAME + " text not null, " +
                    KEY_TASK_DESC + " text not null " +
                    " );";

    public MyDBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_FOOD_TABLE);
        database.execSQL(DATABASE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to "+ newVersion);
        // clear all data
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLEFOOD);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

        // recreate the tables
        onCreate(db);
    }

    public MyDBManager(Context context, String name, CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

}