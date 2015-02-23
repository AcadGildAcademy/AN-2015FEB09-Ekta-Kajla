package com.example.eku.my_app;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Created by DELL on 09-02-2015.
 */
public class second_screen extends Activity {

    ListView lv;
    TextView tv_name;
    Button Ascending, Descending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_name);
        Ascending = (Button) findViewById(R.id.b_asc);
        Descending = (Button) findViewById(R.id.b_dsc);

        tv_name = (TextView) findViewById(R.id.tv_welcome);
        Bundle b = getIntent().getExtras();
        if (!b.isEmpty()) {
            String username = b.getString("userName");
            int id = b.getInt("userId");
            tv_name.setText("welcome " + username + " your id is " + id);
        }
        lv = (ListView) findViewById(R.id.list);
        final String Month[] = {"jan", "feb", "mar", "apr", "may",
                "jan", "feb", "mar", "apr", "may",
                "jan", "feb", "mar", "apr", "may"};
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, Month);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), Month[position], Toast.LENGTH_LONG).show();

            }
        });
        Ascending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(Month);
                ArrayAdapter<String> aa = new ArrayAdapter<String>(second_screen.this, android.R.layout.simple_list_item_1, android.R.id.text1, Month);
                lv.setAdapter(aa);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(), Month[position], Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        Descending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(Month);
                List list = Arrays.asList(Month);
                Collections.reverse(list);
                ArrayAdapter<String> aa = new ArrayAdapter<String>(second_screen.this, android.R.layout.simple_list_item_1, android.R.id.text1, Month);
                lv.setAdapter(aa);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(), Month[position], Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        registerForContextMenu(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 01, 2, "Friends");
        menu.add(1, 02, 1, "Family");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 01:
                Toast.makeText(getApplicationContext(), "Friends", Toast.LENGTH_LONG).show();
                break;
            case 02:
                Toast.makeText(getApplicationContext(), "Family", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu Ex");
        menu.add(0, 01, 1, "Context menu1");
        menu.add(0, 02, 2, "Context menu2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 01) {
            Toast.makeText(getApplicationContext(), "Clicked on " + item.getTitle(), Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == 02) {
            Toast.makeText(getApplicationContext(), "Clicked on " + item.getTitle(), Toast.LENGTH_LONG).show();

        }
        return super.onContextItemSelected(item);
    }


}