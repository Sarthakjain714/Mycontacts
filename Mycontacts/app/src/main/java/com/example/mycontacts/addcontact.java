package com.example.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import com.example.mycontacts.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addcontact extends Activity {

//    private ActivityMainBinding binding;
    private  static final String TAG = "CONTACT_TAG";
    private static final int WRITE_CONTACT_PERMISSION_CODE =100;
    FloatingActionButton savecontact;
    EditText firstname, lastname, phonenumber;
//    private String[] contactPermissions;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.addcontact);
        savecontact = findViewById(R.id.savecontact);

        firstname = findViewById(R.id.firstname);
        lastname= findViewById(R.id.lastname);
        phonenumber= findViewById(R.id.add_phoneno);
        String phelanaam = firstname.getText().toString();
        String aakhrinaam = lastname.getText().toString();
        String telephonenumber = phonenumber.getText().toString();
        savecontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
                contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                contactIntent
                        .putExtra(ContactsContract.Intents.Insert.NAME, phelanaam+aakhrinaam)
                        .putExtra(ContactsContract.Intents.Insert.PHONE, telephonenumber);

                startActivityForResult(contactIntent, 1);

            }
        });

    }
}
