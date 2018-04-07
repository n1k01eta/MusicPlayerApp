package com.example.android.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static ArrayList<Track> tracks;
    private ArrayList<Playlist> playlistArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a list of tracks
        tracks = new ArrayList<Track>();

        //Hans Zimmer Dunkirk
        tracks.add(new Track("The Mole", "Hans Zimmer", "Dunkirk", "Instrumental", "5:36"));
        tracks.add(new Track("We Need Our Army Back", "Hans Zimmer", "Dunkirk", "Instrumental", "6:29"));
        tracks.add(new Track("The Tide", "Hans Zimmer", "Dunkirk", "Instrumental", "3:49"));
        tracks.add(new Track("Regimental Brothers", "Hans Zimmer", "Dunkirk", "Instrumental", "5:04"));
        tracks.add(new Track("Home", "Hans Zimmer", "Dunkirk", "Instrumental", "6:03"));

        //Hans Zimmer, Richard Harvey Le Petit Prince
        tracks.add(new Track("Preparation", "Hans Zimmer, Richard Harvey", "Le Petit Prince", "Instrumental", "2:09"));
        tracks.add(new Track("Driving", "Hans Zimmer, Richard Harvey", "Le Petit Prince", "Instrumental", "1:41"));
        tracks.add(new Track("Equation", "Camille, Hans Zimmer", "Le Petit Prince", "Instrumental", "2:04"));
        tracks.add(new Track("Plan B", "Hans Zimmer, Richard Harvey", "Le Petit Prince", "Instrumental", "0:36"));
        tracks.add(new Track("Ascending", "Hans Zimmer, Richard Harvey", "Le Petit Prince", "Instrumental", "3:15"));

        //Hans Zimmer, Interstellar
        tracks.add(new Track("Dreaming of the Crash", "Hans Zimmer", "Interstellar", "Instrumental", "3:55"));
        tracks.add(new Track("Day One", "Hans Zimmer", "Interstellar", "Instrumental", "3:19"));
        tracks.add(new Track("No Time For Caution", "Hans Zimmer", "Interstellar", "Instrumental", "4:06"));
        tracks.add(new Track("S. T. A. Y", "Hans Zimmer", "Interstellar", "Instrumental", "6:23"));
        tracks.add(new Track("First Step", "Hans Zimmer", "Interstellar", "Instrumental", "1:47"));

        //Hans Zimmer, Inception
        tracks.add(new Track("Time", "Hans Zimmer", "Inception", "Instrumental", "4:36"));
        tracks.add(new Track("The Dream is Collapsing", "Hans Zimmer", "Inception", "Instrumental", "2:24"));
        tracks.add(new Track("One Simple Idea", "Hans Zimmer", "Inception", "Instrumental", "9:30"));
        tracks.add(new Track("Into Limbo", "Hans Zimmer", "Inception", "Instrumental", "3:11"));
        tracks.add(new Track("Infiltration", "Hans Zimmer", "Inception", "Instrumental", "5:32"));

        //Jean Pierre Taieb, The Divide
        tracks.add(new Track("Running after my fate", "Jean Pierre Taieb", "The Divide", "Instrumental", "7:09"));

        //Ludovico Einaudi, Divenire
        tracks.add(new Track("Primavera", "Ludovico Einaudi", "Divenire", "Instrumental", "7:24"));

        //Ludovico Einaudi, Una mattina
        tracks.add(new Track("Una mattina", "Ludovico Einaudi", "Una mattina", "Instrumental", "06:48"));

        //Django
        tracks.add(new Track("Django", "Luis Bacalov", "DJANGO UNCHAINED", "Soundtrack", "2:53"));
        tracks.add(new Track("The Braying Mule", "Ennio Morricone", "DJANGO UNCHAINED", "Soundtrack", "2:33"));
        tracks.add(new Track("His Name Is King", "Luis Bacalov, Edda Del'Orso", "DJANGO UNCHAINED", "Soundtrack", "1:58"));
        tracks.add(new Track("Who Did That To You?", "John Legend", "DJANGO UNCHAINED", "Soundtrack", "3:49"));
        tracks.add(new Track("Too Old To Die Young", "Brother Dege AKA Dege Legg", "DJANGO UNCHAINED", "Soundtrack", "3:41"));
        tracks.add(new Track("Ancora Qui", "Ennio Morricone", "DJANGO UNCHAINED", "Soundtrack", "5:07"));

        //Jazz
        tracks.add(new Track("Nature boy", "Miles Davis", "Unknown", "Jazz", "6:14"));
        tracks.add(new Track("L'ombre et la lumière", "Coralie Clément", "Salle des pas perdus", "Jazz", "4:08"));
        tracks.add(new Track("Temptation", "Diana Krall", "Unknown", "Jazz", "4:57"));
        tracks.add(new Track("Return I will to Old Brazil", "The Real Tuesday Weld", "Unknown", "Jazz", "4:05"));
        tracks.add(new Track("Jazzdancer", "Mop Mop", "Kiss of Kali", "Jazz", "12:57"));

        // Find the View that shows the songs category
        TextView songs = findViewById(R.id.songs);

        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                Bundle bundleSongs = new Bundle();
                bundleSongs.putSerializable("myTracks", tracks);
                songsIntent.putExtras(bundleSongs);
                startActivity(songsIntent);
            }
        });

        // Find the View that shows the artists category
        TextView artists = findViewById(R.id.artists);

        // Set a click listener on that View
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                Bundle bundleArtists = new Bundle();
                bundleArtists.putSerializable("myTracks", tracks);
                artistsIntent.putExtras(bundleArtists);
                startActivity(artistsIntent);
            }
        });

        // Find the View that shows the genres category
        TextView genres = findViewById(R.id.genres);

        // Set a click listener on that View
        genres.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent genresIntent = new Intent(MainActivity.this, GenresActivity.class);
                Bundle bundleGenres = new Bundle();
                bundleGenres.putSerializable("myTracks", tracks);
                genresIntent.putExtras(bundleGenres);
                startActivity(genresIntent);
            }
        });

        // Find the View that shows the albums category
        TextView albums = findViewById(R.id.albums);

        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                Bundle bundleAlbums = new Bundle();
                bundleAlbums.putSerializable("myTracks", tracks);
                albumsIntent.putExtras(bundleAlbums);
                startActivity(albumsIntent);
            }
        });

        // Find the View that shows the playlist category
        TextView playlist = findViewById(R.id.playlist);

        playlistArray = new ArrayList<Playlist>();
        //creating a default Playlist with all the tracks, in order to avoi NullPointerException error
        playlistArray.add(new Playlist("All Songs", tracks));

        // Set a click listener on that View and passing the lists of tracks and playlist in the next Activity
        playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistsActivity.class);
                Bundle bundleTracks = new Bundle();
                bundleTracks.putSerializable("myTracks", tracks);
                playlistIntent.putExtras(bundleTracks);
                Bundle bundlePlaylist = new Bundle();
                bundlePlaylist.putSerializable("myPlaylist", playlistArray);
                playlistIntent.putExtras(bundlePlaylist);
                startActivity(playlistIntent);
            }
        });

        // Find the View that shows the search category
        TextView search = findViewById(R.id.search);

        // Set a click listener on that View
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                Bundle bundleSearch = new Bundle();
                bundleSearch.putSerializable("myTracks", tracks);
                searchIntent.putExtras(bundleSearch);
                //In order to have search several times we pass into the next Activity the original list of tracks
                //and another list of tracks with the search result (initially, will be the original list of tracks)
                Bundle bundleSearchTrack = new Bundle();
                bundleSearchTrack.putSerializable("mySearchTracks", tracks);
                searchIntent.putExtras(bundleSearchTrack);
                startActivity(searchIntent);
            }
        });
    }
}
