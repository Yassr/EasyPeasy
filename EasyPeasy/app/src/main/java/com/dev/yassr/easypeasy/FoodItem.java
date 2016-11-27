package com.dev.yassr.easypeasy;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.TextView;
        import android.widget.Toast;


public class FoodItem extends AppCompatActivity {
    public static String pos;
    public static int Gcheck = 0;
    public static int Lcheck;
    public static int Ncheck;

    private CheckBox gbox;
    private CheckBox lbox;
    private CheckBox nbox;
    private Button  addfood;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        TextView txtView = (TextView) findViewById(R.id.ItemName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pos = extras.getString("listPosition");
            txtView.setText(pos);
        }
        addListnerOnButton();

    }

    public void addListnerOnButton(){

        gbox = (CheckBox) findViewById(R.id.Gbox);
        lbox = (CheckBox) findViewById(R.id.Lbox);
        nbox = (CheckBox) findViewById(R.id.Nbox);
        addfood = (Button) findViewById(R.id.addFood);

        addfood.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        StringBuffer result = new StringBuffer();
                        result.append("Gluten ").append(gbox.isChecked());
                        result.append("\nLactose ").append(lbox.isChecked());
                        result.append("\nNuts ").append(nbox.isChecked());

                        Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );


    }



}
