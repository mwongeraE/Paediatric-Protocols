package bpp.kelvian.com;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by kelvian on 3/4/17.
 */

public class HIV extends ListActivity{

    ListView lst;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_major_illness);
        //getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f9a614")));
        lst=getListView();
        String illness[]= getResources().getStringArray(R.array.HIV);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,illness));
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        openWorkplace(position);

    }

    private void openWorkplace(int ps) {

        if (ps == 0) {
            Intent i = new Intent(this, PITC.class);
            startActivity(i);

        } else if (ps == 1) {
            Intent i = new Intent(this, PMCT.class);
            startActivity(i);
        }
    }



}
