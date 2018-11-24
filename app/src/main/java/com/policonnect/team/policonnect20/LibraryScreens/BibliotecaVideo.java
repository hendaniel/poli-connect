package com.policonnect.team.policonnect20.LibraryScreens;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
 * Esta clase maneja la pantalla que muestra los cubiculos de video disponibles y no disponibles
 * de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class BibliotecaVideo extends Activity {

    private static ArrayList<Servicio> listDatos;
    private static RecyclerView mRecycle;
    private ImageButton mBackButton;
    private TextView mTitle;
    private ImageView mBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_service);

        setCubiculos();

        mBackButton = findViewById(R.id.backButton);
        mRecycle = findViewById(R.id.recyclerCubiculos);
        mTitle = findViewById(R.id.title);
        mBackground = findViewById(R.id.background_image_library);

        mTitle.setText(getString(R.string.cubiculosVideo));
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
    private void setCubiculos() {
        listDatos = DataBase.getListDataBVideo();
    }

    /**
     * Este metodo coloca en pantalla la lista que esta actualmente en el Array List
     */
    public static void setView() {
        ListaDeServicios adapter = new ListaDeServicios(listDatos);
        if (mRecycle != null)
            mRecycle.setAdapter(adapter);
    }
}
