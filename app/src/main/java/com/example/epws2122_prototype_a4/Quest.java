package com.example.epws2122_prototype_a4;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Quest implements Parcelable {

    int id;
    String quest;
    int difficulty;
    String category;
    int points;



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    boolean offen, aktiv, absolviert;


    @Override
    public String toString() {
        return "id: " + id +
                ", Aufgabe: " + quest + '\'' +
                ", Schwierigkeitsgrad: " + difficulty +
                ", Offen: " + offen +
                ", Aktiv: " + aktiv +
                ", Absolviert: " + absolviert +
                '}' + "\n";
    }

    public Quest(int id, String quest, int difficulty, boolean offen, boolean aktiv, boolean absolviert) {
        this.id = id;
        this.quest = quest;
        this.difficulty = difficulty;
        this.offen = offen;
        this.aktiv = aktiv;
        this.absolviert = absolviert;
    }

    public Quest(int id, String quest, int difficulty, String category, int points, boolean offen, boolean aktiv, boolean absolviert) {
        this.id = id;
        this.quest = quest;
        this.difficulty = difficulty;
        this.category = category;
        this.points = points;
        this.offen = offen;
        this.aktiv = aktiv;
        this.absolviert = absolviert;
    }

    public Quest(int id, String aufgabe, int difficulty) {
        this.id = id;
        this.quest = aufgabe;
        this.difficulty = difficulty;
        this.offen = true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public String getQuestInfo() {
        return quest + "\n" + "Punkte: "+ points + "\n" + "Kategorie: " + category;
    }

    public void setQuest(String challenge) {
        this.quest = challenge;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setChallenge(int id, String challenge, int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isOffen() {
        return offen;
    }

    public void setOffen(boolean offen) {
        this.offen = offen;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean isAbsolviert() {
        return absolviert;
    }

    public void setAbsolviert(boolean absolviert) {
        this.absolviert = absolviert;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
