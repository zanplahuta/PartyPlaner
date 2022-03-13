package com.example.partyplaner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailedViewActivity extends AppCompatActivity {
    private String partyUUID;
    private TextView textViewName;
    private ImageView imageView;
    private DetailedViewActivity binding;
    private BottomNavigationView bottomNavigationView;
    Bundle bundle = new Bundle();
    DetailsFragment fragobj = new DetailsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);
        textViewName = findViewById(R.id.textViewNameDetailed);
        textViewName.setText("Afterparty");
        imageView = findViewById(R.id.imageView2);
        bottomNavigationView = findViewById(R.id.nav_view);
        bundle.putString("partyUUID", partyUUID);
        fragobj.setArguments(bundle);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment_details = new DetailsFragment();
        Fragment fragment_invites = new InvitesFragment();
        Fragment fragment_comments = new CommentsFragment();
        Fragment fragment_wishlist = new WishlistsFragment();
        bottomNavigationView.setOnItemSelectedListener(
                new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.navigation_details:
                                fragment = fragment_details;
                                break;
                            case R.id.navigation_invites:
                                fragment = fragment_invites;
                                break;
                            case R.id.navigation_comments:
                                fragment = fragment_comments;
                                break;
                            case R.id.navigation_wishlist:
                                fragment = fragment_wishlist;
                                break;
                            default:
                                fragment = fragment_details;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.navigation_details);
    }
}
