package com.example.android.musicplayerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 25/3/2018.
 */

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(Context context, ArrayList<Playlist> playlist) {
        super(context, 0, playlist);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.simple_list, parent, false);
        }

        // Get the {@link Track} object located at this position in the list
        Playlist currentPlaylist = getItem(position);

        // Find the TextView in the simple_listxml layout with the ID simple_view
        TextView playlistTextView = listItemView.findViewById(R.id.simple_view);
        playlistTextView.setText(currentPlaylist.getPlaylistName());
        return listItemView;
    }
}