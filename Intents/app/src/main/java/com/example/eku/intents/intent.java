package com.example.eku.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by DELL on 17-02-2015.
 */
public class intent extends Activity {
    Button apps,setting,vibrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_ex);

        apps = (Button) findViewById(R.id.b_apps);
        setting = (Button) findViewById(R.id.b_setting);
        vibrate=(Button)findViewById(R.id.b_vibrate);
        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (intent.this,app_act.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(intent.this,setting_code.class);
                startActivity(intent);

            }
        });
    //    vibrate.setOnClickListener(new View.OnClickListener() {
     //       @Override
    //        public void onClick(View v) {
     //           Intent intent=new Intent(intent.this,setting_code.class);
      //          startActivity(intent);

//            }
    //    });

    }



}
