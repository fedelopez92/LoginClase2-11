package com.example.alumno.loginclase2_11.Login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.alumno.loginclase2_11.Login.Controller;
import com.example.alumno.loginclase2_11.Login.Modelo;
import com.example.alumno.loginclase2_11.Login.Vista;
import com.example.alumno.loginclase2_11.Main2Activity;
import com.example.alumno.loginclase2_11.R;
import com.example.alumno.loginclase2_11.Registro.Main3Activity;

/**
 * Created by Fede on 09/11/2017.
 */

public class MyListener implements View.OnClickListener {

    public Modelo modelo;
    public Vista vista;
    public Controller controller;
    public Activity activity;

    public MyListener(Modelo modelo, Vista vista, Controller controller, Activity activity) {
        this.modelo = modelo;
        this.vista = vista;
        this.controller = controller;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnIngresar) {
            modelo.setMail(vista.mail.getText().toString());
            modelo.setClave(vista.clave.getText().toString());
            controller.t1.start();
        }

        if(v.getId() == R.id.btnRegistrarse){
            Intent intent = new Intent(activity, Main3Activity.class);
            activity.startActivity(intent);
        }
    }
}
