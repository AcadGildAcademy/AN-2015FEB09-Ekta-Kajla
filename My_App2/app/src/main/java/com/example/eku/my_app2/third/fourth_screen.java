package com.example.eku.my_app2.third;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eku.my_app2.R;

/**
 * Created by DELL on 11-02-2015.
 */
public class fourth_screen extends Activity {
    TextView tv;
    EditText et1,et2,et3;
    Button comp,clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_name);
        et1=(EditText)findViewById(R.id.editText2);
        et2=(EditText)findViewById(R.id.editText3);
        et3=(EditText)findViewById(R.id.editText4);
        comp=(Button)findViewById(R.id.b1);
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String card_bal=et1.getText().toString();
                String interest_yearly=et2.getText().toString();
                String month_p =et3.getText().toString();
            }
        });

    }
}
