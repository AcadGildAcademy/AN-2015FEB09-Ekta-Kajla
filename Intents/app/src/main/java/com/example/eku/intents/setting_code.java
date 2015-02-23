package com.example.eku.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by DELL on 21-02-2015.
 */
public class setting_code extends Activity {
    Button wifi, bluetooth, add_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        wifi = (Button) findViewById(R.id.b_wifi);
        bluetooth = (Button) findViewById(R.id.b_bluetooth);
        add_account = (Button) findViewById(R.id.b_account);

        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(setting_code.this,wifi_main.class);
                startActivity(intent);
            }
        });
    }


}
