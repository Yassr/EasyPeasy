package com.dev.yassr.easypeasy;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_activity extends AppCompatActivity {

    MyDBManager db;
    EditText edit1, edit2;
    Intent showListIntent;
    Button btnAdd, btnShowList;
    public static Long pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edit1 = (EditText) findViewById(R.id.newname);
        edit2 = (EditText) findViewById(R.id.newdesc);

        showListIntent = new Intent(this, MainScreen.class);

        btnAdd = (Button) findViewById(R.id.addRow);
        btnShowList = (Button) findViewById(R.id.showTasks);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pos = extras.getLong("listPosition");
            Toast.makeText(getApplicationContext(), "Name Choosen : " + pos, Toast.LENGTH_SHORT).show();

        }

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


                        String row1 = edit1.getText().toString();
                        String row2 = edit2.getText().toString();

                        db.updateTask(pos,row1, row2);
                        edit1.setText("");
                        edit2.setText("");

                    }
                }
        );

        btnShowList.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(showListIntent);
                    }
                }
        );

    }


}

