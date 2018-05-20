package com.nekogee.licorice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

import java.util.List;

/**
 * Created by hui jie on 2018/5/13.
 */

public class StoreItemAdapter extends RecyclerView.Adapter<StoreItemAdapter.ViewHolder> {
    private Context mContext;
    private List<StoreItem> storeItemList;
    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView storeItemName ;
        ImageView coverImage ;
        TextView storeItemCount;


        public ViewHolder(View view){
            super(view) ;
            storeItemName = (TextView)view.findViewById(R.id.store_itemName) ;
            coverImage = (ImageView)view.findViewById(R.id.store_image_cover) ;
            storeItemCount = (TextView)view.findViewById(R.id.store_itemCount) ;
        }
    }

    public StoreItemAdapter(List<StoreItem> storeItemList){
        this.storeItemList = storeItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        if(mContext == null) {
            mContext = parent.getContext();
        }
        Log.d("pppp", "onCreateViewHolder: before");
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_store_item, parent , false) ;
        Log.d("pppp", "onCreateViewHolder: before1");
        ViewHolder holder = new ViewHolder(view) ;
        Log.d("pppp", "onCreateViewHolder: before2");
        return holder ;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder , int position){
        StoreItem storeItem = storeItemList.get(position) ;

        holder.storeItemCount.setText(storeItem.getSongNumber());
        holder.storeItemName.setText(storeItem.getName());
        holder.coverImage.setImageResource(storeItem.getCoverID());

    }

    @Override
    public int getItemCount(){
        return storeItemList.size() ;
    }


}
