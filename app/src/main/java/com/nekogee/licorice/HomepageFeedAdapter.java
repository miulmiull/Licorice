package com.nekogee.licorice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
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
 * Created by Administrator on 2018/4/11 0011.
 */

public class HomepageFeedAdapter extends RecyclerView.Adapter<HomepageFeedAdapter.ViewHolder> {
    RawResourceDataSource rawResourceDataSource;
    private List<HomepageFeed> homepageFeedList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagePreview;
        ImageView userImage ;
        TextView userName ;
        TextView songTitle ;
        ImageView coverImage ;
        TextView songAuthor;
        ImageView add;
        boolean isPlaying = false;

        public ViewHolder(View view){
            super(view) ;
            imagePreview = view.findViewById(R.id.image_preview);
            userImage = (ImageView)view.findViewById(R.id.homepage_userImage) ;
            userName = (TextView)view.findViewById(R.id.homepage_userName) ;
            coverImage = (ImageView)view.findViewById(R.id.homepage_image_cover) ;
            songTitle = (TextView)view.findViewById(R.id.homepage_text_songTitle) ;
            songAuthor = (TextView)view.findViewById(R.id.homepage_text_songAuthor) ;
            add = view.findViewById(R.id.homepage_add);
        }
    }

    public HomepageFeedAdapter(List<HomepageFeed> homepageFeedList){
        this.homepageFeedList = homepageFeedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_feed_item, parent , false) ;
        ViewHolder holder = new ViewHolder(view) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder , int position){
        final HomepageFeed homepageFeed = homepageFeedList.get(position) ;
        holder.userImage.setImageResource(homepageFeed.getUserImage());
        holder.userName.setText(homepageFeed.getUserName());
        holder.songTitle.setText(homepageFeed.getSongTitle());
        holder.coverImage.setImageResource(homepageFeed.getCover());
        holder.songAuthor.setText(homepageFeed.getSongAuthor());


        holder.imagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(holder.isPlaying)
                if(homepageFeed.getPlaying()) {
                    homepageFeed.getExoPlayer().stop();
                    homepageFeed.setPlaying(false);
                    holder.imagePreview.setImageResource(R.drawable.play_button);
                }
                else {
                    homepageFeed.setPlaying(true);
                    holder.imagePreview.setImageResource(R.drawable.pause);
                    DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                    TrackSelection.Factory selectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
                    TrackSelector trackSelector = new DefaultTrackSelector(selectionFactory);
                    homepageFeed.setExoPlayer(ExoPlayerFactory.newSimpleInstance(view.getContext(), trackSelector));

                    try {
                        DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(homepageFeed.getMusicID()));
                        rawResourceDataSource = new RawResourceDataSource(view.getContext());
                        rawResourceDataSource.open(dataSpec);
                        DataSource.Factory factory = new DataSource.Factory() {
                            @Override
                            public DataSource createDataSource() {
                                return rawResourceDataSource;
                            }
                        };

                        ExtractorMediaSource mediaSource = new ExtractorMediaSource(rawResourceDataSource.getUri(),
                                factory, new DefaultExtractorsFactory(), null, null);
                        homepageFeed.getExoPlayer().prepare(mediaSource);
                        //exoPlayer.addListener(view.getContext().eventListener);
                        homepageFeed.getExoPlayer().setPlayWhenReady(true);
                    } catch (RawResourceDataSource.RawResourceDataSourceException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount(){
        return homepageFeedList.size() ;
    }


}
