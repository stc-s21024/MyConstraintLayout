package jp.suntech.s21024.myconstraintlayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogFragment extends DialogFragment {
    String show;
    ConfirmDialogFragment(String msg){
        this.show = msg;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dbtn_ok,new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dbtn_ng,new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
//                            msg = show;
                    Toast.makeText(getActivity(), show, Toast.LENGTH_LONG).show();

                    break;
                case DialogInterface.BUTTON_NEGATIVE:
//                            msg = getString(R.string.dialog_cancel);
                    Toast.makeText(getActivity(), getString(R.string.dialog_cancel), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}
