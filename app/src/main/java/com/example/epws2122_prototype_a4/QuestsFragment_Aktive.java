package com.example.epws2122_prototype_a4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;


public class QuestsFragment_Aktive extends Fragment implements Serializable {

    ArrayList<Quest> questListAktive = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_quests__aktive, container, false);

        questListAktive.add(new Quest(1,"test",1, false, true, false));
        questListAktive.clear();
        //ArrayList<Quest> questListAktive = (ArrayList<Quest>)getArguments().getSerializable("key");
        Bundle bundle = new Bundle();
        //bundle.getParcelableArrayList("key");

        //System.out.println("recv bundle: " + bundle);
        //questListAktive.add(bundle);
        ArrayList<Quest> transfer = new ArrayList<>();

        //transfer.add(new Quest(1,"test", 1, false, true, false));
        //transfer.addAll(bundle.getParcelableArrayList("key"));
        //questListAktive.addAll(transfer);
        System.out.println("bundle recv: " + bundle.toString());

        ArrayAdapter<Quest> arrayAdapter = new ArrayAdapter<Quest>(
                getContext(),
                android.R.layout.simple_list_item_1,
                questListAktive //questList
        );
        //listView.setAdapter(arrayAdapter);

        ListView lvarraylist = (ListView) view.findViewById(R.id.questlistAktiveView);
        lvarraylist.setAdapter(arrayAdapter);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle savedInstanceState) {

        questListAktive.add(new Quest(1,"test",1, false, true, false));
        questListAktive.clear();
        //ArrayList<Quest> questListAktive = (ArrayList<Quest>)getArguments().getSerializable("key");
        Bundle bundle = new Bundle();
        bundle.getParcelableArrayList("key");
        System.out.println("bundle recv oncreated: " + bundle.toString());

        super.onViewCreated(view, savedInstanceState);
    }
}