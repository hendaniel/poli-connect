package com.policonnect.team.policonnect20.ListAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.policonnect.team.policonnect20.Objects.Servicio;
import com.policonnect.team.policonnect20.R;

import java.util.ArrayList;

/**
 * Esta clase maneja el Recycle View de todos los servicios de la biblioteca
 *
 * @version 1
 * @author: PoliConnect Team
 */
public class ListaDeServicios extends RecyclerView.Adapter<ListaDeServicios.ViewHolderDatos> {

    private static final String TAG = "ListaDeServicios";
    private ArrayList<Servicio> listDatos;

    public ListaDeServicios(ArrayList<Servicio> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_biblioteca_service, null, false);
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
        TextView name;
        ImageView back;
        TextView numb;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemCubName);
            back = itemView.findViewById(R.id.itemBack);
            numb = itemView.findViewById(R.id.itemCubNum);
            //Log.d(TAG, "Puesto");
        }

        public void asignarDatos(Servicio servicio) {
            name.setText(servicio.getName());
            numb.setText(servicio.getNumberString());

            if (servicio.getIdServicio() == 2)
                if (servicio.isOccupied())
                    back.setImageResource(R.drawable.library_pc_unavailable);
                else
                    back.setImageResource(R.drawable.library_pc_available);
            else if (servicio.isOccupied() && servicio.isGroup())
                back.setImageResource(R.drawable.library_group_unavaliable);
            else if (servicio.isOccupied() && !servicio.isGroup())
                back.setImageResource(R.drawable.library_one_unavaliable);
            else if (!servicio.isOccupied() && servicio.isGroup())
                back.setImageResource(R.drawable.library_group_avaliable);
            else
                back.setImageResource(R.drawable.library_one_avaliable);

        }
    }
}
