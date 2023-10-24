package com.example.tarea6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;
    static final String CANAL_ID="mi_canal";
    static final int NOTIFICACION_ID=1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
              CANAL_ID, "Mis Notificaciones",
              NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Descripcion del canal");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,100,300,100});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Button wearButton = (Button) findViewById(R.id.boton1);
        wearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder notificacion =
                        new NotificationCompat.Builder( MainActivity.this, CANAL_ID)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Alan Pérez")
                                        .setContentText(Html.fromHtml("<br>Arriba los gatitos</br>"+"<u>Android<i>Wear</i></u>"));
                notificationManager.notify(NOTIFICACION_ID, notificacion.build());
            }


        });

    }





}

