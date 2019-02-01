package com.skripsi23.appubblik;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.vision.text.Text;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    ImageButton androidImageButton,ibLogout;
    public static String id;
    public static String nama;
    DialogInterface.OnClickListener listener;
    Intent i;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;

    TextView txtEmail,txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAuth = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(Home.this);
        setContentView(R.layout.activity_home);

        txtNama = (TextView) findViewById(R.id.txtNama);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        id = fAuth.getCurrentUser().getEmail();
        nama = fAuth.getCurrentUser().getDisplayName();

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

        androidImageButton =(ImageButton) findViewById(R.id.RSUD);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View r) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), RSUD.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.Kuliner);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View s) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Kuliner.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.Shop);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View t) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Shop.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.EKTP);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View u) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), EKTP.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.PAJAK);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View d) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Pajak.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.PERIZINAN);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View p) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Polisi.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.WISATA);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View d) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Wisata.class);

                startActivity(intent);

            }
        });

        androidImageButton =(ImageButton) findViewById(R.id.PERBANKAN);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View p) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Perbankan.class);

                startActivity(intent);

            }
        });
    }

}
