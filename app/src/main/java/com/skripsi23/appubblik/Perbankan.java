package com.skripsi23.appubblik;
import android.app.Notification;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Perbankan extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perbankan);

        button = (Button) findViewById(R.id.notif);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(Perbankan.this)
                        .setSmallIcon(android.R.drawable.stat_notify_error)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.logo))
                        .setContentTitle("FADZIEL AS SYAHID")
                        .setContentText("Maaf kak mau tanya loker");

                notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(Perbankan.this);
                notificationManager.notify(1, notificationBuilder.build());
            }
        });

        Button msk = (Button) findViewById(R.id.sms);


        msk.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View a) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), SMS.class);

                startActivity(intent);


            }
        });

        Button chat = (Button) findViewById(R.id.chatt);


        chat.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View b) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Chatt.class);

                startActivity(intent);


            }
        });



    }
    
}
