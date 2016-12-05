package com.vazhamarshal.yesnote.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vazhamarshal.yesnote.R;
import com.vazhamarshal.yesnote.adapter.NoteAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoteRecyclerView = (RecyclerView) findViewById(R.id.note_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mNoteAdapter = new NoteAdapter();
        mNoteRecyclerView.setAdapter(mNoteAdapter);
    }
}
