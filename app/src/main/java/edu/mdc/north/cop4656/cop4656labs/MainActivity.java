package edu.mdc.north.cop4656.cop4656labs;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements BlankFragment.OnFragmentInteractionListener
    , MyDialogFragment.OnMyDialogConfirmedListener
   , SignInDialogFragment.OnCredentialEnteredListener {
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


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) { // in portrait mode
            BlankFragment fragment = BlankFragment.newInstance("param1", "param2");
            fragmentTransaction.add(R.id.fragmentContainer, fragment, "BLANK_FRAGMENT_TAG");
            //Unlike activities, fragments must be explicitly added to the backstack:
            fragmentTransaction.addToBackStack("BLANK_FRAGMENT_BACKSTACK_TAG");
            Log.d(TAG, "____________landscape") ;
        } else {
            Log.d(TAG, "____________portrait") ;
            //We cannot reuse the reference created above since the Android system re-creates the fragment for us after a configuration change..
            BlankFragment fragment =  (BlankFragment) getSupportFragmentManager().findFragmentByTag("BLANK_FRAGMENT_TAG");
            if(fragment != null) {
                fragmentTransaction.remove(fragment);
            }
        }

        fragmentTransaction.commit();

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
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("SCORE", 34543);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG, "Communicated with Activity");
    }

    @Override
    public void onDialogConfirmed() {
        Toast.makeText(this, "Action confirmed!!!!!!", Toast.LENGTH_LONG).show();
    }

    public void showDialog(View view) {
        MyDialogFragment newFragment = MyDialogFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "showBasicDialog");
    }

    public void showDatePickerDialog(View view) {
        MyDatePickerDialogFragment newFragment = MyDatePickerDialogFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "showDatePickerDialog");
    }

    public void signInDialog(View view) {
        SignInDialogFragment newFragment = SignInDialogFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "signInDialog");
    }

    @Override
    public void authenticate(String username, String password) {
        if(username.equals("admin") && password.equals("nimda")){
            Toast.makeText(this, "Authenticated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Wrong username and/or password", Toast.LENGTH_LONG).show();
        }

    }
}