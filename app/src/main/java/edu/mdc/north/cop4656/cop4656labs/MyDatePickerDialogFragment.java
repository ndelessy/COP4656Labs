package edu.mdc.north.cop4656.cop4656labs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MyDatePickerDialogFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public MyDatePickerDialogFragment() {
        // Required empty public constructor
    }

    public static MyDatePickerDialogFragment newInstance() {
        MyDatePickerDialogFragment fragment = new MyDatePickerDialogFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Toast toast = Toast.makeText(getActivity(), "Date chosen: " +year+"/"+ month+'/'+day, Toast.LENGTH_LONG);
        toast.show();
    }

}