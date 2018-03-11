package com.github.ivanmaria.hoaxify;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<HoaxList> hoaxList,hoaxmyList;
    ListView newHoax,myHoax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hoaxList = new ArrayList<>();
        newHoax = (ListView) findViewById(R.id.newhoax);

        hoaxmyList = new ArrayList<>();
        myHoax = (ListView) findViewById(R.id.myhoax);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("New Hoax");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("My Hoax");
        host.addTab(spec);
        int id = SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");

        loadHoax();
        loadMyHoax();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



    public void profileBtn(View v)
    {
        Intent in = new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(in);
    }

    public void fab(View v)
    {
        Intent in = new Intent(MainActivity.this,SearchActivity.class);
        startActivity(in);
    }














    private void loadHoax() {
        //first getting the values

        class loadHoax extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar3);
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

                        int no_hoax = obj.getInt("no_hoax");

                        String hoax_text;
                        int hoax_id;

                        for(int i=0;i<no_hoax;i++)
                        {
                            hoax_text=obj.getString("message_"+i);
                            hoax_id=obj.getInt("hoax_id_"+i);
                            hoaxList.add(new HoaxList(hoax_id, hoax_text));
                        }
                        HoaxListAdapter adapter = new HoaxListAdapter(getApplicationContext(), R.layout.hoax_list, hoaxList);
                        newHoax.setAdapter(adapter);

                            String date = obj.getString("date_time");
                            SharedPrefManager.getInstance(getApplicationContext()).saveString("date", date);



                        newHoax.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                                    long arg3) {
                                //here v is your ListItem's layout.
                                TextView tv = (TextView) v.findViewById(R.id.hoaxid);
                                //Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                                intent.putExtra("hoax_id", tv.getText().toString());
                                startActivity(intent);
                            }
                        });





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
                params.put("temp", "test");
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOAD_NEW_HOAX, params);
            }
        }
        loadHoax ul = new loadHoax();
        ul.execute();
    }




    private void loadMyHoax() {
        //first getting the values

        class loadMyHoax extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar4);
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

                        int no_hoax = obj.getInt("no_posts");

                        String hoax_text;
                        int hoax_id;

                        for(int i=0;i<no_hoax;i++)
                        {
                            hoax_text=obj.getString("message_"+i);
                            hoax_id=obj.getInt("hoax_id_"+i);
                            hoaxmyList.add(new HoaxList(hoax_id, hoax_text));
                        }
                        HoaxListAdapter adapter1 = new HoaxListAdapter(getApplicationContext(), R.layout.hoax_list, hoaxmyList);
                        myHoax.setAdapter(adapter1);

                        myHoax.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                                    long arg3) {
                                //here v is your ListItem's layout.
                                TextView tv = (TextView) v.findViewById(R.id.hoaxid);
                                //Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                                intent.putExtra("hoax_id", tv.getText().toString());
                                startActivity(intent);
                            }
                        });

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
                int id = SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                params.put("user_id", id+"");

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOAD_MY_HOAX, params);
            }
        }
        loadMyHoax ul = new loadMyHoax();
        ul.execute();
    }








}
