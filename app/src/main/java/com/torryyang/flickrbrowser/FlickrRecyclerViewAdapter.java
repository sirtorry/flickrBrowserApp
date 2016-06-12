package com.torryyang.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Torry on 06/06/2016.
 */
public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {
    private List<Photo> mphotoList;
    private Context mContext;
    private final String LOG_TAG = FlickrRecyclerViewAdapter.class.getSimpleName();

    public FlickrRecyclerViewAdapter(Context mContext, List<Photo> mphotoList) {
        this.mphotoList = mphotoList;
        this.mContext = mContext;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder flickrImageViewHolder, int i) {
        Photo photoItem = mphotoList.get(i);
        Log.d(LOG_TAG,"processing " + photoItem.getmTitle());
        Picasso.with(mContext).load(photoItem.getmImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(flickrImageViewHolder.thumbnail);
        flickrImageViewHolder.title.setText(photoItem.getmTitle());
    }

    @Override
    public int getItemCount() {
        return (null !=  mphotoList ? mphotoList.size():0);
    }

    public void loadNewData(List<Photo> newPhotos) {
        mphotoList = newPhotos;
        notifyDataSetChanged();
    }
}
