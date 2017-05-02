package com.practice.android.rxndroid;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public static final String TAG = "LifecycleEvents";
    public static final String MESSAGE_KEY = "message_key";


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        Log.i( TAG, "onAttach: " );
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Log.i( TAG, "onCreate: " );
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i( TAG, "onCreateView: " );

        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_blank, container, false );
        Bundle arguments = getArguments();

        if (arguments != null) {
            String message = arguments.getString( MESSAGE_KEY );
            TextView tvMessage = (TextView) view.findViewById( R.id.message );
            tvMessage.setText( message );
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        Log.i( TAG, "onActivityCreated: " );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i( TAG, "onStart: " );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i( TAG, "onResume: " );
    }


    //Removing
    @Override
    public void onPause() {
        super.onPause();
        Log.i( TAG, "onPause: " );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i( TAG, "onStop: " );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i( TAG, "onDestroy: " );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i( TAG, "onDetach: " );
    }
}
