package com.example.alfredo.udbtour.Purposes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.alfredo.udbtour.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariel on 02/03/2018.
 */

public class PurposesAdapter extends RecyclerView.Adapter<PurposesAdapter.ViewHolder>  implements Filterable {


    private List<Purposes> purposesList;
    private List<Purposes> purposesListFilter;

    private int layout;
    private onItemClickListener listener;

    public PurposesAdapter(List<Purposes> Purposes, int layout, onItemClickListener listener) {
        this.purposesList = Purposes;
        this.layout = layout;
        this.listener = listener;
        purposesListFilter = Purposes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inlfamos el layout y le pasamos lso datos al constructor del view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //llamamos al metodo bind del viewholder pasandole el objdeto y un listener
        holder.bind(purposesListFilter.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return purposesListFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    purposesListFilter = purposesList;
                } else {
                    List<Purposes> filteredList = new ArrayList<>();
                    for (Purposes row : purposesList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getDescription().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    purposesListFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = purposesListFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                purposesListFilter = (ArrayList<Purposes>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface PurposessAdapterListener {
        void onPurposesSelected(Purposes Purposes);

    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView name;
        public TextView description;
        public TextView latitud;
        public TextView longitud;
        public Button prompPurpose;


        public ViewHolder(View v){

            //recibe la vista completa para que la rendericemos, pasamos parametros a constructor padre
            // aqui tambien manejamos los datos de logioca para extraer datos y hacer referencias con los elementoss
            super(v);
            this.name =(TextView) v.findViewById(R.id.purposeName);
            this.description = (TextView) v.findViewById(R.id.purposeDesc);
            this.latitud =(TextView) v.findViewById(R.id.purposeLat);
            this.longitud = (TextView) v.findViewById(R.id.purposeLon);
            this.prompPurpose = v.findViewById(R.id.prompPurpose);


        }

        public void bind(final Purposes Purposes, final  onItemClickListener listener){
            //procesamos los datos para renderizar

            name.setText(Purposes.getName());
            description.setText(Purposes.getDescription());
            latitud.setText(Purposes.getLat());
            longitud.setText(Purposes.getLon());

            // this.textViewPurposes.setText(Purposes.getName());
            /// definimos que por cada elemento del recycler view tenemos un listener que se va a comportart de la siguiente manera

            prompPurpose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(Purposes, getAdapterPosition());
                }
            });

        }

    }
    ///declaramos las interfaces con los metodos a implementar
    public interface onItemClickListener{
        void onItemClick(Purposes Purposes, int position);
    }
}
