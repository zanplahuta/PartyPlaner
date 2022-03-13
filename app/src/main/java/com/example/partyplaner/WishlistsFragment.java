package com.example.partyplaner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WishlistsFragment extends Fragment {

    private WishlistsViewModel mViewModel;
    private RecyclerView recyclerView;
    private AdapterWishlist adapter;
    private ImageButton imageButton;
    private Wishes wishes = new Wishes();

    public WishlistsFragment newInstance() {
        return new WishlistsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        View view = inflater.inflate(R.layout.wishlists_fragment, container, false);
        imageButton = view.findViewById(R.id.imageButtonPlusWish);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, new AddWishlistFragment()).commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WishlistsViewModel.class);
        //recyclerView = getView().findViewById(R.id.recyclerViewWishlist);
    }

    public void onClickAddWish(View view) {
        //TODO: On click show add wish fragment
    }

    private void initAdapter() {
        adapter = new AdapterWishlist(new AdapterWishlist.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                //TODO ČE ŽELIMO ODPRETI PROFIL UPORABNIKA
                //Intent i = new Intent(getActivity().getBaseContext(), ActivitySessionDetails.class);
                //i.putExtra("SessionUUID", app.getSessions().getSessionAtPos(position).getUuid());
                //startActivity(i);
            }

            @Override
            public void onItemLongClick(View itemView, int position) {
                /*ch.getMovieArrayList().remove(position);
                app.saveData();
                adapter.notifyDataSetChanged();*/
            }
        }, wishes, this.getContext());
        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public void getWishes() {
    }

}