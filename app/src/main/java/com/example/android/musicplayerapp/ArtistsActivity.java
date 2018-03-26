package com.example.android.musicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.track_list);
        //retrieve the ArrayList of artists from the previous activity into the variable artists
        Bundle bundleObject = getIntent().getExtras();
        ArrayList<Track> artists = (ArrayList<Track>) bundleObject.getSerializable("myTracks");

        //removing from the artists array any multiple artist
        Log.i("artists size is", Integer.toString(artists.size()));

        for (int i = 0; i < artists.size() - 1; i++) {
            for (int j = i + 1; j < artists.size(); j++) {
                String artist1 = artists.get(i).getmArtist();
                String artist2 = artists.get(j).getmArtist();
                Log.i("artist1", "i is " + i + " j is " + j + " compare " + artist1);
                Log.i("artist2", "i is " + i + " j is " + j + " compare " + artist2);
                if (artist1.equals(artist2)) {
                    Log.i("remove", "i is " + i + " j is " + j + " remove " + artist2);
                    artists.remove(j);
                    j = j - 1;

                }

            }


        }

        // Create an ArrayAdapter, whose data source is a list.
        ArtistsAdapter adapter = new ArtistsAdapter(this, artists);

        // Find the ListView object.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the  ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each album in the list of artists.
        listView.setAdapter(adapter);
    }
}
