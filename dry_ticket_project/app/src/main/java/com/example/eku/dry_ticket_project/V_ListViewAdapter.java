package com.example.eku.dry_ticket_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DELL on 01-04-2015.
 */
public class V_ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public V_ListViewAdapter(Context context,
                             ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
        imageLoader = new ImageLoader(context);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // TextView desc;
        //TextView date;
        //TextView time;
        //TextView price;
        TextView venue;

        ImageView image_path;
        //  TextView detail;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.venue, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
       // desc = (TextView) itemView.findViewById(R.id.desc2);
       // date = (TextView) itemView.findViewById(R.id.date2);
        //  time = (TextView) itemView.findViewById(R.id.time2);
        // price = (TextView) itemView.findViewById(R.id.price2);
         venue = (TextView) itemView.findViewById(R.id.venue4);


        //      detail = (TextView) itemView.findViewById(R.id.detail);

        // Locate the ImageView in listview_item.xml
        image_path = (ImageView) itemView.findViewById(R.id.flag4);

        // Capture position and set results to the TextViews
      //  desc.setText(resultp.get(UpcomingEvents.DESC));
       // date.setText(resultp.get(UpcomingEvents.DATE));
        //  time.setText(resultp.get(UpcomingEvents.TIME));
        //  price.setText(resultp.get(UpcomingEvents.PRICE));
         venue.setText(resultp.get(Venues.VENUE));

        // detail.setText(resultp.get(NowOnSale.DETAIL));

        // Capture position and set results to the ImageView
        // Passes image_path images URL into ImageLoader.class
        imageLoader.DisplayImage(resultp.get(Venues.IMAGE_PATH), image_path);
        // Capture ListView item click
     /*   itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                resultp = data.get(position);
                Intent intent = new Intent(context, singleitemview.class);
                // Pass all data desc
                intent.putExtra("desc", resultp.get(UpcomingEvents.DESC));
                // Pass all data date
                intent.putExtra("date", resultp.get(UpcomingEvents.DATE));
                // Pass all data time
                intent.putExtra("time", resultp.get(UpcomingEvents.TIME));
                intent.putExtra("price", resultp.get(UpcomingEvents.PRICE));
                intent.putExtra("venue", resultp.get(UpcomingEvents.VENUE));
                // Pass all data image_path
                intent.putExtra("image_path", resultp.get(UpcomingEvents.IMAGE_PATH));
                //  intent.putExtra("detail",resultp.get(NowOnSale.DETAIL));
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });*/
        return itemView;
    }
}
