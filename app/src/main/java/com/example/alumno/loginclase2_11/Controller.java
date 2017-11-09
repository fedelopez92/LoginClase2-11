package com.example.alumno.loginclase2_11;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
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
    int codigo;

    public Controller(Activity activity, Modelo modelo){
        this.activty = activity;
        this.modelo = modelo;
        this.handler = new Handler(this);
        this.t1 = new Thread(new Hilo(handler, modelo));
    }

    @Override
    public boolean handleMessage(Message msg) {
        try {
            JSONObject jsonObject = new JSONObject(msg.obj.toString());
            codigo = jsonObject.getInt("codigo");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void Ingresar(){

        if(codigo == 200){
            Intent intent = new Intent(activty, Main2Activity.class);
            activty.startActivity(intent);
        }
        else{
            Log.d("respuesta", "El usuario o clave es incorrecto");
        }
    }
}
