package com.policonnect.team.policonnect20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * @version 1
 * @author: PoliConnect Team
 */
public class PantallaUsuario extends Fragment {

    private ImageButton mGrades;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pantalla_usuario, container, false);

        mGrades = view.findViewById(R.id.noteButton);

        setListenersButtons();

        return view;
    }

    private void setListenersButtons() {
        mGrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UsuarioNotas.class);
                startActivity(i);
            }
        });
    }
}
