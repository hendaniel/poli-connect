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

import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaComputers;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaResource;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaStudy;
import com.policonnect.team.policonnect20.LibraryScreens.BibliotecaVideo;
import com.policonnect.team.policonnect20.R;
import com.policonnect.team.policonnect20.WelfareScreens.BienestarBaile;
import com.policonnect.team.policonnect20.WelfareScreens.BienestarGuitarraAcustica;
import com.policonnect.team.policonnect20.WelfareScreens.BienestarGuitarraElectrica;
import com.policonnect.team.policonnect20.WelfareScreens.BienestarGym;
import com.policonnect.team.policonnect20.WelfareScreens.BienestarPintura;
import com.policonnect.team.policonnect20.WelfareScreens.BienestarTenis;


/**
 * @version 1
 * @author: PoliConnect Team
 */
public class PantallaBienestar extends Fragment {
    private ImageButton mTenisButton;
    private ImageButton mElectricGuitarButton;
    private ImageButton mGymButton;
    private ImageButton mDancingButton;
    private ImageButton mAcousticGuitarButton;
    private ImageButton mDrawButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pantalla_bienestar, container, false);
        setViews(view);
        setButtonsListeners();
        return view;
    }

    private void setButtonsListeners() {
        mTenisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BienestarTenis.class);
                startActivity(i);
            }
        });
        mElectricGuitarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BienestarGuitarraElectrica.class);
                startActivity(i);
            }
        });

        mGymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BienestarGym.class);
                startActivity(i);
            }
        });
        mDancingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BienestarBaile.class);
                startActivity(i);
            }
        });
        mAcousticGuitarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BienestarGuitarraAcustica.class);
                startActivity(i);
            }
        });
        mDrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BienestarPintura.class);
                startActivity(i);
            }
        });
    }

    private void setViews(View view) {
        mTenisButton = view.findViewById(R.id.tenisButton);
        mElectricGuitarButton = view.findViewById(R.id.electricGuitarButton);
        mGymButton = view.findViewById(R.id.gymButton);
        mDancingButton = view.findViewById(R.id.dancingButton);
        mAcousticGuitarButton = view.findViewById(R.id.acousticGuitarButton);
        mDrawButton = view.findViewById(R.id.drawButton);
    }
}
