package com.example.partyplaner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.partyplaner.Parties;
import com.example.partyplaner.Party;

public class AdapterParties extends RecyclerView.Adapter<AdapterParties.ViewHolder> {
    private Parties parties;
    private OnItemClickListener listener;

    public AdapterParties(Parties parties, OnItemClickListener listener) {
        this.parties = parties;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterParties.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_rowlayout, parent, false);
        AdapterParties.ViewHolder viewHolder = new AdapterParties.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterParties.ViewHolder holder, int position) {
        Party tmp = parties.getPartyAtPos(position);
        holder.textViewPartyName.setText(tmp.getName());
        holder.textViewPartyLocation.setText(tmp.getLocation());
        holder.textViewPartyDate.setText(tmp.getDatetime().toString());
        holder.textViewPartyDescription.setText(tmp.getDescription());
        //TODO set image
    }

    @Override
    public int getItemCount() {
        return parties.getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewPartyName;
        public TextView textViewPartyLocation;
        public TextView textViewPartyDate;
        public TextView textViewPartyDescription;
        public ImageView imageView;
        public View background;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPartyName = (TextView) itemView.findViewById(R.id.partyName);
            textViewPartyLocation = (TextView) itemView.findViewById(R.id.partyLocation);
            textViewPartyDate = (TextView) itemView.findViewById(R.id.partyDateTime);
            textViewPartyDescription = (TextView) itemView.findViewById(R.id.partyDescription);
            imageView = (ImageView) itemView.findViewById(R.id.rowicon);
            background = itemView.findViewById(R.id.mylayoutrow);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //Timber.tag("long clicked").v("pozicija: " + getAdapterPosition());

                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemLongClick(itemView, position);
                        }
                    }
                    return true;
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);

        void onItemLongClick(View itemView, int position);
    }
}
