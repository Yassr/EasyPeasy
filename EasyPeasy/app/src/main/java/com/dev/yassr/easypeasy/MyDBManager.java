package com.dev.yassr.easypeasy;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDBManager
{
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


    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    // constructor for your class
    public MyDBManager(Context ctx) {
        // Context is a way that Android transfers info about Activities and apps.
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);

    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        // constructor for your dB helper class. This code is standard. You’ve set up the parameter values for the constructor already...database name,etc
        DatabaseHelper(Context context) {
            // This is the helper class that will create the dB if it doesn’t exist and upgrades it if
            // the structure has changed. It needs a constructor, an onCreate() method and an onUpgrade() method
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            // The “Database_create” string below needs to contain the SQL statement needed to create the dB
            db.execSQL(DATABASE_CREATE);
            // db.execSQL(DATABASE_CREATE2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }



    // If you want to change the structure of your database, e.g. Add a new column to a table,
    // the code will go head..
    //This method only triggers if the database version number has increased
    // from here on, include whatever methods will be used to access or change data in the database
    //---opens the database--- any activity that uses the dB will need to do this


    public MyDBManager open()
    {

        try{
            db = DBHelper.getWritableDatabase();
        }catch(SQLException e) {
            Log.e("error", "Failed to open database: " + e);
        }

        return this;
    }


    //---closes the database--- any activity that uses the dB will need to do this
    public void close()
    {
        DBHelper.close();
    }


    //---insert a Task into the database---
    public long insertTask(String taskName, String taskDesc) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TASK_NAME, taskName);
        initialValues.put(KEY_TASK_DESC, taskDesc);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    public long insertFood(String foodName, String foodQuan, String foodDesc, int glut, int lac, int nuts) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(FOOD_NAME, foodName);
        initialValues.put(FOOD_QUAN, foodQuan);
        initialValues.put(FOOD_DESC, foodQuan);
        initialValues.put(BOX_GLUTEN, glut);
        initialValues.put(BOX_LACTOSE, lac);
        initialValues.put(BOX_NUTS, nuts);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }




    public boolean deleteTask(long rowId) {
        // delete statement. If any rows deleted (i.e. >0), returns true

        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;

    }


    public Cursor getAllTasks()
    {
        Cursor mCursor = null;

        try{
            mCursor = db.query(DATABASE_TABLE, new String[]
                            {
                                    KEY_ROWID,
                                    KEY_TASK_NAME,
                                    KEY_TASK_DESC
                            },
                    null, null, null, null, null);

        }catch (SQLException e){
            Log.e("error", "Failed to get all tasks: " + e);
        }

        return mCursor;
    }


    public Cursor getAllCompletedTasks()
    {

        Cursor mCursor = null;

        try{

            mCursor = db.query(DATABASE_TABLE, new String[]
                            {
                                    KEY_ROWID,
                                    KEY_TASK_NAME,
                                    KEY_TASK_DESC
                            },
                    null, null, null, null, null);

        }catch (SQLException e){
            Log.e("error", "Failed to get completed tasks: " + e);
        }

        return mCursor;
    }


    public Cursor getTask(long rowId) {

        Cursor mCursor = null;

        try{
            mCursor =
                    db.query(true, DATABASE_TABLE, new String[]{
                                    KEY_ROWID,
                                    KEY_TASK_NAME,
                                    KEY_TASK_DESC
                            },
                            KEY_ROWID + "=" + rowId,
                            null,
                            null,
                            null,
                            null,
                            null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }

        }catch (SQLException e){
            Log.e("error", "Failed to get task: " + e);
        }

        return mCursor;
    }


    public boolean updateTask(long rowId, String taskName, String taskDesc)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_TASK_NAME, taskName);
        args.put(KEY_TASK_DESC, taskDesc);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}