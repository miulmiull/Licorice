package com.nekogee.licorice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
 * Created by Administrator on 2018/4/11 0011.
 */

public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.ViewHolder> {
    RawResourceDataSource rawResourceDataSource;
    private List<Trend> trendList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagePreview;
        ImageView userImage ;
        TextView userName ;
        TextView songTitle ;
        ImageView coverImage ;
        TextView songAuthor;
        boolean isPlaying = false;

        public ViewHolder(View view){
            super(view) ;
            imagePreview = view.findViewById(R.id.trend_image_preview);
            userImage = (ImageView)view.findViewById(R.id.trend_userImage) ;
            userName = (TextView)view.findViewById(R.id.trend_userName) ;
            coverImage = (ImageView)view.findViewById(R.id.trend_image_cover) ;
            songTitle = (TextView)view.findViewById(R.id.trend_text_songTitle) ;
            songAuthor = (TextView)view.findViewById(R.id.trend_text_songAuthor) ;
        }
    }

    public TrendAdapter(List<Trend> trendList){
        this.trendList = trendList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trend_item, parent , false) ;
        ViewHolder holder = new ViewHolder(view) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder , int position){
        final Trend trend = trendList.get(position) ;
        holder.userImage.setImageResource(trend.getUserImage());
        holder.userName.setText(trend.getUserName());
        holder.songTitle.setText(trend.getSongTitle());
        holder.coverImage.setImageResource(trend.getCover());
        holder.songAuthor.setText(trend.getSongAuthor());

        holder.imagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(holder.isPlaying)
                if(trend.getPlaying()) {
                    trend.getExoPlayer().stop();
                    trend.setPlaying(false);
                    holder.imagePreview.setImageResource(R.drawable.play_button);
                }
                else {
                    trend.setPlaying(true);
                    holder.imagePreview.setImageResource(R.drawable.pause);
                    DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                    TrackSelection.Factory selectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
                    TrackSelector trackSelector = new DefaultTrackSelector(selectionFactory);
                    trend.setExoPlayer(ExoPlayerFactory.newSimpleInstance(view.getContext(), trackSelector));

                    try {
                        DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(trend.getMusicID()));
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
                        trend.getExoPlayer().prepare(mediaSource);
                        //exoPlayer.addListener(view.getContext().eventListener);
                        trend.getExoPlayer().setPlayWhenReady(true);
                    } catch (RawResourceDataSource.RawResourceDataSourceException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount(){
        return trendList.size() ;
    }


}
