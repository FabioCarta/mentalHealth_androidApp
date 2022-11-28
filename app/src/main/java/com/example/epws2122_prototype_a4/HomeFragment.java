package com.example.epws2122_prototype_a4;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    TextView name;
    Button signOutBtn;
    ImageView profilePic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        name = (TextView) rootView.findViewById(R.id.name);
        signOutBtn = (Button) rootView.findViewById(R.id.signoutbtn);
        profilePic = (ImageView) rootView.findViewById(R.id.profilePic);

        HomeActivity homeActivity = (HomeActivity) getActivity();
        name.setText(homeActivity.getPersonName());

        String personPhoto = "https://lh3.googleusercontent.com/a-/AOh14Gg3KOepl4-vhqFX42-XtIYVqSJu1F5P6AUIXO0g";
        //Picasso.get().load(personPhoto).into(profilePic);
        rootView.invalidate();


        //System.out.println("namefromactivity: "+ nameFromActivity);
        //setText(nameFromActivity);



        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).signOut();
            }
        });

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }




}