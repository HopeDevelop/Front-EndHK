package com.example.juliette.myapplication;



import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

/*
public class FavoriteListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Favorite> favoritesItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public FavoriteListAdapter(Activity activity, List<Favorite> movieItems) {
        this.activity = activity;
        this.favoritesItems = movieItems;
    }

    @Override
    public int getCount() {
        return favoritesItems.size();
    }

    @Override
    public Object getItem(int location) {
        return favoritesItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.favorites_list_item, null);


        TextView title = (TextView) convertView.findViewById(R.id.title);


        // getting movie data for the row
        Favorite f = favoritesItems.get(position);


        // title
        title.setText(f.getTitle());



        return convertView;
    }*/

//}
