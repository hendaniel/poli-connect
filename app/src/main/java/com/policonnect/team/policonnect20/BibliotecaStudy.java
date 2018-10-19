package com.policonnect.team.policonnect20;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Esta clase maneja la pantalla que muestra los cubiculos de estudio disponibles y no disponibles
 * de la biblioteca
 *
 * @version 2
 * @author: PoliConnect Team
 */
public class BibliotecaStudy extends Activity {

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

        mTitle.setText(getString(R.string.cubiculosEstudio));

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
     * Este método ordena los cubículos o servicios por disponibilidad
     */
    private void orderCubiculosByDisponibility() {
        Collections.sort(listDatos, new Comparator<Servicio>() {
            @Override
            public int compare(Servicio o1, Servicio o2) {
                int n1 = o1.getNumber();
                int n2 = o2.getNumber();
                if (o1.isOccupied() == o2.isOccupied())
                    return Integer.compare(n1, n2);
                return Boolean.compare(o1.isOccupied(), o2.isOccupied());


            }
        });
    }

    /**
     * Este método ordena los cubículos o servicios por números
     */
    private void orderCubiculosByNumber() {
        Collections.sort(listDatos, new Comparator<Servicio>() {
            @Override
            public int compare(Servicio o1, Servicio o2) {
                int n1 = o1.getNumber();
                int n2 = o2.getNumber();
                return Integer.compare(n1, n2);
            }
        });
    }

    /**
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recycle
     * View
     */
    private void setCubiculos() {
        String name = getString(R.string.cubiculo);
        listDatos = new ArrayList<>();
        listDatos.add(new Servicio(name, 1, true, true));
        listDatos.add(new Servicio(name, 2, true, true));
        listDatos.add(new Servicio(name, 3, false, true));
        listDatos.add(new Servicio(name, 4, true, true));
        listDatos.add(new Servicio(name, 5, true, true));
        listDatos.add(new Servicio(name, 6, false, true));
        listDatos.add(new Servicio(name, 7, true, true));
        listDatos.add(new Servicio(name, 8, false, false));
        listDatos.add(new Servicio(name, 9, false, false));
        listDatos.add(new Servicio(name, 10, false, true));
        listDatos.add(new Servicio(name, 11, true, false));
        listDatos.add(new Servicio(name, 12, true, false));
        listDatos.add(new Servicio(name, 13, false, true));
        listDatos.add(new Servicio(name, 14, false, false));
        listDatos.add(new Servicio(name, 15, true, false));
    }

}