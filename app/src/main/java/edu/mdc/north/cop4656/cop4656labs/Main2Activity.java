package edu.mdc.north.cop4656.cop4656labs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d(TAG, "In the onCreate() method");
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "In the onStart() method");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(TAG, "In the onRestart() method");
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "In the onResume() method");
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "In the onPause() method");
    }

    public void onStop() {
        super.onStop();
        Log.d(TAG, "In the onStop() method");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "In the onDestroy() method");
    }
}
