package com.example.epws2122_prototype_a4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfilFragment extends Fragment {

    EditText name;
    Button signOutBtn;
    ImageView profilePic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_profil, container, false);
        name = (EditText) rootView.findViewById(R.id.name);
        //signOutBtn = (Button) rootView.findViewById(R.id.signoutbtn);
        //profilePic = (ImageView) rootView.findViewById(R.id.profilePic);

        HomeActivity homeActivity = (HomeActivity) getActivity();
        name.setText(homeActivity.getPersonName());

        return rootView;
    }
}