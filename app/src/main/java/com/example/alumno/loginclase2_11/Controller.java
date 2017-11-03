package com.example.alumno.loginclase2_11;

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
    Thread t2;

    public Controller(){
        this.handler = new Handler(this);
        this.t1 = new Thread(new Hilo(handler));
        this.t2 = new Thread(new Hilo(handler));
        t1.start();
        t2.start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        try {
            JSONObject jsonObject = new JSONObject(msg.obj.toString());

            if(jsonObject.getInt("codigo") == 200){
                //abro una nueva activity en blanco
            }
            else{
                Log.d("respuesta", "El usuario o clave es incorrecto")
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }
}
