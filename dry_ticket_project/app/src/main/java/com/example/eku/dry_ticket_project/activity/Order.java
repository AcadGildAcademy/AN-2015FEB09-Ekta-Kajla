package com.example.eku.dry_ticket_project.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.R;
import com.example.eku.dry_ticket_project.pref.UserSession;
import com.example.eku.dry_ticket_project.utils.ServiceHandler;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DELL on 20-04-2015.
 */
public class Order extends ActionBarActivity {
    TextView email,total,selected_seat;
String sid,s0,s1,s2,s3,s4,s5,s6,s7;
    Button check;
    private static final String TAG_SUCCESS = "success";
    int [] post =new int [10];
    private ProgressDialog pDialog;
    private static String url_post= "http://bishasha.com/json/post_sitting_plan.php";
    String event_id,   seat,tt;
    String user_email;
    UserSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        getSupportActionBar();
        email=(TextView)findViewById(R.id.order_email);
        total=(TextView)findViewById(R.id.order_total);
        selected_seat=(TextView)findViewById(R.id.order_selected_seat);
        check=(Button)findViewById(R.id.order_button);


        Log.d("aaa","email");
      Intent intent= getIntent();
       s0=intent.getStringExtra("s0");
        s1=intent.getStringExtra("s1");
        s2=intent.getStringExtra("s2");
        s3=intent.getStringExtra("s3");
        s4=intent.getStringExtra("s4");
        s5=intent.getStringExtra("s5");
        s6=intent.getStringExtra("s6");
        s7=intent.getStringExtra("s7");
      sid=intent.getStringExtra("sid");
        tt=intent.getStringExtra("total");
         seat=intent.getStringExtra("seat_selected");
        event_id=intent.getStringExtra("event_id");
        Log.d("s0",""+s0);
        post[0]=Integer.parseInt(s0);
        Log.d("p[0]",""+post[0]);
        post[1]=Integer.parseInt(s1);
        post[2]=Integer.parseInt(s2);
        post[3]=Integer.parseInt(s3);
        post[4]=Integer.parseInt(s4);
        post[5]=Integer.parseInt(s5);
        post[6]=Integer.parseInt(s6);
        post[7]=Integer.parseInt(s7);
        session = new UserSession(getApplicationContext());
        HashMap<String,String> user=session.getUserDetails();
        if(session.isUserLoggedIn())
        {
             user_email=user.get(UserSession.KEY_NAME);
            email.setText(user_email);
        }
        total.setText(tt);

        selected_seat.setText(seat);

        Log.d("s0", "" + s0);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new GetContacts().execute();
            }
        });


    }
    /**
     * Async task class to get json by making HTTP call
     * */

    private class GetContacts extends AsyncTask<Void,Integer, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Order.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            int success;
            Log.d("<<<>>eventid=", "" + event_id);
            Log.d("<<>>total=",""+tt);
            Log.d("<<>>seat",""+seat);
            Log.d("<<>>email",user_email);
String email=user_email.toString();

            try {
                // Building Parameters-9+++++++++++++++++++++++++++++

                List params = new ArrayList();

                params.add(new BasicNameValuePair("id",sid));
                params.add(new BasicNameValuePair("s0",Integer.toString(post[0])));
                params.add(new BasicNameValuePair("s1",Integer.toString(post[1])));
                params.add(new BasicNameValuePair("s2",Integer.toString(post[2])));
                params.add(new BasicNameValuePair("s3",Integer.toString(post[3])));
                params.add(new BasicNameValuePair("s4",Integer.toString(post[4])));
                params.add(new BasicNameValuePair("s5",Integer.toString(post[5])));
                params.add(new BasicNameValuePair("s6",Integer.toString(post[6])));
                params.add(new BasicNameValuePair("s7",Integer.toString(post[7])));
                params.add(new BasicNameValuePair("event_id",event_id));
                params.add(new BasicNameValuePair("total",tt));
                params.add(new BasicNameValuePair("email",email));
                params.add(new BasicNameValuePair("selected_seats",seat));

                ServiceHandler sh = new ServiceHandler();
                Log.d("request!", "starting");
                // getting product details by making HTTP request
                String jsonStr = sh.makeServiceCall( url_post, ServiceHandler.POST,params);//2 for POST
                JSONObject json = new JSONObject(jsonStr);
                // check your log for json response
                Log.d("sign up attempt", json.toString());
                // json success tag
                success = json.getInt(TAG_SUCCESS);
                Log.d("success",""+success);
                publishProgress(success);
            }catch(JSONException e){
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
        }


        //Handling updation to your UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int  success=values[0];
            if (success == 1) {
                Log.d("update Successful!", " Success");
                Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_LONG).show();
              Intent intent=new Intent(Order.this,Last_page.class);
                startActivity(intent);
            } else {
                Log.d("update fail"," fail");

                // return json.getString(TAG_MESSAGE);
            }
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
            Intent intent = new Intent(Order.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(Order.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.now_on_sale) {
            Intent intent = new Intent(Order.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.upcoming) {
            Intent intent = new Intent(Order.this, UpcomingEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/upcoming_events.php");
            startActivity(intent);

        } else if (id == R.id.past) {
            Intent intent = new Intent(Order.this, PastEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/past_events.php");
            startActivity(intent);



        } else if (id == R.id.artists) {
            Intent intent = new Intent(Order.this, Artist_information.class);
            startActivity(intent);

        } else if (id == R.id.venue) {
            Intent intent = new Intent(Order.this, Venue.class);
            startActivity(intent);

        } else if (id == R.id.contact_us) {
            Intent intent = new Intent(Order.this, ContactUs.class);
            startActivity(intent);


        } return super.onOptionsItemSelected(item);
    }
}


