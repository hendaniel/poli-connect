package com.policonnect.team.policonnect20.MainActivityFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaComputers;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaResource;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaStudy;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaVideo;
import com.policonnect.team.policonnect20.R;


/**
 * Este método maneja el menú principal de los servicios de la biblioteca
 *
 * @version 2
 * @author: PoliConnect Team
 */
public class PantallaBiblioteca extends Fragment {

    private ImageButton mComputer;
    private ImageButton mStudy;
    private ImageButton mVideo;
    private ImageButton mResource;
    private TextView mAvailableComputer;
    private TextView mAvailableStudy;
    private TextView mAvailableVideo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pantalla_biblioteca, container, false);

        setViews(view);
        setButtonsListeners();
        setAvailablesCounters();

        return view;
    }

    private void setAvailablesCounters() {
        mAvailableComputer.setText(DataBase.getAvailableComputerString());
        mAvailableStudy.setText(DataBase.getAvailableStudyString());
        mAvailableVideo.setText(DataBase.getAvailableVideoString());
    }

    private void setViews(View view) {
        mComputer = view.findViewById(R.id.computerButton);
        mStudy = view.findViewById(R.id.studyButton);
        mVideo = view.findViewById(R.id.videoButton);
        mResource = view.findViewById(R.id.resourceButton);
        mAvailableComputer = view.findViewById(R.id.numberCapacityComputer);
        mAvailableStudy = view.findViewById(R.id.numberCapacityStudy);
        mAvailableVideo = view.findViewById(R.id.numberCapacityVideo);
    }

    private void setButtonsListeners() {
        mComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BibliotecaComputers.class);
                startActivity(i);
            }
        });
        mStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BibliotecaStudy.class);
                startActivity(i);
            }
        });

        mVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BibliotecaVideo.class);
                startActivity(i);
            }
        });
        mResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BibliotecaResource.class);
                startActivity(i);
            }
        });
    }
}
