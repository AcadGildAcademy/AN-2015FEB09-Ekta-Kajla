package com.example.eku.intents;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by DELL on 21-02-2015.
 */

public class wifi_main extends Activity {

    TextView mainText;
    WifiManager mainWifi;
    WifiScanReceiver wifiReceiver;
    ListView List;
    String wifis[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_activity);
        List=(ListView)findViewById(R.id.listView);
        mainText = (TextView) findViewById(R.id.textView);
        mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiReceiver= new WifiScanReceiver();
        mainWifi.startScan();


        final Switch toggle = (Switch) findViewById(R.id.wifi_switch);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleWiFi(true);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Enabled!", Toast.LENGTH_LONG).show();
                } else {
                    toggleWiFi(false);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Disabled!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void toggleWiFi(boolean status) {
        WifiManager wifiManager=(WifiManager)this.getSystemService(Context.WIFI_SERVICE);
          if (status == true && !wifiManager.isWifiEnabled())
          {
            wifiManager.setWifiEnabled(true);
          }
          else if (status == false && wifiManager.isWifiEnabled())
          {
            wifiManager.setWifiEnabled(false);
          }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 01, 1, "Refresh");
        menu.add(1, 02, 1, "Re");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

            mainWifi.startScan();
            mainText.setText("Starting Scan");
            return super.onMenuItemSelected(featureId, item);
    }

    class  WifiScanReceiver extends BroadcastReceiver{

            @Override
            public void onReceive(Context context, Intent intent) {
                List<ScanResult>WifiScanList=mainWifi.getScanResults();
                wifis=new  String[WifiScanList.size()];
                for (int i=0;i<WifiScanList.size();i++)
                {
                    wifis[i]=((WifiScanList.get(i)).toString());

                }
                List.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,wifis));

            }
        }
    }




