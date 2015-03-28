package com.example.eku.dry_ticket_project;

/**
 * Created by DELL on 21-03-2015.
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

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public ListViewAdapter(Context context,
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
      /*  TextView desc;
        TextView date;
        TextView time;
*/        ImageView image_path;
        TextView detail;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
  /*      desc = (TextView) itemView.findViewById(R.id.date);
        date = (TextView) itemView.findViewById(R.id.price);
        time = (TextView) itemView.findViewById(R.id.time);
  */      detail = (TextView) itemView.findViewById(R.id.detail);

        // Locate the ImageView in listview_item.xml
       image_path = (ImageView) itemView.findViewById(R.id.flag);

        // Capture position and set results to the TextViews
   /*     desc.setText(resultp.get(NowOnSale.DESC));
        date.setText(resultp.get(NowOnSale.DATE));
        time.setText(resultp.get(NowOnSale.TIME));
     */   detail.setText(resultp.get(NowOnSale.DETAIL));

        // Capture position and set results to the ImageView
        // Passes image_path images URL into ImageLoader.class
        imageLoader.DisplayImage(resultp.get(NowOnSale.IMAGE_PATH), image_path);
        // Capture ListView item click
        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                resultp = data.get(position);
                Intent intent = new Intent(context, singleitemview.class);
                // Pass all data desc
                intent.putExtra("desc", resultp.get(NowOnSale.DESC));
                // Pass all data date
                intent.putExtra("date", resultp.get(NowOnSale.DATE));
                // Pass all data time
                intent.putExtra("time",resultp.get(NowOnSale.TIME));
                intent.putExtra("price", resultp.get(NowOnSale.PRICE));
                intent.putExtra("venue", resultp.get(NowOnSale.VENUE));
                // Pass all data image_path
                intent.putExtra("image_path", resultp.get(NowOnSale.IMAGE_PATH));
              //  intent.putExtra("detail",resultp.get(NowOnSale.DETAIL));
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });
        return itemView;
    }
}