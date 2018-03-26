package com.example.android.musicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.track_list);
        //retrieve the ArrayList of tracks from the previous activity into the variable songs
        Bundle bundleObject = getIntent().getExtras();
        ArrayList<Track> songs = (ArrayList<Track>) bundleObject.getSerializable("myTracks");

        // Create an ArrayAdapter, whose data source is a list.
        SongsAdapter adapter = new SongsAdapter(this, songs);

        // Find the View that creates a new playlist
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the  ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each album in the list of songs.
        listView.setAdapter(adapter);
    }
}
