package com.example.android.musicplayerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 26/3/2018.
 */

public class SearchAdapter extends ArrayAdapter<Track> {

    public SearchAdapter(Context context, ArrayList<Track> tracks) {
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
        TextView titleTextView = listItemView.findViewById(R.id.title_view);
        titleTextView.setText(currentTrack.getmTitle());

        //Find the TextView in the song_list.xml layout with the ID artist_view
        TextView artistTextView = listItemView.findViewById(R.id.simple_view);
        artistTextView.setText(currentTrack.getmArtist());

        //Find the TextView in the song_list.xml layout with the ID duration_view
        TextView durationTextView = listItemView.findViewById(R.id.duration_view);
        durationTextView.setText(currentTrack.getmDuration());
        return listItemView;
    }
}
