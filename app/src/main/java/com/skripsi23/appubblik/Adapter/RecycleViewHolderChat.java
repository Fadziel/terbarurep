package com.skripsi23.appubblik.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skripsi23.appubblik.R;

/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleViewHolderChat extends RecyclerView.ViewHolder {

    public TextView txtNamaSender,txtMessage;
    public LinearLayout content;
    public LinearLayout contentWithBackground;

    public RecycleViewHolderChat(View itemView) {
        super(itemView);

        txtNamaSender = (TextView) itemView.findViewById(R.id.txtNamaSender);
        txtMessage = (TextView) itemView.findViewById(R.id.txtMessage);
        content = (LinearLayout) itemView.findViewById(R.id.content);
        contentWithBackground = (LinearLayout) itemView.findViewById(R.id.contentWithBackground);



    }
}
