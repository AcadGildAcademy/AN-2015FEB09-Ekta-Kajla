package com.example.eku.dry_ticket_project.activity;

/**
 * Created by DELL on 21-03-2015.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eku.dry_ticket_project.utils.ImageLoader;
import com.example.eku.dry_ticket_project.R;

public class singleitemview extends FragmentActivity {
    // Declare Variables
    String id;
    String desc;
    String date;
    String time;
    String venue;
    String price;
    String image_path;
    String position;
    Button buy_button;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

      //  Intent i = getIntent();
        // Get the result of rank
        id = getIntent().getExtras().getString("id");
        desc = getIntent().getExtras().getString("desc");
        date = getIntent().getExtras().getString("date");
        time = getIntent().getExtras().getString("time");
        price = getIntent().getExtras().getString("price");
        venue = getIntent().getExtras().getString("venue");

        // Get the result of image_path
        image_path = getIntent().getExtras().getString("image_path");

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
        final Context context = this;
        buy_button=(Button)findViewById(R.id.buy_ticket);
        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Ticket_Booking.class);
                Bundle bundle=new Bundle();
                bundle.putString("id",id);
                startActivity(intent);
            }
        });
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
            Intent intent = new Intent(singleitemview.this, Venue
                    .class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}


