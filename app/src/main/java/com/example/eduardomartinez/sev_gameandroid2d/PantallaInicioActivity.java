package com.example.eduardomartinez.sev_gameandroid2d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PantallaInicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void iniciarJuego(View v){
        Intent juegoActivity = new Intent(PantallaInicioActivity.this, MainActivity.class);

        startActivity(juegoActivity);
    }
}
