package com.example.chat_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText txtname,txtpass;
Button but;
DatabaseReference reff;
FirebaseDatabase mfirebase;
Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname = (EditText)findViewById(R.id.uname);
        txtpass = (EditText)findViewById(R.id.pass);
        but = (Button)findViewById(R.id.btn);
        user = new Users();
        reff = mfirebase.getInstance().getReference().child("Users");
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUsername(txtname.getText().toString().trim());
                user.setPassword(txtpass.getText().toString().trim());
                if (txtname.length() > 0 && txtpass.length() > 10){
                           String docid =reff.push().getKey();
                            reff.setValue(user);
                    Toast.makeText(MainActivity.this,"The data has been stored",Toast.LENGTH_LONG).show();
                    openactivity();
                }
                else{
                    Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void openactivity(){
        Intent i  = new Intent(this,signup.class);
        startActivity(i);
    }
}
