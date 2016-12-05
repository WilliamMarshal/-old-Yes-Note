package com.vazhamarshal.yesnote.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vazhamarshal.yesnote.R;
import com.vazhamarshal.yesnote.adapter.NoteAdapter;
import com.vazhamarshal.yesnote.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoteRecyclerView = (RecyclerView) findViewById(R.id.note_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Note> sampleNotes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            sampleNotes.add(new Note(i, "title" + i, new Date().getTime(), "content" + i));
        }

        mNoteAdapter = new NoteAdapter(sampleNotes);
        mNoteRecyclerView.setAdapter(mNoteAdapter);
    }
}
