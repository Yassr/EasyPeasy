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
}
