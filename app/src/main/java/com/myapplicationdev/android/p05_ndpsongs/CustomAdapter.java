package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songlist;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);
        parent_context=context;
        layout_id=resource;
        songlist=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(layout_id, parent, false);

        TextView tvTitle=rowView.findViewById(R.id.textViewTitle);
        TextView tvYear=rowView.findViewById(R.id.textViewYear);
        RatingBar rateStars=rowView.findViewById(R.id.ratingBar2);
        TextView tvSingers=rowView.findViewById(R.id.textViewSingers);
        ImageView ivNew=rowView.findViewById(R.id.imageViewNew);

        Song song=songlist.get(position);
        tvTitle.setText(song.getTitle());
        tvYear.setText(Integer.toString(song.getYearReleased()));
        rateStars.setRating(Float.parseFloat(song.getStars()+""));
        tvSingers.setText(song.getSingers());
        if(song.getYearReleased()>=2019){
            ivNew.setImageResource(R.drawable.resource_new);
        }else{
            ivNew.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}
