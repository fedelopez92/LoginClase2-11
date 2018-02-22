package com.example.alumno.loginclase2_11.Registro;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alumno on 02/11/2017.
 */

public class Hilo implements Runnable {

    Handler handler;
    Message message;
    Modelo modelo;

    public Hilo(Handler handler, Modelo modelo){

        this.handler = handler;
        this.modelo = modelo;
        this.message = new Message();
    }

    @Override
    public void run() {

        byte[] bytes = getBytesDataByPOST("http://192.168.1.38:3000/usuarios/nuevo");
        message.obj = new String(bytes);
        handler.sendMessage(message);
    }

    public byte[] getBytesDataByPOST (String strUrl){

        byte[] datos = null;

        Uri.Builder param = new Uri.Builder();
        param.appendQueryParameter("nombre", modelo.getNombre());
        param.appendQueryParameter("mail", modelo.getMail());
        param.appendQueryParameter("dni", modelo.getDni());
        param.appendQueryParameter("clave", modelo.getClave());
        String s = param.build().getEncodedQuery();//convierte el Uri.Builder en una query para enviar al servidor

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);//se usa para permitir que pueda usar el OutputStream. Por defecto esta en false
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(s);
            writer.flush();//Limpia el BufferedWriter
            //Para enviar la información hay que esperar que el BufferedWriter se llene
            //El flush() al limpiar el BufferedWriter va a hacer que se envie la informacion a pesar de que no este lleno
            writer.close();
            os.close();

            int response = urlConnection.getResponseCode();
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

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
            e.printStackTrace();
        }
        return datos;
    }
}
