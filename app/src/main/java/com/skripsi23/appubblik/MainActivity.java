package com.skripsi23.appubblik;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDaftar;
    Intent i;

    Button btn_login;
    EditText etEmail,etPass;
    private ProgressBar progressBar;
    private String idUser;

    DialogInterface.OnClickListener listener;
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;
    Firebase Kref;

    public static List<String> list_keyUser = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(MainActivity.this);
        Kref = new Firebase("https://appubblik-9c8ec.firebaseio.com/").child("user");
        btn_login = (Button) findViewById(R.id.btnLoginUser);
        etEmail = (EditText) findViewById(R.id.etUserEmail);
        etPass = (EditText) findViewById(R.id.etUserPass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //check jika sudah login
        ambilDataUser();
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser()!= null){

            idUser = fAuth.getCurrentUser().getUid();
            if (list_keyUser.contains(idUser)){

                String name = fAuth.getCurrentUser().getDisplayName();
                Home.nama = name;
                startActivity(new Intent(MainActivity.this,Home.class));
                finish();
            }else{
                ambilDataUser();
            }

        }else {
            ambilDataUser();
        }

        btnDaftar = (Button) findViewById(R.id.btnDaftarUser);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
               /* i = new Intent(MainActivity.this,BerandaActivity.class);
                startActivity(i);*/

                String email = etEmail.getText().toString();
                final String pass = etPass.getText().toString();

                if (formcek()){
                    progressBar.setVisibility(View.VISIBLE);
                    etEmail.setEnabled(false);
                    etPass.setEnabled(false);
                    btn_login.setEnabled(false);

                    fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (!task.isSuccessful()){
                                progressBar.setVisibility(View.GONE);
                                etEmail.setEnabled(true);
                                etPass.setEnabled(true);
                                btn_login.setEnabled(true);
                                Toast.makeText(getApplicationContext(), "Login Gagal, periksa kembali email dan password anda", Toast.LENGTH_LONG).show();
                            }else {

                                String userID = fAuth.getCurrentUser().getUid();
                                String email = fAuth.getCurrentUser().getEmail();
                                int jml_user = list_keyUser.size();
                                for (int c=0;c<jml_user;c++){

                                    if (list_keyUser.contains(userID)){ //kalau akun ny ada di list User

                                        if (email.equals("admin@mail.com")){
                                            String name = fAuth.getCurrentUser().getDisplayName();
                                            i = new Intent(getApplicationContext(),AdminActivity.class);
                                            Toast.makeText(getApplicationContext(),"Login admin activated",Toast.LENGTH_SHORT).show();
                                            startActivity(i);
                                            progressBar.setVisibility(View.GONE);

                                        }else{
                                            String name = fAuth.getCurrentUser().getDisplayName();
                                            Home.nama = name;
                                            i = new Intent(getApplicationContext(),Home.class);
                                            startActivity(i);
                                            progressBar.setVisibility(View.GONE);
                                        }

                                    }else {
                                        progressBar.setVisibility(View.GONE);
                                        etEmail.setEnabled(true);
                                        etPass.setEnabled(true);
                                        btn_login.setEnabled(true);
                                        Toast.makeText(getApplicationContext(), "Login Gagal, periksa kembali email dan password anda", Toast.LENGTH_LONG).show();
                                    }
                                }

                            }
                        }
                    });
                }



            }
        });


    }

    public void ambilDataUser(){

        progressBar.setVisibility(View.VISIBLE);
        etEmail.setEnabled(false);
        etPass.setEnabled(false);

        Kref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list_keyUser.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()){
                    //kalo cocok bisa login
                    String kunci = child.getKey();
                    list_keyUser.add(kunci);
                }
                progressBar.setVisibility(View.GONE);
                etPass.setEnabled(true);
                etEmail.setEnabled(true);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakan anda tetap ingin menutup aplikasi?");
        builder.setCancelable(false);

        listener = new DialogInterface.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    finishAffinity();
                    System.exit(0);
                }

                if(which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.cancel();
                }
            }
        };
        builder.setPositiveButton("Ya",listener);
        builder.setNegativeButton("Tidak", listener);
        builder.show();
    }

    private boolean validateEmail() {
        if (etEmail.getText().toString().trim().isEmpty()) {
            etEmail.setError("Tidak boleh kosong!");
            etEmail.requestFocus();
            return false;
        } else {
        }
        return true;
    }

    private boolean validatePass() {
        if (etPass.getText().toString().trim().isEmpty()) {
            etPass.setError("Tidak boleh kosong!");
            etPass.requestFocus();
            return false;
        } else {
        }
        return true;
    }

    private boolean formcek() {

        if (!validatePass()) {
            return false;
        }

        if (!validateEmail()) {
            return false;
        }

        return true;

    }

}