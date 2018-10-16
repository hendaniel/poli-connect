package com.policonnect.team.policonnect20;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Esta clase maneja la pantalla que muestra los cubiculos de estudio disponibles y no disponibles
 * de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class BibliotecaCubiculos extends Activity {

    private ArrayList<Servicio> listDatos;
    private RecyclerView mRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_cubiculos);

        setCubiculos();
        orderCubiculosByDisponibility();

        mRecycle = findViewById(R.id.recyclerCubiculos);
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
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recicle
     * View
     */
    private void setCubiculos() {
        listDatos = new ArrayList<Servicio>();
        listDatos.add(new Servicio("Cubículo", 1, true, true));
        listDatos.add(new Servicio("Cubículo", 2, true, true));
        listDatos.add(new Servicio("Cubículo", 3, false, true));
        listDatos.add(new Servicio("Cubículo", 4, true, true));
        listDatos.add(new Servicio("Cubículo", 5, true, true));
        listDatos.add(new Servicio("Cubículo", 6, false, true));
        listDatos.add(new Servicio("Cubículo", 7, true, true));
        listDatos.add(new Servicio("Cubículo", 8, false, false));
        listDatos.add(new Servicio("Cubículo", 9, false, false));
        listDatos.add(new Servicio("Cubículo", 10, false, true));
        listDatos.add(new Servicio("Cubículo", 11, true, false));
        listDatos.add(new Servicio("Cubículo", 12, true, false));
        listDatos.add(new Servicio("Cubículo", 13, false, true));
        listDatos.add(new Servicio("Cubículo", 14, false, false));
        listDatos.add(new Servicio("Cubículo", 15, true, false));

    }

}
