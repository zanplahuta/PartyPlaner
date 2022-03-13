package com.example.partyplaner;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DetailsFragment extends Fragment {

    private DetailsViewModel mViewModel;
    private String partyUUID;
    private TextView textViewNameDetailed;
    private TextView textViewTypeDetailed;
    private TextView textViewLocationDetailed;
    private TextView textViewDateDetailed;
    private TextView textViewDescriptionDetailed;

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //String partyUUID = getArguments().getString("partyUUID");
        View rootView = inflater.inflate(R.layout.details_fragment, container, false);
        //textViewNameDetailed = (TextView) rootView.findViewById(R.id.textViewNameDetailed);
        textViewTypeDetailed = (TextView) rootView.findViewById(R.id.textViewTypeDetailed);
        textViewLocationDetailed = (TextView) rootView.findViewById(R.id.textViewLocationDetailed);
        textViewDateDetailed = (TextView) rootView.findViewById(R.id.textViewDateDetailed);
        textViewDescriptionDetailed = (TextView) rootView.findViewById(R.id.textViewDescriptionDetailed);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        //app = (MyApplication) getApplication();
        partyUUID = getActivity().getIntent().getStringExtra("partyUUID");
        Party party = new Party("Return to Maribor", "Gosposvetska cesta 11", "15.03.2022 20:00", "Private", "Best afterparty in town. BYOB.");
        setData(party);
    }

    public void setData(Party party) {
        //textViewNameDetailed.setText(party.getName());
        textViewTypeDetailed.setText(party.getType());
        textViewLocationDetailed.setText(party.getLocation());
        textViewDateDetailed.setText(party.getDatetime());
        textViewDescriptionDetailed.setText(party.getDescription());
    }

    public void getParty() {
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
        //String jwt = sp.getString("jwt", null);
        /*RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "ip goes here" + "/activities/" + partyUUID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //JSONArray jsonArray = new JSONArray(response);
                            JSONObject obj = new JSONObject(response);
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            long miliseconds = 0;
                            try {
                                Date date = format.parse(obj.getString("start_time"));
                                miliseconds = date.getTime();
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }
                            party.setName(obj.getString("name"));
                            party.setLocation(obj.getString("location"));
                            party.setDescription(obj.getString("description"));
                            party.setType(obj.getString("type"));
                            //party.setDatetime(format.parse(obj.getString("date")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.i("asda", e.getMessage());
                        }
                        callback.onSuccessResponse(party);
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
                //params.put("x-auth-token", jwt);
                return params;
            }
        };
        queue.add(stringRequest);*/
    }

}