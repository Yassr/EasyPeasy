package com.dev.yassr.easypeasy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class foodActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Foods, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


       /* Resources res = getResources();
        String[] Veg = res.getStringArray(R.array.Vegetables);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Veg);
        final ListView listView = (ListView) findViewById(R.id.foodlist);
        listView.setAdapter(adapter2);*/

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

       // Toast.makeText(getApplicationContext(), "Cool one " + parent.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
        /*if (parent.getItemAtPosition(pos) == Vegetables){
            */
        Toast.makeText(getApplicationContext(), "SUPER DUPER " + parent.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();


       switch(parent.getItemAtPosition(pos).toString()) {
           case "Vegetables": {
               Resources res = getResources();
               final String[] Veg = res.getStringArray(R.array.Vegetables);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Veg);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);

               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);

                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );

                       startActivity(intent);

                   }
               });
               break;
           }
           case "Condiments": {
               Resources res = getResources();
               String[] Cond = res.getStringArray(R.array.Condiments);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Cond);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;

           }
           case "Dairy": {

               Resources res = getResources();
               String[] Dairy = res.getStringArray(R.array.Dairy);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Dairy);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;
           }
           case "Baked goods": {

               Resources res = getResources();
               String[] Bake = res.getStringArray(R.array.BakedGoods);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Bake);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;
           }
           case "Fresh fruits": {
               Resources res = getResources();
               String[] Fruit = res.getStringArray(R.array.Fresh_fruits);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Fruit);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;

           }
           case "Various groceries": {
               Resources res = getResources();
               String[] Groc = res.getStringArray(R.array.Various_groceries);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Groc);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;
           }
           case "Meat": {
               Resources res = getResources();
               String[] Meat = res.getStringArray(R.array.Meat);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Meat);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;
           }
           case "Snacks": {
               Resources res = getResources();
               String[] Snacks = res.getStringArray(R.array.Snacks);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Snacks);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;
           }
           case "Cheese": {
               Resources res = getResources();
               String[] Cheese = res.getStringArray(R.array.Cheese);
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Cheese);
               final ListView listView = (ListView) findViewById(R.id.foodlist);
               listView.setAdapter(adapter2);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       Intent intent = new Intent(getApplicationContext(), FoodItem.class);
                       intent.putExtra("listPosition",parent.getItemAtPosition(position).toString() );
                       startActivity(intent);

                   }
               });
               break;


           }
           // An item was selected. You can retrieve the selected item using
           // parent.getItemAtPosition(pos)
       }


    }




    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



}
