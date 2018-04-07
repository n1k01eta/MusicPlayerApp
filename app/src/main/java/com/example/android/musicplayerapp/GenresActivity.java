package com.example.android.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

        //retrieve the ArrayList of tracks from the previous activity into the variable songs
        Bundle bundleObject = getIntent().getExtras();
        ArrayList<Track> genres = (ArrayList<Track>) bundleObject.getSerializable("myTracks");

        //removing from the genres array any multiple genre
        for (int i = 0; i < genres.size() - 1; i++) {
            for (int j = i + 1; j < genres.size(); j++) {
                String genres1 = genres.get(i).getmGenre();
                String genres2 = genres.get(j).getmGenre();
                if (genres1.equals(genres2)) {
                    genres.remove(j);
                    j = j - 1;
                }
            }
        }

        // Create an ArrayAdapter, whose data source is a list.
        GenresAdapter adapter = new GenresAdapter(this, genres);

        // Find the ListView object.
        ListView listView = findViewById(R.id.list);

        /* Make the  ListView use the ArrayAdapter we created above, so that the
        * ListView will display list items for each album in the list of genres.
        */
        listView.setAdapter(adapter);
    }
}
