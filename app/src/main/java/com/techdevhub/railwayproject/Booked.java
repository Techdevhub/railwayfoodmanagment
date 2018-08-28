package com.techdevhub.railwayproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booked extends AppCompatActivity {

    private DatabaseReference databaseReference;

    private FirebaseAuth firebaseAuth;

    private String str1,str2,str3,str4,str5;

    private boolean info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);

        firebaseAuth= FirebaseAuth.getInstance();

        // Write a message to the database
         databaseReference = FirebaseDatabase.getInstance().getReference();

        saveTheData();

        TextView tv = (TextView) findViewById(R.id.textView12);
        tv.setText("\n\n\n\nCongrets\n\n Your Booking Done\n");


    }

    private void saveTheData() {
        str1="str1";
        str2="str1";
        str3="str1";
        str4="str1";
        str5="str1";

        userInformation ulcering = new userInformation(str1,str2,str3,str4,str5);

        FirebaseUser unseat = firebaseAuth.getCurrentUser();

        if(unseat != null)
        info = databaseReference.child((unseat.getUid())).setValue(ulcering).isComplete();
        databaseReference.push();

        Toast.makeText(getApplicationContext(), "info = "+ info , Toast.LENGTH_SHORT).show();

    }
}