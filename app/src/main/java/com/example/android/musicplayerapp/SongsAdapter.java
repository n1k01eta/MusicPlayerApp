package com.example.android.musicplayerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 24/3/2018.
 */

public class SongsAdapter extends ArrayAdapter<Track> {

    public SongsAdapter(Context context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_list, parent, false);
        }

        // Get the {@link Track} object located at this position in the list
        Track currentTrack = getItem(position);

        // Find the TextView in the song_list.xml layout with the ID title_view
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_view);
        titleTextView.setText(currentTrack.getmTitle());

        //Find the TextView in the song_list.xml layout with the ID artist_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.simple_view);
        artistTextView.setText(currentTrack.getmArtist());

        //Find the TextView in the song_list.xml layout with the ID duration_view
        TextView durationTextView = (TextView) listItemView.findViewById(R.id.duration_view);
        durationTextView.setText(currentTrack.getmDuration());

        return listItemView;

    }
}
