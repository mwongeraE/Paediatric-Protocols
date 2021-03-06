package bpp.kelvian.com;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by kelvian on 2/21/17.
 */

public class ShockActivity extends Activity {

    TextView results;
    WebView notes;
    EditText inputweight;
    int factor=20;
    Button btn,btn1;
    String Noted= " Ringers 20 mls/kg over 15 mins,"
            +"\n Treat for hypoglycaemia"
            +"\n Start ORS 5 mls/kg/hr once able to drink";
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shock);
        //getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f9a614")));
        results=(TextView)findViewById(R.id.textResults);
        notes=(WebView)findViewById(R.id.webView);
        inputweight=(EditText)findViewById(R.id.editText1);
        btn=(Button)findViewById(R.id.button1);
        //btn1=(Button)findViewById(R.id.button2);
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
                    results.setText("Ringers/Hartmanns: "+ resulting+" mls");
                    notes.loadData(Noted, "text/html", "UTF-8");


                }else{

                    Toast.makeText(getApplicationContext(), "Input the Weight", Toast.LENGTH_SHORT).show();

                }
            }
        });

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }
    public void removetheKeyboard(){
        //First remove the virtual keyboad.


        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputweight.getWindowToken(), 0);
    }


}
