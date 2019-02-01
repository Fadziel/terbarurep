package com.skripsi23.appubblik;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Manifest;

public class SMS extends AppCompatActivity {

    Button button;

    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        if (ContextCompat.checkSelfPermission(SMS.this,
                android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(SMS.this,
                    android.Manifest.permission.SEND_SMS)) {

                ActivityCompat.requestPermissions(SMS.this,
                        new String[] {android.Manifest.permission.SEND_SMS}, 1);

            } else {
                ActivityCompat.requestPermissions(SMS.this,
                        new String[] {android.Manifest.permission.SEND_SMS}, 1);
            }

        } else {
            // do nothing
        }

        button = (Button) findViewById(R.id.button);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = editText.getText(). toString();
                String sms = editText2.getText(). toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, sms, null, null);
                    Toast.makeText(SMS.this, "Sent!", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(SMS.this, "Failed!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {

            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(SMS.this,
                            android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permision Granted!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No permision granted!", Toast.LENGTH_SHORT).show();
                }

                return;
            }
        }
    }
}
