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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.R;
import com.example.eku.dry_ticket_project.adapter.ImageAdapter;
import com.example.eku.dry_ticket_project.pref.UserSession;
import com.example.eku.dry_ticket_project.utils.ServiceHandler;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Seat_allocation extends ActionBarActivity {

    int[] m = new int[8];
    int [] post =new int [8];

    JSONArray contacts = null;
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_S0 = "s0";
    private static final String TAG_S1 = "s1";
    private static final String TAG_S2 = "s2";
    private static final String TAG_S3 = "s3";
    private static final String TAG_S4 = "s4";
    private static final String TAG_S5 = "s5";
    private static final String TAG_S6 = "s6";
    private static final String TAG_S7 = "s7";
    private static final String TAG_ID = "id";
    UserSession session;
    private boolean flag1=false, flag2=false, flag3=false, flag4=false, flag5=false, flag6=false, flag7=false,flag0=false;
    int count;
    private ProgressDialog pDialog;
    GridView gridview;
    ViewGroup parent;
    private static String url = "http://bishasha.com/json/get_sitting_plan.php";
    private static String url_post= "http://bishasha.com/json/post_sitting_plan.php";
    String s1,s2,s3,s4,s0,s5,s6,s7,sid;
    String str_id;
    Button book_b,check;
    TextView display0,display1,display2,display3,display4,display5,display6,display7;
    String pos;
    String eve_id,eve_price,event_id;
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_selection);
     //   book_b=(Button)findViewById(R.id.book_btn);
        check=(Button)findViewById(R.id.hello);
        Intent intent= getIntent();
        eve_id=intent.getStringExtra("id");
        eve_price=intent.getStringExtra("price");
        event_id=intent.getStringExtra("event_id");

        Log.d("event_id list ap", "" + event_id);

        new GetUserData().execute();
        display0=(TextView) findViewById(R.id.display_booking0);
        display1=(TextView) findViewById(R.id.display_booking1);
        display2=(TextView) findViewById(R.id.display_booking2);
        display3=(TextView) findViewById(R.id.display_booking3);
        display4=(TextView) findViewById(R.id.display_booking4);
        display5=(TextView) findViewById(R.id.display_booking5);
        display6=(TextView) findViewById(R.id.display_booking6);
        display7=(TextView) findViewById(R.id.display_booking7);
        gridview = (GridView) findViewById(R.id.gridview);
        // gridview.setAdapter(new ImageAdapter(this));

        //   gridview.setAdapter(new Grid_img_adapter(this, m));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {


                int arrLabel = m[position];
                 pos=Integer.toString(position);
                Toast.makeText(
                        getApplicationContext(),
                        "v" + arrLabel+"p"+position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag0 == false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[0]=1;
                                flag0 = true;
                                display0.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[0]=0;
                                flag0 = false;
                                display0.setText("");
                            }
                        }
                        break;

                    case 1:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag1== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[1]=1;
                                flag1 = true;
                                display1.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[1]=0;
                                flag1 = false;
                                display1.setText("");
                            }
                        }
                        break;
                    case 2:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag2== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[2]=1;
                                flag2 = true;
                                display2.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[2]=0;
                                flag2 = false;
                                display2.setText("");
                            }
                        }
                        break;
                    case 3:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag3== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[3]=1;
                                flag3 = true;
                                display3.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[3]=0;
                                flag3 = false;
                                display3.setText("");
                            }
                        }
                        break;
                    case 4:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag4== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[4]=1;
                                flag4 = true;
                                display4.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[4]=0;
                                flag4 = false;
                                display4.setText("");
                            }
                        }
                        break;
                    case 5:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag5== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[5]=1;
                                flag5= true;
                                display5.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[5]=0;
                                flag5 = false;
                                display5.setText("");
                            }
                        }
                        break;
                    case 6:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag6== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[6]=1;
                                flag6 = true;
                                display6.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[6]=0;
                                flag6 = false;
                                display6.setText("");
                            }
                        }
                        break;
                    case 7:
                        if (arrLabel == 1) {

                            Toast.makeText(getApplicationContext(), "already book", Toast.LENGTH_SHORT).show();
                        } else {
                            if (flag7== false) {
                                count = count + 1;
                                Log.d("count++>",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.blue_seat);
                                post[7]=1;
                                flag7 = true;
                                display7.setText(pos);
                            } else {
                                count = count - 1;
                                Log.d("count-->",""+count );
                                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
                                imageView.setImageResource(R.drawable.grey_seat);
                                post[7]=0;
                                flag7 = false;
                                display7.setText("");
                            }
                        }
                        break;

                }

               total= (Integer.parseInt(eve_price))*count;
                Log.d("count",""+count);
                Log.d("total",""+total);
            }

        });


     /*   book_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetContacts().execute();
            }

        });
      */  check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  String ss=display0.getText().toString()+" "+display1.getText().toString()+" "+
          display2.getText().toString()+" "+display3.getText().toString()+" "+
                display4.getText().toString()+" "+display5.getText().toString()+" "+
                display6.getText().toString()+" "+display7.getText().toString();
                Log.d("ss",ss);
                Log.d("<<<>>post[0]=", "" + post[0]);
                Log.d("<<>>post[1]=",""+post[1]);
                Log.d("<<>>post[2]=",""+post[2]);
                Log.d("-<<>>post[3]=",""+post[3]);
                Log.d("<<>>post[4]=",""+post[4]);
                Log.d("<<>>post[5]=",""+post[5]);
                Log.d("<<>>post[6]=",""+post[6]);
                Log.d("<<>>post[7]=",""+post[7]);
                Log.d("<<>>id=",""+sid);

                Intent intent=new Intent(Seat_allocation.this,Order.class);
                 intent.putExtra("s0",Integer.toString(post[0]));
                intent.putExtra("s1",Integer.toString(post[1]));
                intent.putExtra("s2",Integer.toString(post[2]));
                intent.putExtra("s3",Integer.toString(post[3]));
                intent.putExtra("s4",Integer.toString(post[4]));
                intent.putExtra("s5",Integer.toString(post[5]));
                intent.putExtra("s6",Integer.toString(post[6]));
                intent.putExtra("s7",Integer.toString(post[7]));
                intent.putExtra("sid",(eve_id));
                intent.putExtra("total",Integer.toString(total));
               intent.putExtra("seat_selected",ss);
                intent.putExtra("event_id",event_id);
                startActivity(intent);
            }
        });
        getSupportActionBar();
    }

    private class GetUserData extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Seat_allocation.this);
            pDialog.setMessage("Please wait...");
            //   pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params1) {

            List params=new ArrayList();
            params.add(new BasicNameValuePair("id",eve_id));
            params.add(new BasicNameValuePair("event_id",event_id));

            ServiceHandler sh = new ServiceHandler();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET,params
            );

            Log.d("Response: ", "> " + jsonStr);


            if (jsonStr != null) {
                try {

                    JSONObject json = new JSONObject(jsonStr);
                    int success = json.getInt(TAG_SUCCESS);

                    Log.d("Login attempt", json.toString());
                    // json success tag

                    if (success == 1) {
                        contacts = json.getJSONArray("sitting_plan");

                        JSONObject c = contacts.getJSONObject(0);
                        s0=c.getString(TAG_S0);
                        s1=c.getString((TAG_S1));
                        s2= c.getString(TAG_S2);
                        s3=c.getString(TAG_S3);
                        s4=c.getString(TAG_S4);
                        s5=c.getString(TAG_S5);
                        s6=c.getString(TAG_S6);
                        s7=c.getString(TAG_S7);
                        sid=c.getString(TAG_ID);

                        post[0]=  m[0]=Integer.parseInt(s0);
                       // Log.d("m[0]=",""+m[0]);
                        post[1]=     m[1]=Integer.parseInt(s1);
                        //Log.d("m[1]=",""+m[1]);
                        post[2]=   m[2]=Integer.parseInt(s2);
                      //  Log.d("m[2]=",""+m[2]);
                        post[3]=    m[3]=Integer.parseInt(s3);
                        //Log.d("m[3]=",""+m[3]);
                        post[4]=   m[4]=Integer.parseInt(s4);
                      //  Log.d("m[4]=",""+m[4]);
                        post[5]=   m[5]=Integer.parseInt(s5);
                       // Log.d("m[5]=",""+m[5]);
                        post[6]=   m[6]=Integer.parseInt(s6);
                       // Log.d("m[6]=",""+m[6]);
                        post[7]=   m[7]=Integer.parseInt(s7);
                        //Log.d("m[7]=",""+m[7]);
                        str_id=sid;

                    }

                    Log.d("success", "" + success);
                    //  publishProgress(success);
                } catch (JSONException e) {
                    e.printStackTrace();
                }}
            else {
                Log.d("poooooo", "nnnnn");
            }
            return null;

        }


        @Override
        protected void onPostExecute(String file_url) {
            //super.onPostExecute(result);
            // Dismiss the progress dialog
            //  int x= Integer.parseInt(s0);

            gridview.setAdapter(new ImageAdapter(Seat_allocation.this, m));

            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }
    /**
     * Async task class to get json by making HTTP call
     * */

    private class GetContacts extends AsyncTask<Void,Integer, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Seat_allocation.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            int success;
            Log.d("event_id list post", "" + event_id);
        /*    Log.d("<<<>>post[0]=",""+post[0]);
            Log.d("<<>>post[1]=",""+post[1]);
            Log.d("<<>>post[2]=",""+post[2]);
            Log.d("-<<>>post[3]=",""+post[3]);
            Log.d("<<>>post[4]=",""+post[4]);
            Log.d("<<>>post[5]=",""+post[5]);
            Log.d("<<>>post[6]=",""+post[6]);
            Log.d("<<>>post[7]=",""+post[7]);
            Log.d("<<>>id=",""+str_id);*/
            try {
                // Building Parameters-9+++++++++++++++++++++++++++++

                List params = new ArrayList();

                params.add(new BasicNameValuePair("id",str_id));
                params.add(new BasicNameValuePair("event_id",event_id));
                params.add(new BasicNameValuePair("s0",Integer.toString(post[0])));
                params.add(new BasicNameValuePair("s1",Integer.toString(post[1])));
                params.add(new BasicNameValuePair("s2",Integer.toString(post[2])));
                params.add(new BasicNameValuePair("s3",Integer.toString(post[3])));
                params.add(new BasicNameValuePair("s4",Integer.toString(post[4])));
                params.add(new BasicNameValuePair("s5",Integer.toString(post[5])));
                params.add(new BasicNameValuePair("s6",Integer.toString(post[6])));
                params.add(new BasicNameValuePair("s7",Integer.toString(post[7])));


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
                Toast.makeText(getApplicationContext(),"Update",Toast.LENGTH_LONG).show();
                ;
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
            Intent intent = new Intent(Seat_allocation.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(Seat_allocation.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.now_on_sale) {
            Intent intent = new Intent(Seat_allocation.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.upcoming) {
            Intent intent = new Intent(Seat_allocation.this, UpcomingEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/upcoming_events.php");

            startActivity(intent);

        } else if (id == R.id.past) {
            Intent intent = new Intent(Seat_allocation.this, PastEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/past_events.php");
            startActivity(intent);


        } else if (id == R.id.artists) {
            Intent intent = new Intent(Seat_allocation.this, Artist_information.class);
            startActivity(intent);

        } else if (id == R.id.venue) {
            Intent intent = new Intent(Seat_allocation.this,Venue.class);
            startActivity(intent);

        }else if (id == R.id.contact_us) {
            Intent intent = new Intent(Seat_allocation.this, ContactUs.class);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);

    }
}


