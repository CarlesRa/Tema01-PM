package com.carlesramos.pedrapapertisora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivPrincipal;
    private Button btPiedra;
    private Button btPapel;
    private Button btTijera;
    private Button btNuevoJuego;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPrincipal = findViewById(R.id.ivPrincipal);
        btPiedra = findViewById(R.id.btPiedra);
        btPapel = findViewById(R.id.btPapel);
        btTijera = findViewById(R.id.btTijera);
        tvResultado = findViewById(R.id.tvResultado);
        btNuevoJuego = findViewById(R.id.btNuevoJuego);

        btPiedra.setOnClickListener(this);
        btPapel.setOnClickListener(this);
        btTijera.setOnClickListener(this);
        btNuevoJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btNuevoJuego.setVisibility(View.INVISIBLE);
                btPiedra.setVisibility(View.VISIBLE);
                btPapel.setVisibility(View.VISIBLE);
                btTijera.setVisibility(View.VISIBLE);
                tvResultado.setText("");
                ivPrincipal.setImageResource(R.drawable.piedratransparente);
            }
        });

    }

    @Override
    public void onClick(View v){
        int numRandom = getRandom();
        btPiedra.setVisibility(View.INVISIBLE);
        btPapel.setVisibility(View.INVISIBLE);
        btTijera.setVisibility(View.INVISIBLE);
        btNuevoJuego.setVisibility(View.VISIBLE);
        //si el usuario gana
        if (v.getId() == R.id.btPiedra && numRandom == 2
        || v.getId() == R.id.btPapel && numRandom == 0
        || v.getId() == R.id.btTijera && numRandom == 1){
            tvResultado.setText(R.string.victoria);
        }
        //el usuario empata
        else if (v.getId() == R.id.btPiedra && numRandom == 0
                || v.getId() == R.id.btPapel && numRandom == 1
                || v.getId() == R.id.btTijera && numRandom == 2){
            tvResultado.setText(R.string.empate);
        }
        //el usuario pierde
        else{
            tvResultado.setText(R.string.derrota);
        }
    }

    private int getRandom(){
        Random rnd;
        int numRandom;
        rnd = new Random();
        numRandom = rnd.nextInt(3);
        if (numRandom == 0){
            ivPrincipal.setImageResource(R.drawable.piedra);
        }
        else if (numRandom == 1){
            ivPrincipal.setImageResource(R.drawable.papel);
        }
        else{
            ivPrincipal.setImageResource(R.drawable.tijeras);
        }
        return numRandom;
    }
}
