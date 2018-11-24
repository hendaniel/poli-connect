package com.policonnect.team.policonnect20.LibraryScreens;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.GeneralMethods;
import com.policonnect.team.policonnect20.ListAdapters.ListaDeServicios;
import com.policonnect.team.policonnect20.Objects.Servicio;
import com.policonnect.team.policonnect20.R;

import java.util.ArrayList;

/**
 * Esta clase maneja la pantalla que muestra los computadores disponibles y no disponibles
 * de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class BibliotecaComputers extends Activity {

    private static ArrayList<Servicio> listDatos;
    private static RecyclerView mRecycle;
    private ImageButton mBackButton;
    private TextView mTitle;
    private ImageView mBackground;


    private static final String TAG = "BibliotecaComputers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_service);

        setComputers();

        mBackButton = findViewById(R.id.backButton);
        mRecycle = findViewById(R.id.recyclerCubiculos);
        mTitle = findViewById(R.id.title);
        mBackground = findViewById(R.id.background_image_library);

        mTitle.setText(getString(R.string.computadores));
        mBackground.setImageResource(GeneralMethods.getRandomBackGroundLibrary());

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        setView();

    }

    /**
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recycle
     * View
     */
    private void setComputers() {
        listDatos = DataBase.getListDataBComputer();
    }

    /**
     * Este metodo coloca en pantalla la lista que esta actualmente en el Array List
     */
    public static void setView() {
        ListaDeServicios adapter = new ListaDeServicios(listDatos);
        if (mRecycle != null)
            mRecycle.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
