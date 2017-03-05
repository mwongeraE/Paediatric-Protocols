package com.mwongera.paediatric_protocols;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mwongera on 3/5/17.
 */

public class PlanBActivity extends Activity {

    TextView results;
    WebView notes;
    EditText inputweight;
    int factor=75;
    Button btn,btn1;
    String Noted= "1) Continue breast feeding "
            + " as tolerated"
            +"\n Reassess at 4 hrs and treat according to classification"
            +"\n Conside Immediate blood transfusion if severe pallor or Hb <5g/dl on admission";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_b);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f9a614")));
        results=(TextView)findViewById(R.id.textResults);
        notes=(WebView)findViewById(R.id.webView1);
        inputweight=(EditText)findViewById(R.id.weight);
        btn=(Button)findViewById(R.id.button1);
        btn1=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Double weight;
                Double resulting;

                if (inputweight.getText().toString().trim().length()!=0){
                    removetheKeyboard();
                    weight= Double.parseDouble(inputweight.getText().toString());
                    resulting=weight*factor;
                    results.setText("Oral/ng ORS over 4 hours: \n"+ resulting+" mls ");
                    notes.loadData(Noted, "text/html", "UTF-8");


                }else{

                    Toast.makeText(getApplicationContext(), "Input the Weight", Toast.LENGTH_SHORT).show();

                }


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                results.setText("");
                inputweight.setText("");
                notes.clearView();

            }
        });

    }
    public void removetheKeyboard(){
        //First remove the virtual keyboad.


        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputweight.getWindowToken(), 0);
    }



}