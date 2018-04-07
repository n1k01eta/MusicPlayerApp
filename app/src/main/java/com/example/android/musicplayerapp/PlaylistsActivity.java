package com.example.android.musicplayerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistsActivity extends AppCompatActivity {

    private ArrayList<Track> tracks;
    private ArrayList<Playlist> playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        //retrieve the ArrayList of tracks abd playlist from the previous activity into the variable songs
        Bundle bundleObject = getIntent().getExtras();
        tracks = (ArrayList<Track>) bundleObject.getSerializable("myTracks");
        playlist = (ArrayList<Playlist>) bundleObject.getSerializable("myPlaylist");

        //Create a default Playlist to avoid Null Pointer Exception

        // Create an ArrayAdapter, whose data source is a list.
        PlaylistAdapter adapter = new PlaylistAdapter(this, playlist);

        // Find the ListView object.
        ListView listView = findViewById(R.id.playlist_list);

        // Make the  ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each album in the list of playlists.
        listView.setAdapter(adapter);

        // Find the View that creates a new playlist
        TextView create = findViewById(R.id.new_playlist);

        // Set a click listener on that View
        create.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent createIntent = new Intent(PlaylistsActivity.this, NewPlaylistActivity.class);
                Bundle bundleCreate = new Bundle();
                bundleCreate.putSerializable("myTracks", tracks);
                createIntent.putExtras(bundleCreate);
                Bundle bundlePlaylist = new Bundle();
                bundlePlaylist.putSerializable("myPlaylist", playlist);
                createIntent.putExtras(bundlePlaylist);
                startActivity(createIntent);
            }
        });
    }
}
