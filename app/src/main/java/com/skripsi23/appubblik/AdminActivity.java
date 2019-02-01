package com.skripsi23.appubblik;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {

    ImageButton androidImageButton,ibLogout,ibRsud,ibPolisi,ibEktp;
    public static String id,from_id;
    public static String nama;
    DialogInterface.OnClickListener listener;
    Intent i;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;

    TextView txtEmail,txtNama;
    Firebase Gref,Aref,Bref,Cref,Dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAuth = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(AdminActivity.this);
        setContentView(R.layout.activity_admin);

        Gref = new Firebase("https://appubblik-9c8ec.firebaseio.com/").child("chat");

        txtNama = (TextView) findViewById(R.id.txtNama);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        id = fAuth.getCurrentUser().getEmail();
        nama = fAuth.getCurrentUser().getDisplayName();
        from_id = "";

        txtEmail.setText(id);
        txtNama.setText(nama);

        ibLogout = (ImageButton) findViewById(R.id.ib_logout);
        ibLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.signOut();
                i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        ibEktp = findViewById(R.id.ib_EKTP);
        ibEktp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListChatActivity.class);
                String namaLayanan = "E-KTP";
                String from_id = "ektp";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("from_id",from_id);
                startActivity(i);
            }
        });

        ibPolisi = findViewById(R.id.ib_Polisi);
        ibPolisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListChatActivity.class);
                String namaLayanan = "Polisi";
                String from_id = "polisi";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("from_id",from_id);
                startActivity(i);
            }
        });

        ibRsud = findViewById(R.id.ib_rsud);
        ibRsud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListChatActivity.class);
                String namaLayanan = "RSUD";
                String from_id = "rsud";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("from_id",from_id);
                startActivity(i);
            }
        });

        Aref = Gref.child("rsud");
        Aref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String a =  dataSnapshot.child("to_id").getValue().toString();

                if (a.equals("rsud")){

                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(android.R.drawable.stat_notify_error)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.logo))
                            .setContentTitle("App Publik Pringsewu")
                            .setContentText("Ada pesan baru");

                    notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                    notificationManager.notify(1, notificationBuilder.build());
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Bref = Gref.child("polisi");
        Bref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String a =  dataSnapshot.child("to_id").getValue().toString();

                if (a.equals("polisi")){

                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(android.R.drawable.stat_notify_error)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.logo))
                            .setContentTitle("App Publik Pringsewu")
                            .setContentText("Ada pesan baru");

                    notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                    notificationManager.notify(1, notificationBuilder.build());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Cref = Gref.child("ektp");
        Cref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String a =  dataSnapshot.child("to_id").getValue().toString();

                if (a.equals("ektp")){

                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(android.R.drawable.stat_notify_error)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.logo))
                            .setContentTitle("App Publik Pringsewu")
                            .setContentText("Ada pesan baru");

                    notificationBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                    notificationManager.notify(1, notificationBuilder.build());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


}
