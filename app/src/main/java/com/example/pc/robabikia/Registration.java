package com.example.pc.robabikia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.robabikia.utils.Constants;
import com.example.pc.robabikia.utils.StoreManger;

public class Registration extends AppCompatActivity {

    EditText editText;
    Button  button;
    String refEmail;
    String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editText= (EditText) findViewById(R.id.Login_Email);
        editText.setText(StoreManger.getSharedpref(this,refEmail,""));
        button= (Button) findViewById(R.id.Login_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email=editText.getText().toString();
                StoreManger.saveSharedpref(Registration.this,refEmail,Email);
                Intent intent=new Intent(Registration.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }



}
