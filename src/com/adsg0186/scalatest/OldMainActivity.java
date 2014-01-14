package com.adsg0186.scalatest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OldMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ToastMessage.makeToastButton((Button)findViewById(R.id.toastbutton), getApplicationContext());
        ToastMessage.makeToastButton2((Button)findViewById(R.id.toastbutton), getApplicationContext());
        
        Button b = (Button) findViewById(R.id.testbutton);
        b.setOnClickListener(new OnClickListener() {
            // TODO: do this in Scala
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(OldMainActivity.this, TestActivity.class);
                OldMainActivity.this.startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
