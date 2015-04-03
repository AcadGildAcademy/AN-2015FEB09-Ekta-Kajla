package com.example.eku.dry_ticket_project;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DELL on 11-03-2015.
 */
public class first_activity extends ActionBarActivity {
    FragmentManager fm = getFragmentManager();
    TextView dry;
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        dry = (TextView) findViewById(R.id.txtdry);
        // stop=(Button)findViewById(R.id.stop);
        dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dry.setVisibility(View.GONE);
            }
        });
        getActionBar();
        // changing action bar color
        //  getActionBar().setBackgroundDrawable(
        //        new ColorDrawable(Color.parseColor("#ffff1217")));
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
            Intent intent = new Intent(first_activity.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(first_activity.this, sign_up.class);
            startActivity(intent);
            // CustomDialog cd = new CustomDialog();
            // cd.show(fm, "Dialog");

            return true;
        } else if (id == R.id.option_menu1) {
            Intent intent = new Intent(first_activity.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.option_menu2) {
            Intent intent = new Intent(first_activity.this, UpcomingEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu3) {
            Intent intent = new Intent(first_activity.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu4) {
            Intent intent = new Intent(first_activity.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu5) {
            Intent intent = new Intent(first_activity.this, PastEvents.class);
            startActivity(intent);

        } else if (id == R.id.option_menu6) {
            Intent intent = new Intent(first_activity.this, Venue.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
