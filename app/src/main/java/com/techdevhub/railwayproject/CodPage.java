package com.techdevhub.railwayproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class CodPage extends AppCompatActivity {

    private AutoCompleteTextView mTrainView;
    private AutoCompleteTextView mCoachView;
    private AutoCompleteTextView mseatNumView;

    boolean cancel;
    View focusView = null;
    String Paymode = null;
    String price = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_page);

        mTrainView = (AutoCompleteTextView) findViewById(R.id.trainNum);
        mCoachView = (AutoCompleteTextView) findViewById(R.id.coachNum);
        mseatNumView = (AutoCompleteTextView) findViewById(R.id.seatNum);

        Bundle bundle =  getIntent().getExtras();
        Paymode = bundle.getString("mode");
        price = bundle.getString("price");

        Button btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfer();
            }
        });
    }

    void transfer()
    {
        if(!isTrainNumValid(mTrainView.getText().toString()))
        {
            mTrainView.setError(getString(R.string.error_Valid_Number_Train));
            focusView = mTrainView;
            cancel = true;
        }
        else if (!iscoachNumValid(mCoachView.getText().toString()))
        {
            mCoachView.setError(getString(R.string.error_Valid_Detail));
            focusView = mCoachView;
            cancel = true;
        }
        else if (!isSeatNumValid(mseatNumView.getText().toString()))
        {
            mseatNumView.setError(getString(R.string.error_Valid_Detail));
            focusView = mseatNumView;
            cancel = true;
        }
        else
        {
            Intent intent = new Intent(this, ConfirmationPage.class);
            intent.putExtra("train", mTrainView.getText().toString());
            intent.putExtra("coach", mCoachView.getText().toString());
            intent.putExtra("seat", mseatNumView.getText().toString());
            intent.putExtra("payMode", Paymode);
            intent.putExtra("pay", price);
            startActivity(intent);
            finish();
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
    }

    private boolean isTrainNumValid(String Variable) {
        if(Variable.length() >3 && Variable.length() <6)
        {
            return true;
        }
        return false;
    }

    private boolean iscoachNumValid(String Variable) {
        if(Variable.length() == 2 || Variable.length() == 3)
        {
            return true;
        }
        return false;
    }

    private boolean isSeatNumValid(String Variable) {
        if(Variable.length() == 1 || Variable.length() == 2)
        {
            return true;
        }
        return false;
    }
}
