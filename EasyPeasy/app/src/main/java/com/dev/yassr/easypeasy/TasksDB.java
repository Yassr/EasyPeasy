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

import com.google.android.gms.tasks.Task;

public class TasksDB {

    public static final String TAG = "TasksDB";

    // Database fields
    private SQLiteDatabase mDatabase;
    private MyDBManager mDbHelper;
    private Context mContext;
    private String[] mAllColumns = { MyDBManager.KEY_ROWID,
            MyDBManager.KEY_TASK_NAME, MyDBManager.KEY_TASK_DESC
    };

    public TasksDB(Context context) {
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

    public Task createTask(String name, String desc) {
        ContentValues values = new ContentValues();
        values.put(MyDBManager.KEY_TASK_NAME, name);
        values.put(MyDBManager.KEY_TASK_DESC, desc);

        long insertId = mDatabase
                .insert(MyDBManager.DATABASE_TABLE, null, values);
        Cursor cursor = mDatabase.query(MyDBManager.DATABASE_TABLE, mAllColumns,
                MyDBManager.KEY_ROWID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        Task newTask = cursorToTasks(cursor);
        cursor.close();
        return newTask;
    }



    public void deleteCompany(Task task) {
        long id = task.getId();
        // delete all employees of this company
        FoodDB foodDB = new FoodDB(mContext);
        List<Food> listEmployees = foodDB.getFoodsOfTasks(id);
        if (listEmployees != null && !listEmployees.isEmpty()) {
            for (Food e : listEmployees) {
                foodDB.deleteFood(e);
            }
        }

        System.out.println("the deleted Task has the id: " + id);
        mDatabase.delete(MyDBManager.DATABASE_TABLE, MyDBManager.KEY_ROWID
                + " = " + id, null);
    }

    public List<Task> getAllCompanies() {
        List<Task> listTasks = new ArrayList<Task>();

        Cursor cursor = mDatabase.query(MyDBManager.DATABASE_TABLE, mAllColumns,
                null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Task task = cursorToTasks(cursor);
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

        Task task = cursorToTasks(cursor);
        return task;
    }



    protected Task cursorToTasks(Cursor cursor) {
        Task task = new Task();
        task.setId(cursor.getLong(0));
        task.setName(cursor.getString(1));
        task.setDesc(cursor.getString(2));
        return task;
    }

}
*/
