package com.example.alumno.loginclase2_11.Login;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alumno.loginclase2_11.R;

/**
 * Created by Fede on 09/11/2017.
 */

public class Vista {
    public EditText mail;
    public EditText clave;
    public Button btnIngresar;
    public Button btnRegistrarse;

    public Vista(Activity activity){
        this.mail = (EditText) activity.findViewById(R.id.txtMail);
        this.clave = (EditText) activity.findViewById(R.id.txtPassword);
        this.btnIngresar = (Button) activity.findViewById(R.id.btnIngresar);
        this.btnRegistrarse = (Button) activity.findViewById(R.id.btnRegistrarse);
    }

    public void setearListener(View.OnClickListener myListener){
        this.btnIngresar.setOnClickListener(myListener);
        this.btnRegistrarse.setOnClickListener(myListener);
    }
}
