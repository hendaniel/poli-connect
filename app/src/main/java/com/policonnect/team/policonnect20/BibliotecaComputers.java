package com.policonnect.team.policonnect20;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Esta clase maneja la pantalla que muestra los computadores disponibles y no disponibles
 * de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class BibliotecaComputers extends Activity {

    private ArrayList<Servicio> listDatos;
    private RecyclerView mRecycle;
    private ImageButton mBackButton;
    private TextView mTitle;
    private boolean orderedByDisponibility;

    private static final String TAG = "BibliotecaComputers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_service);

        orderedByDisponibility = false;
        setComputers();

        mBackButton = findViewById(R.id.backButton);
        mRecycle = findViewById(R.id.recyclerCubiculos);
        mTitle = findViewById(R.id.title);

        mTitle.setText(getString(R.string.computadores));

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ListaDeServicios adapter = new ListaDeServicios(listDatos);
        mRecycle.setAdapter(adapter);

    }

    /**
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recycle
     * View
     */
    private void setComputers() {
        String name = getString(R.string.computador);
        listDatos = new ArrayList<>();
        for (int i = 0; i < 40; i += 5) {
            listDatos.add(new Servicio(name, 1 + i, true, false));
            listDatos.add(new Servicio(name, 2 + i, true, false));
            listDatos.add(new Servicio(name, 3 + i, false, false));
            listDatos.add(new Servicio(name, 4 + i, false, false));
            listDatos.add(new Servicio(name, 5 + i, true, false));
        }
        /*
        listDatos.add(new Servicio(name, 1, true, false));
        listDatos.add(new Servicio(name, 2, true, false));
        listDatos.add(new Servicio(name, 3, false, false));
        listDatos.add(new Servicio(name, 4, false, false));
        listDatos.add(new Servicio(name, 5, true, false));
        */
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
