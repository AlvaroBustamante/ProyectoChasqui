package com.example.proyectochasqui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnunciosActivity extends AppCompatActivity{
    public static final String user="names";
    RecyclerView recyclerAnuncio;
    RVAdapter rvAdapter;

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        tv1=(TextView)findViewById(R.id.TvMostrar);
        String user=getIntent().getStringExtra("names");
        tv1.setText("Bienvenido(a): "+user);


        //InicializarElementos();


    }
    /*
    private void InicializarElementos(){
        recyclerAnuncio=findViewById(R.id.rvanuncios);
        recyclerAnuncio.setLayoutManager(new LinearLayoutManager(this));

        List<Anuncios> anucioslista=new ArrayList<>();

        rvAdapter=new RVAdapter(anucioslista,this);
        recyclerAnuncio.setAdapter(rvAdapter);

    }

     */
}
