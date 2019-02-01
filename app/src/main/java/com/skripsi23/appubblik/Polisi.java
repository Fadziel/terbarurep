package com.skripsi23.appubblik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Polisi extends AppCompatActivity {

    ImageButton ib_csPolisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polisi);
        ib_csPolisi = (ImageButton) findViewById(R.id.ib_csPolisi);
        ib_csPolisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChatKeCS.class);
                String namaLayanan = "Polisi";
                String to_id = "polisi";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("to_id",to_id);
                startActivity(i);
            }
        });

        ib_csPolisi = (ImageButton) findViewById(R.id.izin1);


        ib_csPolisi.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), iniperizinan.class);

                startActivity(intent);

            }
        });
    }
}
