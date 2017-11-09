package com.example.alumno.loginclase2_11;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Fede on 09/11/2017.
 */

public class Vista {
    public EditText mail;
    public EditText clave;
    public Button btnIngresar;

    public Vista(Activity activity){
        this.mail = (EditText) activity.findViewById(R.id.txtMail);
        this.clave = (EditText) activity.findViewById(R.id.txtPassword);
        this.btnIngresar = (Button) activity.findViewById(R.id.btnIngresar);
    }

    public void setearListener(View.OnClickListener myListener){
        this.btnIngresar.setOnClickListener(myListener);
    }
}
