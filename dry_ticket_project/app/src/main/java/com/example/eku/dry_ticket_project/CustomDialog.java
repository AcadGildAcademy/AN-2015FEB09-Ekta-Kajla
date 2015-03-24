package com.example.eku.dry_ticket_project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class CustomDialog extends DialogFragment {

    EditText username2, password2, email;

    public interface NewContactListener {
        void onFinishDialog(String text);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.custom_dialog, null);
        username2 = (EditText) view.findViewById(R.id.username_edit2);
        password2 = (EditText) view.findViewById(R.id.password_edit2);
        email = (EditText) view.findViewById(R.id.email_edit2);

        builder.setView(view);

        builder.setIcon(R.drawable.drytic);

        builder.setTitle(getText(R.string.title).toString());

        builder.setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String text = username2.getText().toString() + " " + password2.getText().toString() + " " + email.getText().toString();
                NewContactListener listener = (NewContactListener) getActivity();
                listener.onFinishDialog(text);
                dismiss();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });

        return builder.create();
    }

}
