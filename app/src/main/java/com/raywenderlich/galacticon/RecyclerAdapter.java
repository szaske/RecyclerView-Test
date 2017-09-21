package com.raywenderlich.galacticon;

/**
 * Created by Guest on 9/21/17.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PhotoHolder> {

    // My variables
    private ArrayList<Photo> mPhotos;

    // extend RecyclerView.ViewHolder, allowing it to be used as a ViewHolder for the adapter
    public static class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // a list of references to the lifecycle of the object to allow the
        // ViewHolder to hang on to your ImageView and TextView, so it
        // doesn’t have to repeatedly query the same information.
        // This is why we're using a recyclerview
        private ImageView mItemImage;
        private TextView mItemDate;
        private TextView mItemDescription;
        private Photo mPhoto;

        // a key for easier reference to the particular item being used to launch your RecyclerView
        private static final String PHOTO_KEY = "PHOTO";

        // The Constructor
        public PhotoHolder(View v) {
            super(v);

            // TODO: Implement Butterknife
            mItemImage = (ImageView) v.findViewById(R.id.item_image);
            mItemDate = (TextView) v.findViewById(R.id.item_date);
            mItemDescription = (TextView) v.findViewById(R.id.item_description);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK on" + v.toString());
        }
    }


    // The constructor
    public RecyclerAdapter(ArrayList<Photo> photos) {
        mPhotos = photos;
    }

    @Override
    public RecyclerAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        Log.d("onCreateViewHolder: ", "Fired" );
        return new PhotoHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PhotoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
