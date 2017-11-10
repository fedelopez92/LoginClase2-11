package com.example.alumno.loginclase2_11.Registro;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alumno on 02/11/2017.
 */

public class Controller implements Handler.Callback {

    Handler handler;
    Thread t1;
    Activity activty;
    Modelo modelo;
    JSONObject jsonObject;

    public Controller(Activity activity, Modelo modelo){
        this.activty = activity;
        this.modelo = modelo;
        this.handler = new Handler(this);
        this.t1 = new Thread(new Hilo(handler, modelo));
    }

    @Override
    public boolean handleMessage(Message msg) {
            try {
                jsonObject = new JSONObject(msg.obj.toString());
                Registrar();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void Registrar(){

        try {
            Log.d("texto", jsonObject.getString("mensaje"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
