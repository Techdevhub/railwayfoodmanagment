package com.techdevhub.railwayproject;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BookPage extends AppCompatActivity {

    String str = null;
    String price = null;

    public int foodselection = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);


        //to change the page Dynamically
        this.getExtraData();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfer();
            }
        });


    }

    void transfer()
    {
        Intent intent = new Intent(this, FoodShow.class);
        intent.putExtra("price",price);
        startActivity(intent);
        finish();
    }

    private void getExtraData() {
        Bundle bun = getIntent().getExtras();
        str = bun.getString("selectionbox");
        foodselection = Integer.parseInt(str);
        //Toast t = Toast.makeText(getApplicationContext(),"Aman",Toast.LENGTH_SHORT);
        //t.show();
        switch (foodselection)
        {
            case 1:
                InfoOf1();
                break;

            case 2:
                InfoOf2();
                break;

            case 3:
                InfoOf3();
                break;

            case 4:
                InfoOf4();
                break;
        }

    }

    public void InfoOf1()
    {
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("This is the Food Contant:\n\n 1) Crud (Dahi)\n 2) Cottage cheese( Paneer)\n 3) Dal\n 4) Rice\n 5) Flore Tortilla (roti) \n\n" +
                getString(R.string.PriceOfRailway));
        price = "70";
    }

    public void InfoOf2()
    {
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("This is the Food Contant:\n\n 1) Crud (Dahi)\n 2) Cottage cheese( Paneer)\n 3) Dal\n 4) Rice\n 5) Flore Tortilla (roti)\n 4) Cabbage vegetable ( gobhi ) \n\n" +
                getString(R.string.PriceOfRailway1));
        price = "100";
    }

    public void InfoOf3()
    {
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("This is the Food Contant:\n\n 1) Meet\n 2) Potato( Aluu)\n 3) Dal\n 4) Rice\n 5) Flore Tortilla (roti) \n\n" +
                getString(R.string.PriceOfRailway2));
        price = "120";
    }

    public void InfoOf4()
    {
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("This is the Food Contant:\n\n 1) Salad\n 2) Cottage cheese( Paneer)\n 3) Dal\n 4) Rice\n 5) Flore Tortilla (roti) \n\n" +
                getString(R.string.PriceOfRailway3));
        price = "70";
    }
}
