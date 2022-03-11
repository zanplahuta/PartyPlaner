package com.example.partyplaner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterWishlist extends RecyclerView.Adapter<AdapterWishlist.ViewHolder> {
    private OnItemClickListener listener;
    private Wishes wishes;
    private Context context;

    public AdapterWishlist() {wishes = new Wishes();}
    public AdapterWishlist(OnItemClickListener listener, Wishes wishes, Context context){
        this.listener = listener;
        this.wishes = wishes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleview_layout_wishlist, parent, false);
        //view.getLayoutParams().height = 730;
        AdapterWishlist.ViewHolder viewHolder = new AdapterWishlist.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Wish wish = wishes.getWishes().get(position);
        holder.textViewWishRV.setText(wish.getWish()); //Actual wish
        holder.textViewNameWishRV.setText(wish.getName()); //Person who requested the wish
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewWishRV;
        public TextView textViewNameWishRV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewWishRV = itemView.findViewById(R.id.textViewWishRV);
            textViewNameWishRV = itemView.findViewById(R.id.textViewNameWishRV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemLongClick(itemView, position);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
        void onItemLongClick(View itemView, int position);
    }
}
