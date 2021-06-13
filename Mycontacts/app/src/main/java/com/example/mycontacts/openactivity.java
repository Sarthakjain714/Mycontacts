package com.example.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class openactivity extends Activity {
    TextView numberofcontact, nameofcontact;
    ImageView callkro;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailspage);
        Intent i = getIntent();

        String contactname = i.getStringExtra("contactname");
        String phonenumber = i.getStringExtra("phonenumber");


        callkro=findViewById(R.id.call);
        numberofcontact= findViewById(R.id.numberofcontact);
        nameofcontact = findViewById(R.id.nameofcontact);
        nameofcontact.setText(contactname);
        numberofcontact.setText(phonenumber);
        callkro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to call a person
                String telephonenumber = numberofcontact.getText().toString();
                String s = "tel:" + telephonenumber;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(s));
                startActivity(intent);
            }
        });

    }
}
