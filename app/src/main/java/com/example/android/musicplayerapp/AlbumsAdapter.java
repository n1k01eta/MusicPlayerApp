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

public class AlbumsAdapter extends ArrayAdapter<Track> {

    public AlbumsAdapter(Context context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list, parent, false);
        }

        // Get the Track object located at this position in the list
        Track currentTrack = getItem(position);

        // Find the TextView in the simple_list.xml layout with the ID simple_view
        TextView albumsTextView = (TextView) listItemView.findViewById(R.id.simple_view);
        albumsTextView.setText(currentTrack.getmAlbum());

        return listItemView;

    }
}
