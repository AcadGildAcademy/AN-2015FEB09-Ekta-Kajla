package com.example.eku.dry_ticket_project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eku.dry_ticket_project.R;

/**
 * Created by DELL on 01-05-2015.
 */
public class Last_page extends ActionBarActivity {
    TextView thank;
    Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_page);
        thank=(TextView)findViewById(R.id.thanku);
        close=(Button)findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Last_page.this,first_activity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar();

    }
}
