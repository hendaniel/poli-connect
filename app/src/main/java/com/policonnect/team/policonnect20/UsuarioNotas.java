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
public class UsuarioNotas extends Activity {

    private ArrayList<Notas> listDatos;
    private RecyclerView mRecycle;
    private ImageButton mBackButton;
    private TextView mTitle;
    private boolean orderedByDisponibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_notas);

        orderedByDisponibility = false;
        setNotas();
        orderCubiculosByDate();

        mBackButton = findViewById(R.id.backButton);
        mRecycle = findViewById(R.id.recyclerNotas);
        mTitle = findViewById(R.id.title);

        mTitle.setText(getString(R.string.notas));

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ListaDeNotas adapter = new ListaDeNotas(listDatos);
        mRecycle.setAdapter(adapter);
    }

    /**
     * Este método ordena los cubículos o servicios por números
     */
    private void orderCubiculosByDate() {
        Collections.sort(listDatos, new Comparator<Notas>() {
            @Override
            public int compare(Notas o1, Notas o2) {
                int n1 = o1.getDate();
                int n2 = o2.getDate();
                return Integer.compare(n1, n2);
            }
        });
    }

    /**
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recycle
     * View
     */
    private void setNotas() {
        listDatos = DataBase.getListDataUGrades();
    }

}
