package com.mtjhartley.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>{

    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        mContext = context;
        mNotes = notes;
        //used for onCreateViewHolder
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view holder instances using the layoutinflator inflate method
        //puts these into the pool the recyclerview uses
        View itemView = mLayoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //associate data with views
        //passes in our viewholder back ot us that has access to the views inside it!
        NoteInfo note = mNotes.get(position);
        //we have the note at the position, now use the view holder.properties and set them with the note values
        holder.mTextCourse.setText(note.getCourse().getTitle());
        holder.mTextTitle.setText(note.getTitle());
        holder.mId = note.getId();
    }

    @Override
    public int getItemCount() {
        //get # of data
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //make these fields public so the outerclass can reference them directly
        //can put getters but this is just a utility class so...
        public final TextView mTextCourse;
        public final TextView mTextTitle;
        public int mId;


        public ViewHolder(View itemView) {
            super(itemView);
            //ViewHolder needs to keep references to views we set at runtime for each item
            //get references to the textviews
            mTextCourse = (TextView) itemView.findViewById(R.id.text_course);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);

            //associate click event handler with itemview
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_ID, mId);
                    mContext.startActivity(intent);
                }
            });


        }
    }
}
