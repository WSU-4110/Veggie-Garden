package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {                        // this whole class helps display the recycler on settings page

    // class vars
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<RecyclerViewSettings> recyclerViewSettings;

    public RecyclerAdapter(Context context, ArrayList<RecyclerViewSettings> recyclerViewSettings, RecyclerViewInterface recyclerViewInterface) {      // constructor
        this.context = context;
        this.recyclerViewSettings = recyclerViewSettings;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {         // inflates layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.settings_view_layout, parent, false);
        return new RecyclerAdapter.myViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {         // assigns values, changes data
        holder.card_text.setText(recyclerViewSettings.get(position).getCardText());
        holder.card_arrow.setImageResource(recyclerViewSettings.get(position).getCardArrow());
    }

    @Override
    public int getItemCount() {             // get items in total
        return recyclerViewSettings.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {               // inner class that works similar to onCreate

        ImageView card_arrow;
        TextView card_text;

        public myViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            card_arrow = itemView.findViewById(R.id.card_arrow);
            card_text = itemView.findViewById(R.id.card_text);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });
        }
    }
}
