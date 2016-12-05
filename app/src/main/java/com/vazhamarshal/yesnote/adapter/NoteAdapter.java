package com.vazhamarshal.yesnote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vazhamarshal.yesnote.R;

/**
 * Created by akaki on 05.12.16.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.dateView.setText("");
        holder.titleView.setText("");
        holder.noteView.setText("");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;
        TextView dateView;
        TextView noteView;

        public ViewHolder(View view) {
            super(view);

            titleView = (TextView) view.findViewById(R.id.title);
            dateView = (TextView) view.findViewById(R.id.date);
            noteView = (TextView) view.findViewById(R.id.note);
        }
    }
}
