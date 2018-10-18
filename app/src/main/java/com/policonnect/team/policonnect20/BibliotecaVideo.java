package com.policonnect.team.policonnect20;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Esta clase maneja la pantalla que muestra los cubiculos de video disponibles y no disponibles
 * de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class BibliotecaVideo extends Activity {

    private ArrayList<Servicio> listDatos;
    private RecyclerView mRecycle;
    private ImageButton mBackButton;
    private TextView mTitle;
    private boolean orderedByDisponibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_service);

        orderedByDisponibility = false;
        setCubiculos();

        mBackButton = findViewById(R.id.backButtonLibrary);
        mRecycle = findViewById(R.id.recyclerCubiculos);
        mTitle = findViewById(R.id.titleService);

        mTitle.setText(getString(R.string.cubiculosVideo));

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
    private void setCubiculos() {
        String name = getString(R.string.cubiculo);
        listDatos = new ArrayList<>();
        listDatos.add(new Servicio(name, 1, true, true));
        listDatos.add(new Servicio(name, 2, true, false));
        listDatos.add(new Servicio(name, 3, false, false));
        listDatos.add(new Servicio(name, 4, false, false));
        listDatos.add(new Servicio(name, 5, true, false));
    }
}
