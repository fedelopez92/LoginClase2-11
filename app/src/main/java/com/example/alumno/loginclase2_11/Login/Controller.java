package com.example.alumno.loginclase2_11.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.alumno.loginclase2_11.Main2Activity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alumno on 02/11/2017.
 */

public class Controller implements Handler.Callback {

    Handler handler;
    Thread t1;
    MainActivity mainActivity;
    Modelo modelo;
    JSONObject jsonObject;

    public Controller(MainActivity activity, Modelo modelo){
        this.mainActivity = activity;
        this.modelo = modelo;
        this.handler = new Handler(this);
        this.t1 = new Thread(new Hilo(handler, modelo));
    }

    @Override
    public boolean handleMessage(Message msg) {
            try {
                jsonObject = new JSONObject(msg.obj.toString());
                Ingresar();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void Ingresar(){

        try {
            if(jsonObject.getInt("codigo") == 200){
                //Intent intent = new Intent(mainActivity, Main2Activity.class);
                //mainActivity.startActivity(intent);

                MiDialogo dialogo = new MiDialogo();
                dialogo.show(mainActivity.getSupportFragmentManager(), "");
            }
            else{
                Log.d("respuesta", "El usuario o clave es incorrecto");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
