package com.github.ivanmaria.hoaxify;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SearchActivity extends AppCompatActivity {
EditText inputtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        inputtext=findViewById(R.id.inputtext);
    }
    public void searchBtn(View v){
      Search();
    }

    public void uploadImg(View v){
        Toast.makeText(this, "Not Implemented!", Toast.LENGTH_SHORT).show();
    }




    private void Search() {
        //first getting the values
        final String input = inputtext.getText().toString();

        //validating inputs
        if (input.equals("")) {
            inputtext.setError("Please enter your username");
            inputtext.requestFocus();
            return;
        }

        class Search extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar6);
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
                        String hoax_id = obj.getString("hoax_id");
                        Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                        intent.putExtra("hoax_id", hoax_id);
                        startActivity(intent);
                        //startActivity(new Intent(getApplicationContext(), HoaxActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        Create();
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
                params.put("text", input);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_SEARCH_TEXT, params);
            }
        }
        Search ul = new Search();
        ul.execute();
    }



    private void Create() {
        //first getting the values
        final String input = inputtext.getText().toString();

        //validating inputs
        if (input.equals("")) {
            inputtext.setError("Please enter your message");
            inputtext.requestFocus();
            return;
        }

        class Create extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar6);
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
                        String hoax_id = obj.getString("hoax_id");
                        Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                        intent.putExtra("hoax_id", hoax_id);
                        startActivity(intent);
                        //startActivity(new Intent(getApplicationContext(), HoaxActivity.class));
                    } else {
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
                params.put("text", input);
                int user_id = SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                params.put("user_id", user_id+"");
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_CREATE_HOAX, params);
            }
        }
        Create ul = new Create();
        ul.execute();
    }
}
