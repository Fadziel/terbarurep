package com.skripsi23.appubblik;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.android.gms.vision.text.Text;
import com.skripsi23.appubblik.Adapter.RecycleAdapteraListChat;

public class ListChatActivity extends AppCompatActivity {

    RecyclerView recycler_listchat;
    RecycleAdapteraListChat adapter;
    public static String from_id;
    Intent i;
    public static String namaLayanan;
    TextView txtNamaLayanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chat);

        i = getIntent();
        from_id = i.getStringExtra("from_id");
        namaLayanan = i.getStringExtra("namaLayanan");
        txtNamaLayanan = findViewById(R.id.txtLayanan);
        txtNamaLayanan.setText("List Chat di CS "+namaLayanan);

        recycler_listchat = (RecyclerView) findViewById(R.id.recycler_listchat);

        adapter = new RecycleAdapteraListChat(this);
        recycler_listchat.setAdapter(adapter);
        recycler_listchat.setLayoutManager(new LinearLayoutManager(this));


    }
}
