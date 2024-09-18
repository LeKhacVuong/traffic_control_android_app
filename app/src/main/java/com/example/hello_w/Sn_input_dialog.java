package com.example.hello_w;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Sn_input_dialog extends AppCompatDialogFragment {
    private static final String TAG = "vuong_lk_sn_dialog";

    sn_input_dialog_if snInputDialogIf;

    EditText sn_input;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.sn_input_layout, null);

        builder.setView(view)
                .setTitle("Enter light serial number")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String light_sn = sn_input.getText().toString();
                        Log.d(TAG, "User input SN " + light_sn);
                        snInputDialogIf.user_typed_light_sn(light_sn);
                    }
                });

        sn_input = view.findViewById(R.id.editSnLight);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        snInputDialogIf = (sn_input_dialog_if) context;
        super.onAttach(context);
    }

    public interface sn_input_dialog_if{
        public void user_typed_light_sn(String sn);
    }
}
