package com.mtjhartley.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

    //private ArrayAdapter<NoteInfo> mAdapterNotes; //comment out adapter for listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));

            }
        });
        
        initializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //good for smaller amounts of data
        mNoteRecyclerAdapter.notifyDataSetChanged();
//        mAdapterNotes.notifyDataSetChanged(); //build in method to the arrayadapter
    }



    private void initializeDisplayContent() {
        final RecyclerView recyclerNotes = findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recyclerNotes.setLayoutManager(notesLayoutManager);

        //grab the notes
        //List<NoteInfo> notes = DataManager.getInstance().getNotes();
        //new up our noteRecyclerAdapter, which takes context and list of notes
        //mNoteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
        //associate recycler with adapter
        //recyclerNotes.setAdapter(mNoteRecyclerAdapter);
    }

}
