package com.example.android.musicplayerapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 25/3/2018.
 */

public class Playlist implements Serializable {

    private String name;
    private ArrayList<Track> songs;

    public Playlist(String title, ArrayList<Track> tracks) {

        name = title;
        songs = tracks;
    }

    public String getPlaylistName() {
        return name;
    }

    public ArrayList<Track> getPlaylistTracks() {
        return songs;
    }
}
