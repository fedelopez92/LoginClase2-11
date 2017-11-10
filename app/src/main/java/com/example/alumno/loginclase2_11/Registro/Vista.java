package com.example.alumno.loginclase2_11.Registro;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumno.loginclase2_11.R;

/**
 * Created by Fede on 09/11/2017.
 */

public class Vista {

    public EditText nombre;
    public EditText mail;
    public EditText dni;
    public EditText clave;
    public Button btnRegistrarse;

    public Vista(Activity activity){
        this.nombre = (EditText) activity.findViewById(R.id.txtNombre);
        this.mail = (EditText) activity.findViewById(R.id.txtMail);
        this.dni = (EditText) activity.findViewById(R.id.txtDNI);
        this.clave = (EditText) activity.findViewById(R.id.txtPassword);
        this.btnRegistrarse = (Button) activity.findViewById(R.id.btnRegistrarse);
    }

    public void setearListener(View.OnClickListener myListener){
        this.btnRegistrarse.setOnClickListener(myListener);
    }
}
