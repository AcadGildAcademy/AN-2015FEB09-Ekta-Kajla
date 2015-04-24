package com.example.eku.dry_ticket_project.adapter;





import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.R;
public class ImageAdapter extends BaseAdapter {
    int x,m;
    Boolean f0=false,f1=false,f2=false;
    int count;
    private Context context;
    //1 private final String[] gridValues;
    private final int[] gridValues;
    //Constructor to initialize values
    public ImageAdapter(Context context, int[ ] gridValues) {

        this.context        = context;
        this.gridValues     = gridValues;
    }

    @Override
    public int getCount() {

        // Number of times getView method call depends upon gridValues.length
        return gridValues.length;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }


    // Number of times getView method call depends upon gridValues.length

    public View getView(int position, View convertView, ViewGroup parent) {

        // LayoutInflator to call external grid_item.xml file

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from grid_item.xml ( Defined Below )

            gridView = inflater.inflate( R.layout.seat , null);

            // set value into textview




            // set image based on selected text

            final       ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            int arrLabel = gridValues[ position ];
            if (arrLabel==0) {

                imageView.setImageResource(R.drawable.grey_seat);

            } else if (arrLabel==1) {

                imageView.setImageResource(R.drawable.seat);

            } else {

                imageView.setImageResource(R.drawable.grey_seat);
            }



        } else {

            gridView = (View) convertView;
        }

        return gridView;
    }
}