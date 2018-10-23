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
                return Integer.compare(n2, n1);
            }
        });
    }

    /**
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recycle
     * View
     */
    private void setNotas() {

        listDatos = new ArrayList<>();
        listDatos.add(new Notas("Matemática",4.8,161));
        listDatos.add(new Notas("Algebra",3.0,162));
        listDatos.add(new Notas("Publicidad",2.98,181));
        listDatos.add(new Notas("Introducción a la Ingeniería",3.0,181));
        listDatos.add(new Notas("Francés I",2.98,181));
        listDatos.add(new Notas("Probabilidad",3.0,181));
        listDatos.add(new Notas("Estructura de Datos",2.98,181));
        listDatos.add(new Notas("Física I",3.0,181));
        listDatos.add(new Notas("Cálculo I",4.98,162));
        listDatos.add(new Notas("Cálculo II",3.0,171));
        listDatos.add(new Notas("Cálculo III",2.98,172));
        listDatos.add(new Notas("Bases de Datos",3.0,181));
        listDatos.add(new Notas("Programación de Computadores",5.0,162));
        listDatos.add(new Notas("Lecto-Escritura",3.0,181));

    }

}
