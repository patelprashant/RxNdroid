package com.practice.android.rxndroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder( getActivity() ).create();
        alertDialog.setTitle( "Alert" );
        alertDialog.setMessage( "Some important information!" );
        alertDialog.setButton( AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        } );
        return alertDialog;
    }

//    public void show(FragmentManager supportFragmentManager, String dialog_fragment) {
//    }
}
