package com.policonnect.team.policonnect20.UserScreens;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.policonnect.team.policonnect20.DataBase;
import com.policonnect.team.policonnect20.ListAdapters.ListaDeMaterias;
import com.policonnect.team.policonnect20.Objects.Subject;
import com.policonnect.team.policonnect20.R;

import java.util.ArrayList;


/**
 * Esta clase maneja la pantalla que muestra los cubiculos de estudio disponibles y no disponibles
 * de la biblioteca
 *
 * @version 2
 * @author: PoliConnect Team
 */
public class UsuarioHorario extends Activity {
    private ImageButton mBackButton;
    private TextView mTitle;
    private static ExpandableListView mListView;
    private static ListaDeMaterias mListAdapter;
    private static ArrayList<Subject>[] listDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_horario);

        setHorario();

        mBackButton = findViewById(R.id.backButton);
        mTitle = findViewById(R.id.title);

        mTitle.setText(getString(R.string.horario));

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mListView = findViewById(R.id.ScheduleList);
        mListAdapter = new ListaDeMaterias(this, listDatos);
        setView();


    }

    /**
     * Este método agrega a todos los servicios a un Array List para que sea mostrado en el Recycle
     * View
     */
    private void setHorario() {
        listDatos = DataBase.getListDataUSchedule();
    }

    public static ArrayList<Subject>[] getHorario() {
        return listDatos;
    }

    public static void setView() {
        if (mListView != null)
            mListView.setAdapter(mListAdapter);
    }

}
