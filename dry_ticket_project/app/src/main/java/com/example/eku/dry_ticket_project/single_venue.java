package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 03-04-2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class single_venue extends FragmentActivity {
    // Declare Variables
    String venue_desc;
    String venue_name;
    String venue_image_path;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemvenue);


        Intent i = getIntent();
        venue_desc = i.getStringExtra("venue_desc");

        venue_name = i.getStringExtra("venue_name");
        // Get the result of image_path
          venue_image_path = i.getStringExtra("venue_image_path");

        // Locate the TextViews in singleitemvenue.xml

        TextView txtdesc = (TextView) findViewById(R.id.data_desc);

        TextView txtvenue = (TextView) findViewById(R.id.data_name);

        // Locate the ImageView in singleitemvenue.xml
         ImageView imgflag = (ImageView) findViewById(R.id.flag_venue);

        // Set results to the TextViews
        txtdesc.setText(venue_desc);
        txtvenue.setText(venue_name);
        // Capture position and set results to the ImageView
        // Passes image_path images URL into ImageLoader.class
    imageLoader.DisplayImage(venue_image_path,imgflag);

        getActionBar();
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
            Intent intent = new Intent(single_venue.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(single_venue.this, sign_up.class);
            startActivity(intent);

            return true;
        } else if (id == R.id.option_menu1) {
            Intent intent = new Intent(single_venue.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.option_menu2) {
            Intent intent = new Intent(single_venue.this, UpcomingEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu3) {
            Intent intent = new Intent(single_venue.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu4) {
            Intent intent = new Intent(single_venue.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu5) {
            Intent intent = new Intent(single_venue.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu6) {
            Intent intent = new Intent(single_venue.this, Venue
                    .class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}


