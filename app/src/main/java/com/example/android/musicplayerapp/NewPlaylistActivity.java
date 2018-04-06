package com.example.android.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewPlaylistActivity extends AppCompatActivity {

    EditText playlistViewName;
    private ArrayList<Playlist> playlist;
    private ArrayList<Track> tracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_playlist);

        Bundle bundleObject = getIntent().getExtras();
        //retrieve the list of tracks and the list of playlists from the previous activity
        tracks = (ArrayList<Track>) bundleObject.getSerializable("myTracks");
        playlist = (ArrayList<Playlist>) bundleObject.getSerializable("myPlaylist");

        // Create an ArrayAdapter, whose data source is a list.
        SongsAdapter adapter = new SongsAdapter(this, tracks);

        // Find the ListView object.
        ListView listView = findViewById(R.id.list_new_playlist);

        // Make the  ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each album in the new playlist.
        listView.setAdapter(adapter);


        // Find the View done
        TextView done = findViewById(R.id.done);

        // Set a click listener on that View
        done.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the View done is clicked on.
            @Override
            public void onClick(View view) {
                //Find the EditText View and add a new item to the Playlist Array
                playlistViewName = findViewById(R.id.playlist_name);
                String playlistName = playlistViewName.getText().toString();


                //Here should be a block of lines that will add selected tracks to the newTracks ArrayList
                //ArrayList<Track> newTracks = new ArrayList<Track>();
                //newTracks = tracks;

                playlist.add(new Playlist(playlistName, tracks));
                Intent doneIntent = new Intent(NewPlaylistActivity.this, PlaylistsActivity.class);
                Bundle bundleDone = new Bundle();
                bundleDone.putSerializable("myPlaylist", playlist);
                doneIntent.putExtras(bundleDone);
                Bundle bundleTracks = new Bundle();
                bundleTracks.putSerializable("myTracks", tracks);
                doneIntent.putExtras(bundleTracks);
                startActivity(doneIntent);
            }
        });


    }
}
