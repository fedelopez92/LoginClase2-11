package com.example.alumno.loginclase2_11;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Modelo modelo = new Modelo();
        Controller controller = new Controller(this, modelo);
        Vista vista = new Vista(this);
        MyListener myListener = new MyListener(modelo, vista, controller);
        vista.setearListener(myListener);
    }


}
