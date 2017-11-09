package com.example.alumno.loginclase2_11;

import android.app.Notification;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Handler;

/**
 * Created by alumno on 02/11/2017.
 */

public class Hilo implements Runnable {

    android.os.Handler handler;
    Message message;
    Modelo modelo;

    public Hilo(android.os.Handler handler, Modelo modelo){

        this.handler = handler;
        this.modelo = modelo;
    }

    @Override
    public void run() {

        byte[] bytes = getBytesData("http://192.168.1.38:3000/usuarios/"+modelo.getMail()+"/"+modelo.getClave());
        message.obj = new String(bytes);
        handler.sendMessage(message);
    }

    public byte[] getBytesData(String strUrl){

        byte[] datos = null;

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int response = urlConnection.getResponseCode();
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //el ByteArrayOutputStream es donde va a guardar la informacion que me trae el servidor

            if(response == 200){

                byte[] buffer = new byte[1024];
                int length = 0;
                while((length = is.read(buffer)) != -1 ){
                    baos.write(buffer, 0, length);
                }
                is.close();
                datos = baos.toByteArray();
            }
            else
            {
                Log.d("texto", "no se pudo conectar");
            }

        } catch (IOException e) {
            //se pone IOException porque va a capturar todas las excepciones que puede tirar la conexion
            e.printStackTrace();
        }
        return datos;
    }
}
