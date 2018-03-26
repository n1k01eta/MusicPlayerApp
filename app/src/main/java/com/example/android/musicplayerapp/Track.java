package com.example.android.musicplayerapp;

import java.io.Serializable;

/**
 * Created by user on 24/3/2018.
 */

public class Track implements Serializable {

    private String mTitle;
    private String mArtist;
    private String mAlbum;
    private String mGenre;
    private String mDuration;

    public Track(String title, String artist, String album, String genre, String duration) {
        mTitle = title;
        mArtist = artist;
        mAlbum = album;
        mGenre = genre;
        mDuration = duration;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmArtist() {
        return mArtist;
    }

    public String getmAlbum() {
        return mAlbum;
    }

    public String getmGenre() {
        return mGenre;
    }

    public String getmDuration() {
        return mDuration;
    }
}
