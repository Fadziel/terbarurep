package com.skripsi23.appubblik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Rawatinap extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rawatinap);

        androidImageButton = (ImageButton) findViewById(R.id.pelayanan);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), pelayanan.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.alur);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), alur.class);

                startActivity(intent);

            }
        });
    }
}
