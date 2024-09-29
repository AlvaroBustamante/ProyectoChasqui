package com.example.proyectochasqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    List<Anuncios> anuncioslista;
    private Context context;

    public RVAdapter(List<Anuncios> anuncioslista, Context context) {
        this.anuncioslista = anuncioslista;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Categoria,Zona,Contenido,Nombre;
        ImageView fotoafiliado;

        public ViewHolder (View itemView){
            super(itemView);//llama los objetos de la clase maravilla
            Nombre=(TextView) itemView.findViewById(R.id.txtNombre);
            Categoria=(TextView) itemView.findViewById(R.id.txtCategoria);
            Contenido=(TextView) itemView.findViewById(R.id.txtContenido);
            Zona=(TextView) itemView.findViewById(R.id.txtZona);

        }
    }




    public RVAdapter(List<Anuncios>anuncioslista){
        this.anuncioslista=anuncioslista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_anuncios,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {


        holder.Nombre.setText(anuncioslista.get(position).getNombre());
        holder.Categoria.setText(anuncioslista.get(position).getCategoria());
        holder.Contenido.setText(anuncioslista.get(position).getContenido());
        holder.Zona.setText(anuncioslista.get(position).getZona());

    }

    @Override
    public int getItemCount() {

        return anuncioslista.size();
    }
}

