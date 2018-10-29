package com.policonnect.team.policonnect20.MainActivityFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.policonnect.team.policonnect20.R;


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
        return view;
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
