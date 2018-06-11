package edu.mdc.north.cop4656.cop4656labs;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main2ActivityFragment extends Fragment {

    private static final String TAG = "Fragment";

    public Main2ActivityFragment() {
        Log.d(TAG, "In the Main3ActivityFragment() method");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "In the onAttach() method");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "In the onCreate() method");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "In the onCreateView() method");
        return inflater.inflate(R.layout.fragment_main2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "In the onActivityCreated() method");
        super.onActivityCreated(savedInstanceState);
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "In the onStart() method");
    }



    public void onResume() {
        Log.d(TAG, "In the onResume() method");
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "In the onPause() method");
    }

    public void onStop() {
        super.onStop();
        Log.d(TAG, "In the onStop() method");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "In the onDestroyView() method");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "In the onDestroy() method");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "In the onDetach() method");
    }
}
