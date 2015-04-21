package com.example.eku.dry_ticket_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

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
        TextView price;
        Button buy_ticket_btn;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.ticket_selection, parent, false);
        resultp = data.get(position);
        type_category = (TextView) itemView.findViewById(R.id.type_category);
        price = (TextView) itemView.findViewById(R.id.price);
        buy_ticket_btn = (Button) itemView.findViewById(R.id.buy_ticket);
        type_category.setText(resultp.get(Ticket_Booking.TYPE_CATEGORY));
        price.setText(resultp.get(Ticket_Booking.PRICE));
        buy_ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, Seat_allocation.class);

                context.startActivity(intent);
            }
        });
      /*  itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                // Get the position
                resultp = data.get(position);
                Bundle bundle= new Bundle();
                //Bundle bundle = intent.getExtras();
                bundle.putString("type_category", resultp.get(Ticket_Booking.TYPE_CATEGORY ));
                bundle.putString("price", resultp.get(Ticket_Booking.PRICE));

                Intent intent = new Intent(context, Seat_allocation.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
       */ return itemView;
    }
}