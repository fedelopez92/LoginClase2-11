package com.example.alumno.loginclase2_11.Login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.example.alumno.loginclase2_11.R;

/**
 * Created by alumno on 09/11/2017.
 */

public class MiDialogo extends android.support.v4.app.DialogFragment{

    public Escuchar escuchar;

    public MiDialogo(){
        this.escuchar = new Escuchar();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //getActivity() toma la activity que genero el dialogo

        builder.setTitle("Mensaje");
        builder.setMessage("Login exitoso");

        //para crear un dialogo con un layout propio:
        //View v = LayoutInflater.from(this).inflate(R.layout.layout);
        //builder.setView(v);

        builder.setPositiveButton("Aceptar", escuchar);//setPositiveButton significa que va a mostrar un boton positivo. Tambien esta el negativo y el neutral

        return builder.create();
    }
}
