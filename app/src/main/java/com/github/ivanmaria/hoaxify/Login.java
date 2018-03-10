package com.github.ivanmaria.hoaxify;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends AppCompatActivity {
EditText username,password;
Button loginBtn;
String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginbtn);
    }
    public void loginBtn(View v) {
        userLogin();
    }
    public void newUser(View v) {
        Intent in = new Intent(Login.this, Register.class);
        startActivity(in);
    }
    public void forgotPass(View v){
        Toast.makeText(this, "Not Implemented!", Toast.LENGTH_SHORT).show();
    }

    private void userLogin() {
        //first getting the values
        final String user = username.getText().toString();
        final String pass = password.getText().toString();

        //validating inputs
        if (user.equals("")) {
            username.setError("Please enter your username");
            username.requestFocus();
            return;
        }

        if (pass.equals("")) {
            password.setError("Please enter your password");
            password.requestFocus();
            return;
        }

        class UserLogin extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
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

                        int user_id = obj.getInt("userid");
                        String designation = obj.getString("designation");
                        String email = obj.getString("email");
                        String name = obj.getString("name");
                        String contact = obj.getString("contact");

                        SharedPrefManager.getInstance(getApplicationContext()).saveInt("user_id", user_id);
                        SharedPrefManager.getInstance(getApplicationContext()).saveString("designation", designation);
                        SharedPrefManager.getInstance(getApplicationContext()).saveString("email", email);
                        SharedPrefManager.getInstance(getApplicationContext()).saveString("name", name);
                        SharedPrefManager.getInstance(getApplicationContext()).saveString("contact", contact);

                        finish();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        //startActivity(new Intent(getApplicationContext(), HoaxActivity.class));
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
                params.put("username", user);
                params.put("password", pass);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
            }
        }
        UserLogin ul = new UserLogin();
        ul.execute();
    }
}
