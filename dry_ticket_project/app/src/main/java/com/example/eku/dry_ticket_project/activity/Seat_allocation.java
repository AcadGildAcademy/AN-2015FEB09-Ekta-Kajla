package com.example.eku.dry_ticket_project.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.R;

import static com.example.eku.dry_ticket_project.R.color.orange;
import static com.example.eku.dry_ticket_project.R.color.white;

public class Seat_allocation extends ActionBarActivity {

    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_selection);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
               // Log.d("eku",""+position);
                ImageView imageView=(ImageView) v;
                imageView.setImageResource(R.drawable.seat);
              // v.setBackgroundColor(orange);
        }
        });
        getSupportActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_file
                , menu);
        return true;
    }
}