package com.example.eku.dry_ticket_project.activity;

/**
 * Created by DELL on 21-03-2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.eku.dry_ticket_project.utils.JSONfunctions;
import com.example.eku.dry_ticket_project.adapter.ListViewAdapter;
import com.example.eku.dry_ticket_project.R;

public class NowOnSale extends FragmentActivity {
    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
   public static String ID = "id";
    public static String DESC = "desc";
    public static String DATE = "date";
    public static String TIME = "time";
    public static String PRICE = "price";
    public static String VENUE = "venue";
    public static String IMAGE_PATH = "image_path";
    public static String TITLE = "title";
    public String url_string;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);
        // Execute DownloadJSON AsyncTask
        // Intent i=getIntent();
        // url_string=i.getStringExtra("url");
        new DownloadJSON().execute();
        getActionBar();
    }

    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(NowOnSale.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Wait For Result");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            //   ServiceHandler sh=new ServiceHandler();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://bishasha.com/json/now_on_sale_events.php");
            Log.d("object-->", "" + jsonobject);
            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("events");
                Log.d("array-->", "" + jsonarray);
                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();

                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    Log.d("object 2-->", "" + jsonobject);

                    map.put("id", jsonobject.getString("id"));
                    map.put("desc", jsonobject.getString("desc"));
                    map.put("date", jsonobject.getString("date"));
                    map.put("time", jsonobject.getString("time"));
                    map.put("price", jsonobject.getString("price"));
                    map.put("venue", jsonobject.getString("venue"));
                    map.put("image_path", jsonobject.getString("image_path"));
                    map.put("title", jsonobject.getString("title"));
                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(NowOnSale.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_file, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sign_in) {
            Intent intent = new Intent(NowOnSale.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(NowOnSale.this, sign_up.class);
            startActivity(intent);

            return true;
        } else if (id == R.id.option_menu1) {
            Intent intent = new Intent(NowOnSale.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.option_menu2) {
            Intent intent = new Intent(NowOnSale.this, UpcomingEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/upcoming_events.php");
            startActivity(intent);

        } else if (id == R.id.option_menu3) {
            Intent intent = new Intent(NowOnSale.this, PastEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/past_events.php");
            startActivity(intent);

        } else if (id == R.id.option_menu4) {
            Intent intent = new Intent(NowOnSale.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu5) {
            Intent intent = new Intent(NowOnSale.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu6) {
            Intent intent = new Intent(NowOnSale.this, Venue.class);
            startActivity(intent);

        } else if (id == R.id.option_menu7) {
            Intent intent = new Intent(NowOnSale.this, ContactUs.class);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }

}