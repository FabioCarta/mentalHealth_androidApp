package com.example.epws2122_prototype_a4;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class QuestsFragment_Offene extends Fragment implements Serializable {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quests__offene, container, false);
        //myFragment = inflater.inflate(R.layout.fragment_quests, container, false);
        //listView = (ListView) myFragment.findViewById(R.id.questlistView);

        ArrayList<Quest> questListOpen = new ArrayList<>();
        ArrayList<Quest> questListActive = new ArrayList<>();
        questListActive.add(new Quest(0, "empty", 5, false, true, false));

        //adding quests
        Quest ch1 = new Quest(1, "Gehe eine Runde um den Block.", 1, "Sport", 5, true, false, false);
        Quest ch2 = new Quest(2, "Wähle einen Tag in der Woche aus und spaziere zu einem Ort, an dem du schon länger mal sein wolltest.", 2, "Sport", 1, true, false, false);
        Quest ch3 = new Quest(3, "Führe eine zweiminütige Trainingseinheit durch. (Liegestütze) ", 3, "Sport", 8, true, false, false);
        Quest ch4 = new Quest(4, "Lass dein Auto am nächsten Arbeitstag stehen und fahre mit dem Fahrrad.", 4, "Sport", 3, true, false, false);
        Quest ch5 = new Quest(5, "Höre ein Lieblingslied und tanze bis zum Ende des Lieds dazu.", 5, "Sport", 3, true, false, false);
        Quest ch6 = new Quest(6, "Erledige deinen nächsten kleinen Einkauf zu Fuß oder mit dem Fahrrad, statt mit dem Auto zu fahren.", 6, "Sport", 4, true, false, false);
        Quest ch7 = new Quest(7, "Führe eine fünfminütige Trainingseinheit durch. (Sit-ups)", 7, "Sport", 9, true, false, false);
        Quest ch8 = new Quest(8, "Probiere Geocaching aus.", 8, "Sport", 2, true, false, false);
        Quest ch9 = new Quest(9, "Suche deinen nächsten Park auf und laufe eine Runde.", 9, "Sport", 1, true, false, false);
        Quest ch10 = new Quest(10, "Verabrede dich zu einer sportlichen Aktivität, die du schon länger aufschiebst. (Schwimmen, Schlittschuhlaufen, Klettern etc.)", 10, "Sport", 5, true, false, false);

        questListOpen.add(ch1);
        questListOpen.add(ch2);
        questListOpen.add(ch3);
        questListOpen.add(ch4);
        questListOpen.add(ch5);
        questListOpen.add(ch6);
        questListOpen.add(ch7);
        questListOpen.add(ch8);
        questListOpen.add(ch9);
        questListOpen.add(ch10);



        ArrayAdapter<Quest> arrayAdapter = new ArrayAdapter<Quest>(
                getContext(),
                android.R.layout.simple_list_item_1,
                questListOpen //questList
        );
        //listView.setAdapter(arrayAdapter);

        ListView lvarraylist = (ListView) view.findViewById(R.id.questlistView);
        lvarraylist.setAdapter(arrayAdapter);


        //when clicked on a single quest, a popup opens with quest text and 2 buttons "accept" and "decline"
        lvarraylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(++i);
                int questid = --i;
                //openQuestDetail(++i);

                //opening the popup
                final Dialog fbDialogue = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar);
                fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                fbDialogue.setContentView(R.layout.popup_window);
                fbDialogue.setCancelable(true);
                TextView textViewToChange = (TextView) fbDialogue.findViewById(R.id.questdetailpopup);

                String questInfo ="";
                //questInfo = questListOpen.get(questid).getQuest().toString();
                questInfo += questListOpen.get(questid).getQuestInfo();
                textViewToChange.setText(questListOpen.get(questid).getQuestInfo());
                //textViewToChange.setText(questListOpen.get(questid).getQuest().toString());
                fbDialogue.show();

                //when clicked on "accept" button, the clicked quest should be removed from the first arraylist
                //and moved to the second fragment "aktive" to be shown there
                fbDialogue.findViewById(R.id.questaccept).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        questListOpen.get(questid).setAktiv(true);
                        questListOpen.get(questid).setOffen(false);
                        questListActive.add(questListOpen.get(questid));
                        questListOpen.remove(questid);
                        lvarraylist.invalidateViews();

                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("key", questListActive);

                        //bundle.putSerializable("key", questListActive);

                        //hiding popup
                        fbDialogue.hide();
                        System.out.println("bundle send: " + bundle.toString());
                    }
                });

                //closing the popup when "close" button inside the popup is clicked
                fbDialogue.findViewById(R.id.popupclose).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fbDialogue.hide();
                    }
                });
            }
        });
        return view;
    }

    void openQuestdetail(Integer questId) {
        //finish();
        //startActivity(new Intent(QuestListActivity.this, QuestDetailActivity.class));
    }
}