package com.example.eku.my_app2.third;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eku.my_app2.R;


/**
 * Created by DELL on 10-02-2015.
 */
public class third_screen extends Activity {
    ImageView imgv;
    TextView tv;
    Button hidebutton, seekbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.third_name);

        hidebutton = (Button) findViewById(R.id.hide);
        imgv=(ImageView)findViewById(R.id.img);

        hidebutton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(hidebutton.getText().equals("HIDE")) {
                    imgv.setVisibility(View.INVISIBLE);
                    hidebutton.setText("SEEK");
                }
                else if(hidebutton.getText().equals("SEEK"))
                {
                    imgv.setVisibility(View.VISIBLE);
                    hidebutton.setText("HIDE");
                }




            }
        });

    }

}