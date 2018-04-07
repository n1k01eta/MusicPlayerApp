package com.example.android.musicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

        //retrieve the ArrayList of tracks from the previous activity into the variable albums
        Bundle bundleObject = getIntent().getExtras();
        ArrayList<Track> albums = (ArrayList<Track>) bundleObject.getSerializable("myTracks");

        //removing from the albums array any multiple album
        for (int i = 0; i < albums.size() - 1; i++) {
            for (int j = i + 1; j < albums.size(); j++) {
                String genres1 = albums.get(i).getmAlbum();
                String genres2 = albums.get(j).getmAlbum();
                if (genres1.equals(genres2)) {
                    albums.remove(j);
                    j = j - 1;
                }
            }
        }

        // Create an ArrayAdapter, whose data source is a list.
        AlbumsAdapter adapter = new AlbumsAdapter(this, albums);

        // Find the ListView object.
        ListView listView = findViewById(R.id.list);

        /* Make the  ListView use the ArrayAdapter we created above, so that the
        * ListView will display list items for each album in the list of albums. */
        listView.setAdapter(adapter);
    }
}
