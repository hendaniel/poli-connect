package com.policonnect.team.policonnect20;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Esta clase maneja el Recycle View de todos los servicios de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class ListaDeNotas extends RecyclerView.Adapter<ListaDeNotas.ViewHolderDatos> {

    private static final String TAG = "ListaDeServicios";
    private ArrayList<Notas> listDatos;

    public ListaDeNotas(ArrayList<Notas> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario_notas, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    /**
     * Esta clase maneja como serán agregados los datos a cada item del Recycler View
     *
     * @version 1
     * @author: PoliConnect Team
     */
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView stateFrame;
        TextView state;
        TextView name;
        TextView grade;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            stateFrame = itemView.findViewById(R.id.stateFrame);
            state = itemView.findViewById(R.id.itemState);
            name = itemView.findViewById(R.id.itemName);
            grade = itemView.findViewById(R.id.itemGrade);
            Log.d(TAG, "Puesto");
        }

        public void asignarDatos(Notas nota) {
            double valGrade = nota.getGrade();
            int date = nota.getDate();
            name.setText(nota.getMateria());
            grade.setText(nota.getGradeString());
            if (date < 182)
                if (nota.getState()<0) {
                    stateFrame.setImageResource(R.drawable.short_rectangle_red);
                    state.setText(R.string.reprobado);
                }
                else if (nota.getState()>0) {
                    stateFrame.setImageResource(R.drawable.short_rectangle_green);
                    state.setText(R.string.aprobado);
                }

        }
    }
}
