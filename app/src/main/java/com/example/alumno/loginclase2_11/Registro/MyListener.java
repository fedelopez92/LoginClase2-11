package com.example.alumno.loginclase2_11.Registro;

import android.view.View;

/**
 * Created by Fede on 09/11/2017.
 */

public class MyListener implements View.OnClickListener {

    public Modelo modelo;
    public Vista vista;
    public Controller controller;

    public MyListener(Modelo modelo, Vista vista, Controller controller) {
        this.modelo = modelo;
        this.vista = vista;
        this.controller = controller;
    }

    @Override
    public void onClick(View v) {
        modelo.setNombre(vista.nombre.getText().toString());
        modelo.setMail(vista.mail.getText().toString());
        modelo.setDni(vista.dni.getText().toString());
        modelo.setClave(vista.clave.getText().toString());
        controller.t1.start();
    }
}
