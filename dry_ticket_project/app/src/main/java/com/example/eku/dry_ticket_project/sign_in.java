package com.example.eku.dry_ticket_project;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class sign_in extends ActionBarActivity {
    private ProgressDialog pDialog;
    EditText name, password;
    Button sign_in, logout;
    CheckBox checkBox;
    UserSession session;

    private static String url = "http://bishasha.com/json/event_login.php";

    private static final String TAG_SUCCESS = "success";

    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        contactList = new ArrayList<HashMap<String, String>>();

        checkBox = (CheckBox) findViewById(R.id.check_Box);

        name = (EditText) findViewById(R.id.username_edit);
        password = (EditText) findViewById(R.id.password_edit);
        logout=(Button) findViewById(R.id.logout);

        sign_in = (Button) findViewById(R.id.sign);
       session = new UserSession(getApplicationContext());

        loadMySavePreferences();
        getActionBar();

        if(session.isUserLoggedIn())
        {
            sign_in.setEnabled(false);
        }

        sign_in.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String username_value = name.getText().toString();
                String userpass_value = password.getText().toString();
                final String email = name.getText().toString();
                final String pass = password.getText().toString();
                if (!isValidEmail(email)) {
                    name.setError("Invalid Email");
                }

            else    if (!isValidPassword(pass)) {
                    password.setError("Invalid Password");
                }


                // Intent intent=new Intent (sign_in.this,dry_ticket.class);
                //                startActivity (intent);

                else
                {
                    // Calling async task to get json
                    new GetContacts().execute();

                    // preferences
                    savedMySharedPreferences("check", checkBox.isChecked());
                    if(checkBox.isChecked())
                    {
                        String st = name.getText().toString();
                        String st2=password.getText().toString();
                        savedMySharedPreferences("user", st);
                        savedMySharedPreferences("password",st2);
                    }

                }

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();

            }
        });

    }
       private class GetContacts extends AsyncTask<Void,Integer,Void>
       {
           @Override
           protected void onPreExecute()
           {
               super.onPreExecute();
               //showing progress dialog
               pDialog=new ProgressDialog(sign_in.this);
               pDialog.setMessage("Please wait..");
               pDialog.setCancelable(false);
               pDialog.show();
           }
           @Override
           protected Void doInBackground(Void... arg0) {
              int success;

               String username_value = name.getText().toString();
               String userpass_value = password.getText().toString();
               try{
                   //building params
                   List params=new ArrayList();
                   params.add(new BasicNameValuePair("email",username_value));
                   params.add(new BasicNameValuePair("password",userpass_value));
                   ServiceHandler sh=new ServiceHandler();
                   Log.d("request!","starting");

                   //getting detail by making http request
                   String jsonStr=sh.makeServiceCall(url, 1, params);
                   JSONObject json =new JSONObject(jsonStr);

                   //check ur log for json response
                   Log.d("Login attempts",json.toString());

                   //json success tag
                   success=json.getInt(TAG_SUCCESS);
                   Log.d("success","+success");

                   publishProgress(success);
               }catch (JSONException e)
               {
                   e.printStackTrace();
               }
               return null;
           }
           @Override
           protected void onPostExecute(Void result) {
               super.onPostExecute(result);
               //dismiss the progress dialog
               if(pDialog.isShowing())
                   pDialog.dismiss();
           }
           @Override
           protected void onProgressUpdate(Integer... values) {
               super.onProgressUpdate(values);

               int success=values[0];
               String username_value = name.getText().toString();
               String userpass_value = password.getText().toString();
               if (success==1)
               {
                   Log.d("Login Successful","Login Success");
                   Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_LONG).show();
                  // Intent intent=new Intent (sign_in.this,Now_on_sale.class);
                    //             startActivity (intent);
                     session.createUserLoginSession(username_value,userpass_value);
                   finish();

               }
               else
               {
                   Log.d("Login Failure","login fail");
                   Toast.makeText(getApplicationContext(),"login fail",Toast.LENGTH_LONG).show();
               }
           }
       }

    public  void loadMySavePreferences()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        String str = sp.getString("user","");
        String pass=sp.getString("password","");
        Boolean ck =sp.getBoolean("check", true);
        name.setText(str);
        password.setText(pass);
        checkBox.setChecked(ck);
    }

    public void savedMySharedPreferences(String Key,String values)
    {
        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed =sp.edit();
        ed.putString(Key,values);
        ed.commit();
    }
    public void savedMySharedPreferences(String Key,Boolean values)
    {
        SharedPreferences sp =PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed =sp.edit();
        ed.putBoolean(Key,values);
        ed.commit();
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 2) {
            return true;
        }
        return false;
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
            Intent intent = new Intent(sign_in.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(sign_in.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.option_menu1) {
            Intent intent = new Intent(sign_in.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.option_menu2) {
            Intent intent = new Intent(sign_in.this, UpcomingEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu3) {
            Intent intent = new Intent(sign_in.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu4) {
            Intent intent = new Intent(sign_in.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu5) {
            Intent intent = new Intent(sign_in.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu6) {
            Intent intent = new Intent(sign_in.this, Venues.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}

