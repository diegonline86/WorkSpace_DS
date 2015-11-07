package com.salesianostriana.pmdm.reproductormusica;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import java.io.IOException;

public class ServicioMusica extends Service implements View.OnClickListener{
    NotificationCompat.Builder mBuilder;
    int mNotificationId = 1;
    NotificationManager mNotifyMgr;
    MediaPlayer mediaPlayer;
    boolean pause;


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_btn_play)
                .setContentTitle("Reproduciendo")
                .setContentText("");

        mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        
        pause = false;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Bundle extras = intent.getExtras();
        String nombreCancion = extras.getString("cancion");
        String url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3"; // your URL here

        // Le pongo a la notificación el nombre de la canción que recibo
        mBuilder.setContentText(nombreCancion);

        // Instancio el mediaPlay con la canción que recibo uriCancion = R.raw.michael_buble

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Publico la notificación.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {

        mBuilder.setSmallIcon(R.drawable.ic_btn_pause)
                .setContentTitle("En pausa")
                .setContentText("...");

        mNotifyMgr.notify(mNotificationId, mBuilder.build());


        mediaPlayer.stop();

        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(pause){
            mediaPlayer.start();
            pause = false;
        }else{
            mediaPlayer.pause();
            pause = true;
        }
    }
}
