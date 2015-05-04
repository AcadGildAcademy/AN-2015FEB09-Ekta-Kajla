package com.example.eku.dry_ticket_project.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.utils.JSONfunctions;
import com.example.eku.dry_ticket_project.adapter.ListViewAdapter_tickets;
import com.example.eku.dry_ticket_project.R;
import com.example.eku.dry_ticket_project.utils.ServiceHandler;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DELL on 10-04-2015.
 */
public class Ticket_Booking extends ActionBarActivity {
    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter_tickets adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    public static String ID = "id";
    public static String TYPE_CATEGORY = "type_category";
    public static String PRICE = "price";
    public static String EVENT_ID = "event_id";
    public static String EVENT_NAME = "event_name";
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_listview);
        Intent intent=getIntent();
        id=intent.getStringExtra("event_id");
        Toast.makeText(getApplication(),"eveid"+id,Toast.LENGTH_LONG).show();
        new DownloadJSON().execute();
        getSupportActionBar();
    }
    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Ticket_Booking.this);
            mProgressDialog.setTitle("PLEASE wait for a while");
            mProgressDialog.setMessage("Loading...Ticket Booking page");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params1)
        {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address

            try
            {
                List params=new ArrayList();
                params.add(new BasicNameValuePair("event_id",id));
                ServiceHandler sh=new ServiceHandler();
                Log.d("request!","starting");

                //getting detail by making http request
                String jsonStr=sh.makeServiceCall("http://bishasha.com/json/ticket_booking.php", 1, params);
                JSONObject jsonobject =new JSONObject(jsonStr);

                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("ticket_booking");
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("type_category", jsonobject.getString("type_category"));
                    map.put("price", jsonobject.getString("price"));
                 //  map.put("event_id",jsonobject.getString("event_id"));
                    //Log.d("event_id ticketbooking",id);
                    map.put("id", jsonobject.getString("id"));
                     map.put("event_id",id);
                  Log.d("event_id ticketbooking",id);
                  //  map.put("event_id",id);
                    arraylist.add(map);
                }
            }
            catch (JSONException e)
            {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void args)
        {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.ticket_list);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter_tickets(Ticket_Booking.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);
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
            Intent intent = new Intent(Ticket_Booking.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(Ticket_Booking.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.now_on_sale) {
            Intent intent = new Intent(Ticket_Booking.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.upcoming) {
            Intent intent = new Intent(Ticket_Booking.this, UpcomingEvents.class);
            intent.putExtra("url_string","http://bishasha.com/json/upcoming_events.php");
            startActivity(intent);

        } else if (id == R.id.past) {
            Intent intent = new Intent(Ticket_Booking.this, PastEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/past_events.php");
            startActivity(intent);



        } else if (id == R.id.artists) {
            Intent intent = new Intent(Ticket_Booking.this, Artist_information.class);
            startActivity(intent);

        } else if (id == R.id.venue) {
            Intent intent = new Intent(Ticket_Booking.this, Venue.class);
            startActivity(intent);

        }else if (id == R.id.contact_us) {
            Intent intent = new Intent(Ticket_Booking.this, ContactUs.class);
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
}
