package com.example.alumno.loginclase2_11.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.loginclase2_11.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Modelo modelo = new Modelo();
        Controller controller = new Controller(this, modelo);
        Vista vista = new Vista(this);
        MyListener myListener = new MyListener(modelo, vista, controller, this);
        vista.setearListener(myListener);
    }


}
