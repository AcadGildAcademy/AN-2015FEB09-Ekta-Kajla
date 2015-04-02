package com.example.eku.dry_ticket_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DELL on 01-04-2015.
 */
public class Venues extends ActionBarActivity {
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    V_ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList <HashMap<String, String>>arrayList;
    static String VENUE = "venue";
    static String IMAGE_PATH = "image_path";

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        new DownloadJSON().execute();
        getActionBar();

    }

    private class DownloadJSON extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... params) {
            arrayList =new ArrayList<HashMap<String, String>>();
            jsonObject = JSONfunctions.getJSONfromURL("http://bishasha.com/json/past_events.php");
            try
            {
                jsonArray= jsonObject.getJSONArray("events");
                for (int i = 0; i < jsonArray.length(); i++)
                {
                    HashMap<String, String> map = new HashMap<String, String>();
                   jsonObject = jsonArray.getJSONObject(i);
                    map.put("venue", jsonObject.getString("venue"));
                    map.put("image_path", jsonObject.getString("image_path"));
                    arrayList.add(map);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Venues.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Wait For Result");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }
        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml
           listView = (ListView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new V_ListViewAdapter(Venues.this, arrayList);
            // Set the adapter to the ListView
            listView.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }  @Override
       public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_file, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sign_in) {
            Intent intent = new Intent(Venues.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(Venues.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.option_menu1) {
            Intent intent = new Intent(Venues.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.option_menu2) {
            Intent intent = new Intent(Venues.this, UpcomingEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu3) {
            Intent intent = new Intent(Venues.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu4) {
            Intent intent = new Intent(Venues.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu5) {
            Intent intent = new Intent(Venues.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu6) {
            Intent intent = new Intent(Venues.this, PastEvents.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}




