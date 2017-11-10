package com.example.alumno.loginclase2_11.Registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.loginclase2_11.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Modelo modelo = new Modelo();
        Controller controller = new Controller(this, modelo);
        Vista vista = new Vista(this);
        MyListener myListener = new MyListener(modelo, vista, controller);
        vista.setearListener(myListener);
    }
}
