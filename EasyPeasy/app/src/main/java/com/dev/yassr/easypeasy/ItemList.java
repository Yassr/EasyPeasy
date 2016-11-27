package com.dev.yassr.easypeasy;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ItemList extends AppCompatActivity
{
    Intent showListIntent, updatename;
    MyDBManager db;
    Cursor mCursor;
    public static Long pos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_screen);
        db = new MyDBManager(this);
        try {
            db.open();
            mCursor = db.getAllTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }

       Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pos = extras.getLong("listPosition");
           // Toast.makeText(getApplicationContext(), "Name Choosen : " + pos, Toast.LENGTH_SHORT).show();

        }


    }

    public void AddFoodClick(View v) {
        Intent intent = new Intent(getApplicationContext(),foodActivity.class);

        startActivity(intent); }

    public void updateName(View v){
        updatename= new Intent(this, update_activity.class);
        updatename.putExtra("listPosition", pos);
        startActivity(updatename);


    }

    public void deleteclick(View v){

        boolean bool = db.deleteTask(pos);
        if (bool){

            Toast.makeText(getApplicationContext(), "Deleted " + pos, Toast.LENGTH_SHORT).show();
            showListIntent = new Intent(this, MainScreen.class);
            startActivity(showListIntent);
        }else{
            Toast.makeText(getApplicationContext(), "Couldnt Delete " + pos, Toast.LENGTH_SHORT).show();
        }

    }
    public void homebuttclick(View v){

        finish();
    }


}
