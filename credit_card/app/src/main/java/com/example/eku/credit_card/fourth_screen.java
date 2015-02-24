package com.example.eku.credit_card;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DELL on 11-02-2015.
 */
public class fourth_screen extends Activity {
    TextView tv;
    EditText et1,et2,et3,et4,et5,et6;
    Button comp,clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_name);
        et1=(EditText)findViewById(R.id.editText2);
        et2=(EditText)findViewById(R.id.editText3);
        et3=(EditText)findViewById(R.id.editText4);
        et4=(EditText)findViewById(R.id.editText5);
        et5=(EditText)findViewById(R.id.editText6);
        et6=(EditText)findViewById(R.id.editText7);
        comp=(Button)findViewById(R.id.b1);
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int card_bal = Integer.parseInt(et1.getText().toString());
                int interest_yearly= Integer.parseInt(et2.getText().toString());
                int  month_p = Integer.parseInt(et3.getText().toString());
                float month_in,month_pri,month_bal ;
                month_in= Math.round((card_bal * (interest_yearly / (100 * 12))));
                month_pri= month_p-month_in;
                month_bal = card_bal- month_pri;


                et4.setText(String.valueOf(month_in));
                et5.setText(String.valueOf(month_pri));
                et6.setText(String.valueOf(month_bal));

                Toast.makeText(getApplicationContext(),String.valueOf(month_in),Toast.LENGTH_LONG).show();


            }
        });

    }
}
