package com.dev.yassr.easypeasy;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ListInput extends Activity {

    MyDBManager db;
    EditText et1, et2;
    Intent showListIntent;
    Button btnAdd, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        et1 = (EditText) findViewById(R.id.taskName);
        et2 = (EditText) findViewById(R.id.taskDesc);


        showListIntent = new Intent(this, MainScreen.class);

        btnAdd = (Button) findViewById(R.id.addRow);
        btnShowList = (Button) findViewById(R.id.showTasks);

        db = new MyDBManager(this);
        try {
            db.open();
        } catch (Exception e) {
            e.printStackTrace();
        }


        btnAdd.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String row1 = et1.getText().toString();
                        String row2 = et2.getText().toString();

                        db.insertTask(row1, row2);

                        et1.setText("");
                        et2.setText("");

                    }
                }
        );

        btnShowList.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(showListIntent);


                    }
                }
        );

    }


}