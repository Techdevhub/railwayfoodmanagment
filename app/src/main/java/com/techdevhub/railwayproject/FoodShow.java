package com.techdevhub.railwayproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FoodShow extends AppCompatActivity {

    int price = 0;
    String str = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_show);

        //update the textView3 with price
        Bundle bundle = getIntent().getExtras();
        str = bundle.getString("price");
        price = Integer.parseInt(str);

        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setText("You Have to Pay = " + price);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codtran();
            }
        });

        Button btn1 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paytmtran();
            }
        });

    }

    void codtran()
    {
        Intent intent = new Intent(this, CodPage.class);
        intent.putExtra("mode","COD");
        intent.putExtra("price",str);
        startActivity(intent);
        finish();
    }


    void Paytmtran()
    {
        Intent intent = new Intent(this, CodPage.class);
        intent.putExtra("mode","Paytm");
        intent.putExtra("price",str);
        startActivity(intent);
        finish();
    }
}
