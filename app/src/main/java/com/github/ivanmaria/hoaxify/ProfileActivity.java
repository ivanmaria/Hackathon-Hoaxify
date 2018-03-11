package com.github.ivanmaria.hoaxify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    TextView name,designation, phone, email, forgotpass;
    String temp1,temp2;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.pname);
        designation=findViewById(R.id.pdesig);
        phone=findViewById(R.id.pphone);
        email=findViewById(R.id.pemail);
        forgotpass=findViewById(R.id.forgotpass);
        logout=findViewById(R.id.loginbtn);
        temp1 = name.getText().toString();
        temp2 = SharedPrefManager.getInstance(getApplicationContext()).getString("name");
        name.setText(temp1+temp2);

        temp1 = designation.getText().toString();
        temp2= SharedPrefManager.getInstance(getApplicationContext()).getString("designation");
        designation.setText(temp1+temp2);

        temp1 = phone.getText().toString();
        temp2= SharedPrefManager.getInstance(getApplicationContext()).getString("contact");
        phone.setText(temp1+temp2);

        temp1 = email.getText().toString();
        temp2= SharedPrefManager.getInstance(getApplicationContext()).getString("email");
        email.setText(temp1+temp2);
    }
    public void changePassword(View v){
        Toast.makeText(this, "Not Implemented!", Toast.LENGTH_SHORT).show();
    }
    public void Logout(View v){
        SharedPrefManager.getInstance(getApplicationContext()).logout();
        finish();
    }
}
