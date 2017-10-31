package com.example.eduardomartinez.sev_gameandroid2d.modelos;

import android.content.Context;
import android.graphics.Canvas;

import com.example.eduardomartinez.sev_gameandroid2d.CargadorGraficos;
import com.example.eduardomartinez.sev_gameandroid2d.Habitacion;
import com.example.eduardomartinez.sev_gameandroid2d.R;
import com.example.eduardomartinez.sev_gameandroid2d.Utilidades;
import com.example.eduardomartinez.sev_gameandroid2d.graficos.Sprite;

/**
 * Created by eduardomartinez on 25/10/17.
 */

public class DisparoJugador extends Modelo {
    protected Sprite sprite;

    public double velocidadX;
    public double velocidadY;
    float sensibilidad = 20;
    float velocidad;


    public DisparoJugador(Context context, double x, double y, double orientacionX, double orientacionY) {
        super(context, x, y, 110, 110);

        cArriba = 6;
        cAbajo = 6;
        cDerecha = 6;
        cIzquierda = 6;
        velocidad = 10;

        sprite = new Sprite(CargadorGraficos.cargarDrawable(context,
                R.drawable.animacion_disparo1),
                ancho, altura,
                24, 4, true);

        inicializar(  orientacionX,  orientacionY);
    }

    protected void inicializar(double orientacionX, double orientacionY) {

        int orientacionDisparo = Utilidades.orientacion(orientacionX, orientacionY);

        if (orientacionDisparo == Jugador.DERECHA)
            velocidadX = velocidad;
        else if (orientacionDisparo == Jugador.IZQUIERDA)
            velocidadX = -velocidad;
        else if (orientacionDisparo == Jugador.ARRIBA)
            velocidadY = -velocidad;
        else if (orientacionDisparo == Jugador.ABAJO)
            velocidadY = velocidad;
    }

    public void actualizar(long tiempo) {
        sprite.actualizar(tiempo);
    }

    public void dibujar(Canvas canvas) {
        sprite.dibujarSprite(canvas, (int) x - Habitacion.scrollEjeX,  (int) y - Habitacion.scrollEjeY);
    }

    public DisparoJugador disparar(Context context, double x, double y, double orientacionPadDispararX, double orientacionPadDispararY) {
        return new DisparoJugador(context, x, y, orientacionPadDispararX, orientacionPadDispararY);
    }


}
