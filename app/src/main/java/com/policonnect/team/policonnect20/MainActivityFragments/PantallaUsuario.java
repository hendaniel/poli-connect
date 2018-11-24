package com.policonnect.team.policonnect20.MainActivityFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.Login;
import com.policonnect.team.policonnect20.R;
import com.policonnect.team.policonnect20.UserScreens.UsuarioHorario;
import com.policonnect.team.policonnect20.UserScreens.UsuarioNotas;

import static android.content.ContentValues.TAG;

/**
 * @version 1
 * @author: PoliConnect Team
 */
public class PantallaUsuario extends Fragment {

    private ImageButton mGrades;
    private ImageButton mSchedule;
    private ImageButton mLogOut;
    private static TextView mUsername;
    private static TextView mUserCode;
    private FirebaseAuth auth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pantalla_usuario, container, false);

        auth = FirebaseAuth.getInstance();
        setViews(view);
        setButtonsListeners();

        setUserData();
        return view;
    }

    public  static  void setUserData(){
        mUsername.setText(DataBase.getStudentName());
        mUserCode.setText(DataBase.getStudentCode());
    }


    private void setViews(View view) {
        mLogOut = view.findViewById(R.id.logOutButton);
        mGrades = view.findViewById(R.id.noteButton);
        mSchedule = view.findViewById(R.id.scheduleButton);
        mUsername = view.findViewById(R.id.username);
        mUserCode = view.findViewById(R.id.codeUser);
    }

    private void setButtonsListeners() {
        mGrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UsuarioNotas.class);
                startActivity(i);
            }
        });
        mSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UsuarioHorario.class);
                startActivity(i);
            }
        });

        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext(), R.style.Theme_AppCompat_DayNight_Dialog);
                builder.setMessage(R.string.messageDialog)
                        .setTitle(R.string.titleDialog);
                builder.setPositiveButton(R.string.positiveDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        goToLoginActivity();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton(R.string.negativeDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }

                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }
        });
    }

    private void goToLoginActivity() {

        auth.signOut();
        System.exit(0);
    }
}
