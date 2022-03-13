package com.example.partyplaner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterInvited extends RecyclerView.Adapter<AdapterInvited.ViewHolder> {
    private Invites invites;
    private Context context;

    public AdapterInvited() {invites = new Invites();}
    /*public AdapterInvited(OnItemClickListener listener, Invites invites, Context context){
        this.listener = listener;
        this.invites = invites;
        this.context = context;
    }*/

    public AdapterInvited(Invites invites) {
        this.invites = invites;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleview_layout_invited, parent, false);
        //view.getLayoutParams().height = 730;
        AdapterInvited.ViewHolder viewHolder = new AdapterInvited.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Invite invite = invites.getInvites().get(position);
        holder.textViewNameRV.setText(invite.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNameRV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameRV = itemView.findViewById(R.id.textViewNameRV);
        }
    }
}
