package com.skripsi23.appubblik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RSUD extends AppCompatActivity {

    ImageButton androidImageButton,ibCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsud);

        androidImageButton = (ImageButton) findViewById(R.id.BPJS);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View m) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), BPJS.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.Gmap);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View n) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), RSUDMAP.class);

                startActivity(intent);

            }
        });

        ibCS = (ImageButton) findViewById(R.id.csrs);
        ibCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChatKeCS.class);
                String namaLayanan = "RSUD";
                String to_id = "rsud";
                i.putExtra("namaLayanan",namaLayanan);
                i.putExtra("to_id",to_id);
                startActivity(i);
            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.rinap);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Rawatinap.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.dpraktik);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), dokterrs.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.wbesuk);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), jambesuk.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.kamar);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), kamarrs.class);

                startActivity(intent);

            }
        });

        androidImageButton = (ImageButton) findViewById(R.id.tatapas);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), ttpasien.class);

                startActivity(intent);

            }
        });


        androidImageButton = (ImageButton) findViewById(R.id.ambul);


        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View O) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), ambulans.class);

                startActivity(intent);

            }
        });





    }
}
