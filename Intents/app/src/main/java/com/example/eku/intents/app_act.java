package com.example.eku.intents;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

/**
 * Created by DELL on 17-02-2015.
 */
public class app_act extends Activity {
    Button specific,developer,search;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity);

        specific=(Button)findViewById(R.id.b_specific);
        developer=(Button)findViewById(R.id.b_developer);
        search=(Button)findViewById(R.id.b_search);
        et=(EditText)findViewById(R.id.et_text);

        specific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final Uri marketUri=Uri.parse("https://play.google.com/store/apps/details?id=com.app.buyhatke&hl=en");
               Intent SearchIntent=(new Intent(Intent.ACTION_VIEW ,marketUri));
//
               startActivity(SearchIntent);
            }
        });
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Uri marketUri=Uri.parse("https://play.google.com/store/apps/developer?id=King&hl=en");
                startActivity(new Intent(Intent.ACTION_VIEW ,marketUri));


            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String srch=et.getText().toString();
                final Uri marketUri=Uri.parse("https://play.google.com/store/search?q="+ srch);
                startActivity(new Intent(Intent.ACTION_VIEW ,marketUri));



    }
           }
        );
    }
}