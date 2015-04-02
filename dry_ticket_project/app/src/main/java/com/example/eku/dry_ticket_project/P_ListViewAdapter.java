package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 31-03-2015.
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class P_ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public P_ListViewAdapter(Context context,
                             ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
        imageLoader = new ImageLoader(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView desc;
        TextView date;
        TextView time;
        TextView price;
        TextView venue;

        ImageView image_path;
        //  TextView detail;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.past, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
        desc = (TextView) itemView.findViewById(R.id.desc3);
        date = (TextView) itemView.findViewById(R.id.date3);
        time = (TextView) itemView.findViewById(R.id.time3);
        price = (TextView) itemView.findViewById(R.id.price3);
        venue = (TextView) itemView.findViewById(R.id.venue3);


        //      detail = (TextView) itemView.findViewById(R.id.detail);

        // Locate the ImageView in listview_item.xml
        image_path = (ImageView) itemView.findViewById(R.id.flag3);

        // Capture position and set results to the TextViews
        desc.setText(resultp.get(PastEvents.DESC));
        date.setText(resultp.get(PastEvents.DATE));
        time.setText(resultp.get(PastEvents.TIME));
        price.setText(resultp.get(PastEvents.PRICE));
        venue.setText(resultp.get(PastEvents.VENUE));

        // detail.setText(resultp.get(NowOnSale.DETAIL));

        // Capture position and set results to the ImageView
        // Passes image_path images URL into ImageLoader.class
        imageLoader.DisplayImage(resultp.get(PastEvents.IMAGE_PATH), image_path);
        // Capture ListView item click
      itemView.setOnClickListener(new OnClickListener() {

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
        });
        return itemView;
    }
}