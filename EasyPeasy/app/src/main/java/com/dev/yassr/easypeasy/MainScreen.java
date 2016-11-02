package com.dev.yassr.easypeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {
    String[] Country = new String[]{"Poland", "Uganda", "Tuvalu", "Morocco",
            "Greece", "Luxembourg", "Norway", "Ireland", "Syria"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ArrayAdapter<String> cAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Country);

        final ListView LView = (ListView) findViewById(R.id.list);
        LView.setAdapter(cAdapter);


        //TOAST MESSAGE

        LView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object o = LView.getItemAtPosition(position);
                        Intent intent = new Intent(getApplicationContext(), ItemList.class);
                        startActivity(intent);


                    /*
                        String selection = o.toString();
                        Toast.makeText(getApplicationContext(), "Country Choosen : " + selection, Toast.LENGTH_LONG).show();
                    */
                    }

                }
        );

    }


}
