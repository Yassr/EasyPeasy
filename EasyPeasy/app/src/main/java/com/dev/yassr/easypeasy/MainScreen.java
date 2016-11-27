package com.dev.yassr.easypeasy;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainScreen extends ListActivity {

    String[] columns = {"task_name", "task_desc"};
    int[] to = {R.id.task_name, R.id.task_desc};
    Cursor mCursor;
    MyDBManager db;
    Intent listItemIntent;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        db = new MyDBManager(this);

        try {
            db.open();
            mCursor = db.getAllTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.row, mCursor, columns, to);

        setListAdapter(mAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

//        String selectedFromList =(String) (l.getItemAtPosition(position));

        Intent intent = new Intent(getApplicationContext(), ItemList.class);
        intent.putExtra("listPosition", id);
       // Toast.makeText(getApplicationContext(), "List id : " + id, Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
    public void mapbutton(View v) {
        Intent intent = new Intent(getApplicationContext(), GroceryMaps.class);

        startActivity(intent); }

    public void newlistpage(View v){
        Intent intent = new Intent(getApplicationContext(), ListInput.class);
        startActivity(intent);
    }

}


