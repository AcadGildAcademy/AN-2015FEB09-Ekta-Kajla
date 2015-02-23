package com.example.eku.my_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DELL on 05-02-2015.
 */
public class first_screen extends Activity {
    EditText name,password;
    Button sign_in,cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_name);
        sign_in=(Button)findViewById(R.id.et_button);
        name=(EditText)findViewById(R.id.et_Text);
        password=(EditText)findViewById(R.id.et_Text2);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_value=name.getText().toString();
                String userpass_value=password.getText().toString();

                if (username_value.equals("ekta")&& userpass_value.equals("kajla")){
                    Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_LONG).show();


                   Intent intent=new Intent (first_screen.this,second_screen.class);
                    Bundle b=new Bundle();
                    b.putString("userName",username_value);
                    b.putInt("userId",1234);
                    intent.putExtras(b);


                    startActivity (intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"FAILURE",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
