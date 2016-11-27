/*
package com.dev.yassr.easypeasy;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class FoodDB {

    public static final String TAG = "FoodDB";

    private Context mContext;

    private SQLiteDatabase mDatabase;
    private MyDBManager mDbHelper;
    private String[] mAllColumns = { MyDBManager.FOOD_ID,
            MyDBManager.FOOD_NAME, MyDBManager.FOOD_DESC,
            MyDBManager.FOOD_QUAN, MyDBManager.BOX_GLUTEN,
            MyDBManager.BOX_LACTOSE, MyDBManager.BOX_NUTS
    };

    public FoodDB(Context context) {
        this.mContext = context;
        mDbHelper = new MyDBManager(context);
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public FoodItem createFood(String name, String desc, String quan, int glut, int lac, int nuts) {
        ContentValues values = new ContentValues();
        values.put(MyDBManager.FOOD_NAME, name);
        values.put(MyDBManager.FOOD_DESC, desc);
        values.put(MyDBManager.FOOD_QUAN, quan);
        values.put(MyDBManager.BOX_GLUTEN, glut);
        values.put(MyDBManager.BOX_LACTOSE, lac);
        values.put(MyDBManager.BOX_NUTS, nuts);

        long insertId = mDatabase
                .insert(MyDBManager.DATABASE_TABLEFOOD, null, values);
        Cursor cursor = mDatabase.query(MyDBManager.DATABASE_TABLEFOOD, mAllColumns,
                MyDBManager.FOOD_ID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        FoodItem newFood = cursorToFoods(cursor);
        cursor.close();
        return newFood;
    }



    public void deleteFood(Food food) {
        long id = task.getId();
        // delete all employees of this company
        System.out.println("the deleted Task has the id: " + id);
        mDatabase.delete(MyDBManager.DATABASE_TABLEFOOD, MyDBManager.FOOD_ID
                + " = " + id, null);
    }

    public List<FoodItem> getAllCompanies() {
        List<Task> listTasks = new ArrayList<Task>();

        Cursor cursor = mDatabase.query(MyDBManager.DATABASE_TABLE, mAllColumns,
                null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Task task = cursorToFoods(cursor);
                listTasks.add(task);
                cursor.moveToNext();
            }

            // make sure to close the cursor
            cursor.close();
        }
        return listTasks;
    }

    public Task getTaskById(long id) {
        Cursor cursor = mDatabase.query(MyDBManager.DATABASE_TABLE, mAllColumns,
                MyDBManager.KEY_ROWID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Task task = cursorToFoods(cursor);
        return task;
    }



    protected Task cursorToFoods(Cursor cursor) {
        Task task = new Task();
        task.setId(cursor.getLong(0));
        task.setName(cursor.getString(1));
        task.setDesc(cursor.getString(2));
        return task;
    }
}
*/
