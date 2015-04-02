package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 21-03-2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class singleitemview extends ActionBarActivity {
    // Declare Variables
    String desc;
    String date;
    String time;
    String venue;
    String price;
    String image_path;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();
        // Get the result of rank
       desc = i.getStringExtra("desc");
        // Get the result of country
       date = i.getStringExtra("date");
        // Get the result of population
       time = i.getStringExtra("time");

        price = i.getStringExtra("price");
        venue = i.getStringExtra("venue");
        // Get the result of image_path
        image_path = i.getStringExtra("image_path");

        // Locate the TextViews in singleitemview.xml

        TextView txtdesc = (TextView) findViewById(R.id.desc);
        TextView txtdate = (TextView) findViewById(R.id.date);
        TextView txttime = (TextView) findViewById(R.id.time);
        TextView txtprice = (TextView) findViewById(R.id.price);
        TextView txtvenue = (TextView) findViewById(R.id.venue);

        // Locate the ImageView in singleitemview.xml
        ImageView imgflag = (ImageView) findViewById(R.id.flag);

        // Set results to the TextViews
        txtdesc.setText(desc);
        txtdate.setText(date);
        txttime.setText(time);

        txtprice.setText(price);
        txtvenue.setText(venue);
        // Capture position and set results to the ImageView
        // Passes image_path images URL into ImageLoader.class

        imageLoader.DisplayImage(image_path, imgflag);
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
            Intent intent = new Intent(singleitemview.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(singleitemview.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.option_menu1) {
            Intent intent = new Intent(singleitemview.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.option_menu2) {
            Intent intent = new Intent(singleitemview.this, UpcomingEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu3) {
            Intent intent = new Intent(singleitemview.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu4) {
            Intent intent = new Intent(singleitemview.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu5) {
            Intent intent = new Intent(singleitemview.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu6) {
            Intent intent = new Intent(singleitemview.this, PastEvents.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}


