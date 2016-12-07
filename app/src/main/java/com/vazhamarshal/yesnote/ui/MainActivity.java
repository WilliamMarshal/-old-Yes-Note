package com.vazhamarshal.yesnote.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.vazhamarshal.yesnote.R;
import com.vazhamarshal.yesnote.adapter.NoteAdapter;
import com.vazhamarshal.yesnote.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mNoteListView;
    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.add_note_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newNoteIntent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivity(newNoteIntent);
            }
        });

        mNoteListView = (ListView) findViewById(R.id.note_listview);

        List<Note> sampleNotes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            sampleNotes.add(new Note(i, "title" + i, new Date().getTime(), "content" + i));
        }

        mNoteAdapter = new NoteAdapter(this, sampleNotes);
        mNoteListView.setAdapter(mNoteAdapter);
        mNoteListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
