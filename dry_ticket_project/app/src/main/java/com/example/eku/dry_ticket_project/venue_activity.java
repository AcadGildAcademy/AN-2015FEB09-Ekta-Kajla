//package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 02-04-2015.
 */
/*import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
public class MainActivity extends ListActivity {
    private String URL_ITEMS = "http://bishasha.com/json/venues.php";
   // private static final String TAG_FIXTURE = "fixture";
   // private static final String TAG_MATCHID = "matchId";
    private static final String TAG_VENUE = "venue";
    private static final String TAG_IMAGE_PATH = "image_path";
    JSONArray matchFixture = null;
    ArrayList<HashMap<String, String>> matchFixtureList = new ArrayList<HashMap<String, String>>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venue);
        // Call Async task to get the match fixture
        new GetFixture().execute();
    }
    private class GetFixture extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... arg) {
            ServiceHandler serviceClient = new ServiceHandler();
            Log.d("url: ", "> " + URL_ITEMS);
            String json = serviceClient.makeServiceCall(URL_ITEMS,ServiceHandler.GET);
            // print the json response in the log
            Log.d("Get match fixture response: ", "> " + json);
            if (json != null) {
                try {
                    Log.d("try", "in the try");
                    JSONObject jsonObj = new JSONObject(json);
                    Log.d("jsonObject", "new json Object");
                    // Getting JSON Array node
                    matchFixture = jsonObj.getJSONArray(events);
                    Log.d("json aray", "user point array");
                    int len = matchFixture.length();
                    Log.d("len", "get array length");
                    for (int i = 0; i < matchFixture.length(); i++) {
                        JSONObject c = matchFixture.getJSONObject(i);
                        String matchId = c.getString(TAG_MATCHID);
                        Log.d("matchId", matchId);
                        String teamA = c.getString(TAG_TEAMA);
                        Log.d("teamA", teamA);
                        String teamB = c.getString(TAG_TEAMB);
                        Log.d("teamB", teamB);
                        //  hashmap for single match
                        HashMap<String, String> matchFixture = new HashMap<String, String>();
                        // adding each child node to HashMap key => value
                        matchFixture.put(TAG_MATCHID, matchId);
                        matchFixture.put(TAG_TEAMA, teamA);
                        matchFixture.put(TAG_TEAMB, teamB);
                        matchFixtureList.add(matchFixture);
                    }
                }
                catch (JSONException e) {
                    Log.d("catch", "in the catch");
                    e.printStackTrace();
                }
            } else {
                Log.e("JSON Data", "Didn't receive any data from server!");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, matchFixtureList,
                    R.layout.list_item, new String[] {
                    TAG_MATCHID, TAG_TEAMA,TAG_TEAMB
            }
                    , new int[] {
                    R.id.matchId,R.id.teamA,
                    R.id.teamB
            }
            );
            setListAdapter(adapter);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}*/