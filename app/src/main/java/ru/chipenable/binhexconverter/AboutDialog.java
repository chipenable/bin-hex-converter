package ru.chipenable.binhexconverter;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Pashgan on 24.05.2016.
 */
public class AboutDialog extends DialogFragment {

    public static void show(FragmentManager fm){
        AboutDialog dialog = new AboutDialog();
        dialog.show(fm, null);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.about);
        builder.setMessage(R.string.about_dialog_msg);
        builder.setPositiveButton(R.string.ok, null);

        return builder.create();
    }
}
