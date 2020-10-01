package ca.gbc.comp3074.wk4_lab;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView note;
        public TextView ts;
        public TextView id;

        public MyViewHolder(View view){
            super(view);
            note = view.findViewById(R.id.note_label);
            id = view.findViewById(R.id.id_label);
            ts = view.findViewById(R.id.ts_label);
        }
    }

    private Context context;
    private List<Note> notesList;

    public NotesAdapter(Context context, List<Note> notes){
        this.context = context;
        this.notesList = notes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notesList.get(position);
        holder.note.setText(note.getNote());
        holder.id.setText(String.valueOf(note.getId()));
        holder.ts.setText(note.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}
