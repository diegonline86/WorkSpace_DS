package com.salesianostriana.pmdm.servicionotificacionsimple;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class ServicioCancion extends Service {
    NotificationCompat.Builder mBuilder;
    // Definimos un identificador único para las notificaciones
    int idNotification = 1;
    NotificationManager notMang = null;

    public ServicioCancion() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Capturamos el gestor de notificaciones del sistema
        notMang = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null){
            Bundle extras = intent.getExtras();
            String cancionReproducir = extras.getString("cancion");

            mBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_stat_play_music)
                    .setContentTitle("Reproduciendo")
                    .setContentText(cancionReproducir);

            notMang.notify(idNotification, mBuilder.build());
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(ServicioCancion.this, "Servicio parado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
