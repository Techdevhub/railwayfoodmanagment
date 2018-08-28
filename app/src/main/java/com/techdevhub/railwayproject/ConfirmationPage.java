package com.techdevhub.railwayproject;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class ConfirmationPage extends AppCompatActivity {

    Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        TextView tv1 = (TextView) findViewById(R.id.textView7);
        TextView tv2 = (TextView) findViewById(R.id.textView8);
        TextView tv3= (TextView) findViewById(R.id.textView9);
        TextView tv4 = (TextView) findViewById(R.id.textView10);
        TextView tv5 = (TextView) findViewById(R.id.textView11);

        bundle = getIntent().getExtras();
        tv1.setText("Train Number :- " + bundle.getString("train"));
        tv2.setText("Coach Number :- " + bundle.getString("coach"));
        tv3.setText("Seat Number :- " + bundle.getString("seat"));
        tv4.setText("Payment Mode :- " + bundle.getString("payMode"));
        tv5.setText("Pay :-          " + bundle.getString("pay"));

        Button btn = (Button) findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                nextpage();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void nextpage()
    {
        if(Objects.equals(bundle.getString("payMode"), "COD"))
        {
            Intent intent = new Intent(this, Booked.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(this, PaytmPay.class);
            startActivity(intent);
            finish();
        }
    }
}
