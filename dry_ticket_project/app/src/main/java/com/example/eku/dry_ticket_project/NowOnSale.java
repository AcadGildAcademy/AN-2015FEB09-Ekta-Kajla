package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 21-03-2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class NowOnSale extends Activity {
    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String DESC = "desc";
    static String DATE = "date";
    static String TIME = "time";
    static String PRICE = "price";
    static String VENUE = "venue";
    static String IMAGE_PATH = "image_path";
    static String DETAIL = "detail";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);
        // Execute DownloadJSON AsyncTask
        new DownloadJSON().execute();
    }

    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(NowOnSale.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Android JSON Parse");
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
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://bishasha.com/json/events.php");

            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("events");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("desc", jsonobject.getString("desc"));
                    map.put("date", jsonobject.getString("date"));
                    map.put("time", jsonobject.getString("time"));
                    map.put("price", jsonobject.getString("price"));
                    map.put("venue", jsonobject.getString("venue"));
                    map.put("image_path", jsonobject.getString("image_path"));
                    map.put("detail", jsonobject.getString("detail"));
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
}