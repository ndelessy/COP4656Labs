package edu.mdc.north.cop4656.cop4656labs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ANDROID LIFECYCLE ";

    private static final String INT_TO_BE_SAVED = "Description of the int to be saved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        // Save the int in a bundle
        outState.putInt(INT_TO_BE_SAVED, 3);
        Log.d(TAG, "Saved in Bundle: " + outState.getInt(INT_TO_BE_SAVED) );

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        Log.d(TAG, "Restored from bundle: " + savedInstanceState.getInt(INT_TO_BE_SAVED) );
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void go2ButtonClicked(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("SCORE", 34543);
        startActivity(intent);
    }
}