package com.example.eku.dry_ticket_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.utils.ImageLoader;
import com.example.eku.dry_ticket_project.R;
import com.example.eku.dry_ticket_project.activity.Seat_allocation;
import com.example.eku.dry_ticket_project.activity.Ticket_Booking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DELL on 10-04-2015.
 */
public class ListViewAdapter_tickets extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();
String cat,str_id;
    int temp_id_cat;
    public ListViewAdapter_tickets(Context context,ArrayList<HashMap<String, String>> arraylist)
    {
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
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        TextView type_category;
        TextView price,buy_ticket_btn;
        final String event_id;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.ticket_selection, parent, false);
        resultp = data.get(position);
        type_category = (TextView) itemView.findViewById(R.id.type_category);
        price = (TextView) itemView.findViewById(R.id.price);
       buy_ticket_btn = (TextView) itemView.findViewById(R.id.buy_ticket);
        type_category.setText(resultp.get(Ticket_Booking.TYPE_CATEGORY));
        price.setText(resultp.get(Ticket_Booking.PRICE));
        str_id=resultp.get((Ticket_Booking.ID));
        event_id=resultp.get("event_id");
        Log.d("event_id adapter",event_id);
       // Toast.makeText(context,event_id,Toast.LENGTH_LONG).show();
        /*buy_ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, Seat_allocation.class);

                context.startActivity(intecnt);
            }
        });*/
        //cat =type_category.getText().toString();

        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
            int price = 0;
                //Log.d("<< eve_id >>",""+position);
  int pos=position+1;
switch (pos)
{
    case 1: price=129;
            break;
    case 2: price=79;
        break;
    case 3: price=59;
        break;
    case 4: price=49;
        break;
    case 5: price=39;
        break;
    case 6: price=39;
        break;
}

                Intent intent = new Intent(context, Seat_allocation.class);
              //  intent.putExtra("id_cat",Integer.toString(id_cat));
               intent.putExtra("id",Integer.toString(pos));
                intent.putExtra("price",Integer.toString(price));
                intent.putExtra("event_id",event_id);
                Log.d("event_id list ap", "" + event_id);


                context.startActivity(intent);

            }
        });
       return itemView;
    }
}