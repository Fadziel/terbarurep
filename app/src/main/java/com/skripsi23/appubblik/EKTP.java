package com.skripsi23.appubblik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EKTP extends AppCompatActivity {

    ImageButton ib_csEktp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ektp);

        ib_csEktp = (ImageButton) findViewById(R.id.ib_csEktp);
        ib_csEktp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChatKeCS.class);
                String namaLayanan = "E-KTP";
                String to_id = "ektp";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("to_id",to_id);
                startActivity(i);
            }
        });

        ib_csEktp = (ImageButton) findViewById(R.id.proses);


        ib_csEktp.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), psoektp.class);

                startActivity(intent);

            }
        });
    }
}
