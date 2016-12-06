package com.vazhamarshal.yesnote.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vazhamarshal.yesnote.R;
import com.vazhamarshal.yesnote.model.Note;
import com.vazhamarshal.yesnote.utils.DateUtils;

import java.util.List;

/**
 * Created by akaki on 05.12.16.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> mItems;

    public NoteAdapter(List<Note> items) {
        this.mItems = items;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = mItems.get(position);

        holder.titleView.setText(note.getTitle());
        holder.dateView.setText(DateUtils.toDateString(note.getDate()));
        holder.noteView.setText(note.getContent());

        holder.checkState();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private static SparseBooleanArray sExpandedStates = new SparseBooleanArray();

        TextView titleView;
        TextView dateView;
        TextView noteView;
        View contentRoot;

        public NoteViewHolder(View view) {
            super(view);

            titleView = (TextView) view.findViewById(R.id.title);
            dateView = (TextView) view.findViewById(R.id.date);
            noteView = (TextView) view.findViewById(R.id.note);
            contentRoot = view.findViewById(R.id.content_root);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            boolean expanded = isExpanded();
            expanded = !expanded;
            setExpanded(expanded);

            sExpandedStates.put(getAdapterPosition(), expanded);
        }

        void checkState() {
            boolean expanded = sExpandedStates.get(getAdapterPosition());
            setExpanded(expanded);
        }

        void setExpanded(boolean expanded) {
            contentRoot.setVisibility(expanded ? View.VISIBLE : View.GONE);
        }

        boolean isExpanded() {
            return contentRoot.getVisibility() == View.VISIBLE;
        }
    }
}
