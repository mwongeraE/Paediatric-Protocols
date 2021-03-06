package bpp.kelvian.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by kelvian on 2/22/17.
 */
public class Jaundice extends Activity{

    ImageView imgv;
    AlertDialog dialog;

    PhotoViewAttacher mAttacher;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaundiceimages);
        //getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f9a614")));
        Intent i= getIntent();
        String imaged=i.getStringExtra("image");
        int pos= Integer.parseInt(imaged);
        imgv = (ImageView) findViewById(R.id.imageView1);
        switch(pos){
            case 0:
                //img.setImageResource(R.drawable.my_image);
                imgv.setImageResource(R.drawable.neonataljaundice2);
                break;
            case 1:
                imgv.setImageResource(R.drawable.neonataljaundice3);
                break;
            case 2:
                imgv.setImageResource(R.drawable.neonatalsepsis2);
                break;
            case 3:
                Intent ii= new Intent (Jaundice.this,DrugActivity1.class);
                startActivity(ii);

                finish();
                break;
        }
        mAttacher = new PhotoViewAttacher(imgv);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

}
