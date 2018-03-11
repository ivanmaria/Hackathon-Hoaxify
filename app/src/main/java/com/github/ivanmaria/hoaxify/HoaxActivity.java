package com.github.ivanmaria.hoaxify;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by IsaacIvan on 10-03-2018.
 */
public class HoaxActivity extends AppCompatActivity {ArrayList<CommentData> dataModels;
    ListView commentList;
    String id;
    EditText typeComment;
    Button real,fake,flagpost;
    private static CommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoax);

       id = getIntent().getStringExtra("hoax_id");
        real=findViewById(R.id.real);
        fake=findViewById(R.id.fake);
        flagpost=findViewById(R.id.flagpost);
        commentList=(ListView)findViewById(R.id.commentList);

        Hoax();

    }
    public void real(View v){
        upvote();
    }
    public void fake(View v){
        downvote();
    }
    public void flagpost(View v){
        flag();
    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + 20 + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public void sendComment(View v){
        insertComment();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent in = new Intent(HoaxActivity.this,MainActivity.class);
        startActivity(in);
        finish();
    }

    private void Hoax() {

        class Hoax extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar5);
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
                        TextView hoaxtext = findViewById(R.id.hoaxtext);
                        TextView hoaxfeeling = findViewById(R.id.hoaxfeeling);
                        TextView hoaxcomment = findViewById(R.id.hoaxcomment);
                        hoaxtext.setText(obj.getString("text"));
                        hoaxfeeling.setText(obj.getString("num_vote"));
                        if(obj.getInt("vote")==1)
                        {
                            real.setTextColor(Color.BLUE);
                        }
                        else if(obj.getInt("vote")==2)
                        {
                            fake.setTextColor(Color.RED);
                        }

                        if(obj.getInt("flag")==1)
                        {
                            flagpost.setTextColor(Color.RED);
                        }

                        int temp = obj.getInt("num_comment");
                        hoaxcomment.setText(temp+"");
                        dataModels= new ArrayList<>();
                        for(int i=0; i<temp;i++) {
                            dataModels.add(new CommentData(obj.getString("name_"+i), obj.getString("designation_"+i), obj.getString("comment_"+i), obj.getString("num_vote_"+i),obj.getInt("commentid_"+i)));
                        }


                        adapter= new CommentAdapter(dataModels,getApplicationContext());

                        commentList.setAdapter(adapter);
                        setListViewHeightBasedOnChildren(commentList);

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
                int userid=SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("hoax_id", id);
                params.put("user_id", userid+"");

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_HOAX, params);
            }
        }
        Hoax ul = new Hoax();
        ul.execute();
    }




    private void insertComment() {
        typeComment = findViewById(R.id.typecomment);
        final String message = typeComment.getText().toString();
        if (message.equals("")) {
            typeComment.setError("Please enter your username");
            typeComment.requestFocus();
            return;
        }

        class insertComment extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar5);
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

                        Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                        intent.putExtra("hoax_id", id);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();
                int userid=SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("hoax_id", id);
                params.put("user_id", userid+"");
                params.put("comment", message);
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_INSERT_COMMENT, params);
            }
        }
        insertComment ul = new insertComment();
        ul.execute();
    }








    private void downvote() {

        class downvote extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar5);
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
                        Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                        intent.putExtra("hoax_id", id);
                        startActivity(intent);
                        finish();

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
                int userid=SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("hoax_id", id);
                params.put("user_id", userid+"");

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_HOAX_DOWNVOTE, params);
            }
        }
        downvote ul = new downvote();
        ul.execute();
    }





    private void flag() {

        class flag extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar5);
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
                        Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                        intent.putExtra("hoax_id", id);
                        startActivity(intent);
                        finish();

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
                int userid=SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("hoax_id", id);
                params.put("user_id", userid+"");

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_HOAX_FLAG, params);
            }
        }
        flag ul = new flag();
        ul.execute();
    }



    private void upvote() {

        class upvote extends AsyncTask<Void, Void, String> {

            ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBar5);
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
                        Intent intent = new Intent(getApplicationContext(), HoaxActivity.class);
                        intent.putExtra("hoax_id", id);
                        startActivity(intent);
                        finish();

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
                int userid=SharedPrefManager.getInstance(getApplicationContext()).getInt("user_id");
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("hoax_id", id);
                params.put("user_id", userid+"");

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_HOAX_UPVOTE, params);
            }
        }
        upvote ul = new upvote();
        ul.execute();
    }

}
