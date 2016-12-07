package com.vazhamarshal.yesnote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vazhamarshal.yesnote.R;
import com.vazhamarshal.yesnote.model.Note;
import com.vazhamarshal.yesnote.utils.DateUtils;

import java.util.List;

/**
 * Created by akaki on 05.12.16.
 */

public class NoteAdapter extends BaseAdapter {

    private List<Note> mItems;
    private Context mContext;

    public NoteAdapter(Context context, List<Note> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        NoteViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.note_item, viewGroup, false);
            holder = new NoteViewHolder(view);
            view.setTag(holder);

        } else  {
            holder = (NoteViewHolder) view.getTag();
        }

        Note note = mItems.get(i);
        holder.titleView.setText(note.getTitle());
        holder.dateView.setText(DateUtils.toDateString(note.getDate()));
        holder.contentView.setText(note.getContent());

        return view;
    }

    class NoteViewHolder {

        TextView titleView;
        TextView dateView;
        TextView contentView;

        public NoteViewHolder(View view) {
            titleView = (TextView) view.findViewById(R.id.title);
            dateView = (TextView) view.findViewById(R.id.date);
            contentView = (TextView) view.findViewById(R.id.note);
        }
    }
}
