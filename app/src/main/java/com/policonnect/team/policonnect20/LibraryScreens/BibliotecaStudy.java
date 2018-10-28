package com.policonnect.team.policonnect20.LibraryScreens;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.ListAdapters.ListaDeServicios;
import com.policonnect.team.policonnect20.R;
import com.policonnect.team.policonnect20.Objects.Servicio;

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
        orderCubiculosByNumber();

        mBackButton = findViewById(R.id.backButton);
        mRecycle = findViewById(R.id.recyclerCubiculos);
        mTitle = findViewById(R.id.title);

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
        listDatos=DataBase.getListDataBStudy();
    }

}
