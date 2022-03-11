package com.example.partyplaner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class InvitesFragment extends Fragment {

    private InvitesViewModel mViewModel;
    private RecyclerView recyclerView;
    private AdapterInvited adapter;
    private Invites invites = new Invites();

    public static InvitesFragment newInstance() {
        return new InvitesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.invites_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InvitesViewModel.class);
        recyclerView = getView().findViewById(R.id.recyclerViewInvites);
        getInvites();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new AdapterInvited(new AdapterInvited.OnItemClickListener() {
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
        }, invites, this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public void getInvites() {
        Invites invites = new Invites();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        String userID = sp.getString("userId", null);
        String jwt = sp.getString("jwt", null);
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "IP GOES HERE"+"/activities/user/"+userID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i = 0; i < jsonArray.length(); i++) {
                                Invite invite = new Invite();
                                JSONObject obj = jsonArray.getJSONObject(i);
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                long miliseconds = 0;
                                try {
                                    Date date = format.parse(obj.getString("start_time"));
                                    miliseconds = date.getTime();
                                }
                                catch (ParseException ex) {
                                    ex.printStackTrace();
                                }
                                invite.setName(obj.getString("name"));
                                invite.setEmail(obj.getString("email"));
                                invite.setPartyUUID(obj.getString("partyUUID"));
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.i("asda",e.getMessage());
                        }

                        //adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("asd", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("x-auth-token", jwt);
                return params;
            }
        };
        queue.add(stringRequest);
    }

}