package com.github.ivanmaria.hoaxify;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Register extends AppCompatActivity {
EditText name,designation,contact,email,password;
TextView olduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        designation=findViewById(R.id.designation);
        contact=findViewById(R.id.contact);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        olduser=findViewById(R.id.olduser);
    }
    public void oldUser(View v) {
        Intent in = new Intent(Register.this, Login.class);
        startActivity(in);
    }
    public void registerBtn(View v) {
        registerUser();
    }








    private void registerUser() {
        //first getting the values
        final String name1 = name.getText().toString();
        final String designation1 = designation.getText().toString();
        final String contact1 = contact.getText().toString();
        final String email1 = email.getText().toString();
        final String password1 = password.getText().toString();

        //validating inputs
        if (name1.equals("")) {
            name.setError("Please enter your name");
            name.requestFocus();
            return;
        }
        if (designation1.equals("")) {
            designation.setError("Please enter your designation");
            designation.requestFocus();
            return;
        }
        if (contact1.equals("")) {
            contact.setError("Please enter your contact number");
            contact.requestFocus();
            return;
        }
        if (email1.equals("")) {
            email.setError("Please enter your email");
            email.requestFocus();
            return;
        }
        if (password1.equals("")) {
            password.setError("Please enter your password");
            password.requestFocus();
            return;
        }

        class registerUser extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar2);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressBar.setVisibility(View.GONE);


                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
                    //if no error in response
                    if (obj.getBoolean("status")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(), Login.class));
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("name", name1);
                params.put("designation", designation1);
                params.put("email", email1);
                params.put("contact", contact1);
                params.put("password", password1);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_REGISTER, params);
            }
        }
        registerUser ru = new registerUser();
        ru.execute();
    }










}
