package com.example.partyplaner;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class AddWishlistFragment extends Fragment {

    private AddWishlistViewModel mViewModel;
    private ImageButton discardButton;
    private ImageButton postButton;

    public static AddWishlistFragment newInstance() {
        return new AddWishlistFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_wishlist_fragment, container, false);
        discardButton = view.findViewById(R.id.imageButtonDiscard);
        postButton = view.findViewById(R.id.imageButtonPost);
        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, new WishlistsFragment()).commit();
            }
        });
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, new WishlistsFragment()).commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddWishlistViewModel.class);
        // TODO: Use the ViewModel
    }
}