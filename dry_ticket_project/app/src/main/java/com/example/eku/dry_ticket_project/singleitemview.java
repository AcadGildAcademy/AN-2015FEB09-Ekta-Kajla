package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 21-03-2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class singleitemview extends Activity {
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
        ImageView imgflag = (ImageView) findViewById(R.id.flag2);

        // Set results to the TextViews
        txtdesc.setText(desc);
        txtdate.setText(date);
        txttime.setText(time);

        txtprice.setText(price);
        txtvenue.setText(venue);
        // Capture position and set results to the ImageView
        // Passes image_path images URL into ImageLoader.class
        imageLoader.DisplayImage(image_path, imgflag);
    }
}