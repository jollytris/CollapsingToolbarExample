package com.jollytris.collapsingtoolbarexample.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jollytris.collapsingtoolbarexample.R;

/**
 * Created by zic325 on 2016. 10. 18..
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.title);
    }

    public void bind(RecyclerData item) {
        textView.setText(item.getTitle());
    }
}
