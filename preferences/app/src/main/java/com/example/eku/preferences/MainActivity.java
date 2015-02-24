package com.example.eku.preferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DELL on 24-02-2015.
 */
public class MainActivity extends Activity {
    private static final int SETTING_RESULT = 1;
    Button setting;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserSettingActivity.class);
                startActivityForResult(i,SETTING_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SETTING_RESULT)
        {
            displayUserSetting();
        }

    }

    private void displayUserSetting()
    {
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        String setting="";
        setting=setting+"Password:" +sp.getString("prefUserPassword","NOPASSWORD");
        setting=setting+"\n Remind For Update:"+sp.getBoolean("prefLockScreen",false);
        setting=setting+"\n Update Frequency:"+sp.getString("prefUpdateFrequency","NOUPDATE");

        textView=(TextView)findViewById(R.id.textViewSettings);
        textView.setText(setting);
    }
}
