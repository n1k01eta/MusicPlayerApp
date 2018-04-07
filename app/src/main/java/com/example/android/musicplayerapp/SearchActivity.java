package com.example.android.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private static ArrayList<Track> songs;
    private static ArrayList<Track> searchTrack;
    private static ArrayList<Track> mySearchTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Bundle bundleObject = getIntent().getExtras();
        songs = (ArrayList<Track>) bundleObject.getSerializable("myTracks");
        mySearchTrack = (ArrayList<Track>) bundleObject.getSerializable("mySearchTracks");

        // Find the View that creates a new playlist
        TextView searchView = findViewById(R.id.search_view);

        // Set a click listener on that View
        searchView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //it reads the query search and passes it into a String to compare it afterwards with all fields of the track
                SearchView searchFrame = findViewById(R.id.search_frame);
                String searchText = searchFrame.getQuery().toString();
                searchFrame.setQueryHint("Search");

                //we search in every item of the track list and if we find any field that matches
                //the query, we add the track into the searchTrack list, in order to list it
                searchTrack = new ArrayList<Track>();
                int size = songs.size();
                for (int i = 0; i < size; i++) {
                    if (searchText.equals(songs.get(i).getmTitle())
                            | searchText.equals(songs.get(i).getmArtist())
                            | searchText.equals(songs.get(i).getmAlbum())
                            | searchText.equals(songs.get(i).getmGenre())
                            | searchText.equals(songs.get(i).getmDuration())) {
                        searchTrack.add(songs.get(i));
                        Log.i("add ", "position " + i);
                    }
                }

                //when the search_view is clicked it opens the same activity to list the list searchTrack
                //and eventually to perform a new search
                Intent searchIntent = new Intent(SearchActivity.this, SearchActivity.class);
                Bundle bundleSearch = new Bundle();
                bundleSearch.putSerializable("myTracks", songs);
                searchIntent.putExtras(bundleSearch);
                Bundle bundleSearchTrack = new Bundle();
                bundleSearchTrack.putSerializable("mySearchTracks", searchTrack);
                searchIntent.putExtras(bundleSearchTrack);
                startActivity(searchIntent);
            }


        });

        // Create an ArrayAdapter, whose data source is a list.
        SearchAdapter adapter = new SearchAdapter(this, mySearchTrack);

        // Find the ListView object.
        ListView listView = findViewById(R.id.list_search_playlist);

        // Make the  ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each album in the tracks.
        listView.setAdapter(adapter);
    }
}
