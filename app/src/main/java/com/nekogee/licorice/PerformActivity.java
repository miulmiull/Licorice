package com.nekogee.licorice;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

import java.util.ArrayList;
import java.util.List;

import static com.nekogee.licorice.CoolMenu.isTouchInsideView;

/**
 * Created by hui jie on 2018/4/26.
 */

public class PerformActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Intent intent;

    private String[] mItemTexts = new String[] { "导入工程", "导入音源库", "导入本地音源", "录音" };
    private int[] mItemImgs = new int[] { R.drawable.spanner, R.drawable.cku, R.drawable.importan, R.drawable.record};
    private CoolAdapter adapter;
    private CoolMenu coolMenu;
    List<String> list = new ArrayList<>();

    private final int SINGLE = 0;
    private final int LOOP = 1;
    private final int SHORT = 0;
    private final int LONG = 1;

    private ImageView imageView;
    private ImageView imageViewLoop;
    private ImageView imageViewEdit;

    LottieAnimationView animationView1;
    LottieAnimationView animationView2;
    LottieAnimationView animationView3;
    LottieAnimationView animationView4;
    LottieAnimationView animationView5;
    LottieAnimationView animationView6;
    LottieAnimationView animationView7;
    LottieAnimationView animationView8;
    LottieAnimationView animationView9;

    RawResourceDataSource rawResourceDataSource;

    private Player.EventListener eventListener = new Player.EventListener() {
        @Override
        public void onTimelineChanged(Timeline timeline, Object manifest) {

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {

        }

        @Override
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {

        }

        @Override
        public void onPositionDiscontinuity(int reason) {

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

        }

        @Override
        public void onSeekProcessed() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perform);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SimpleExoPlayer exoPlayer1;
        SimpleExoPlayer exoPlayer2;
        SimpleExoPlayer exoPlayer3;
        SimpleExoPlayer exoPlayer4;
        SimpleExoPlayer exoPlayer5;
        SimpleExoPlayer exoPlayer6;
        SimpleExoPlayer exoPlayer7;
        SimpleExoPlayer exoPlayer8;
        SimpleExoPlayer exoPlayer11;
        SimpleExoPlayer  exoPlayer10;
        SimpleExoPlayer exoPlayer12;
        SimpleExoPlayer exoPlayer13;
        SimpleExoPlayer exoPlayer14;
        SimpleExoPlayer exoPlayer17;
        SimpleExoPlayer exoPlayer18;
        SimpleExoPlayer exoPlayer19;
        SimpleExoPlayer exoPlayer20;
        SimpleExoPlayer exoPlayer23;
        SimpleExoPlayer exoPlayer24;


        exoPlayer1 = newPlayer();
        exoPlayer2 = newPlayer();
        exoPlayer3 = newPlayer();
        exoPlayer4 = newPlayer();
        exoPlayer5 = newPlayer();
        exoPlayer6 = newPlayer();
        exoPlayer7 = newPlayer();
        exoPlayer8 = newPlayer();

        exoPlayer10 = newPlayer();
        exoPlayer11 = newPlayer();
        exoPlayer12 = newPlayer();
        exoPlayer13 = newPlayer();
        exoPlayer14 = newPlayer();
        exoPlayer17 = newPlayer();
        exoPlayer18 = newPlayer();
        exoPlayer19 = newPlayer();
        exoPlayer20 = newPlayer();
        exoPlayer23 = newPlayer();
        exoPlayer24 = newPlayer();

        //Piano low
       /* ButtonInfo buttonInfo6 = new ButtonInfo(R.id.ImageView_6,exoPlayer6,R.raw.piano_b3,R.raw.piano_high_j,SINGLE,SHORT);
        ButtonInfo buttonInfo12 = new ButtonInfo(R.id.ImageView_12,exoPlayer12,R.raw.piano_d4,R.raw.piano_low,SINGLE,SHORT);
        ButtonInfo buttonInfo18 = new ButtonInfo(R.id.ImageView_18,exoPlayer18,R.raw.piano_g3,R.raw.estimate,SINGLE,SHORT);
        ButtonInfo buttonInfo24 = new ButtonInfo(R.id.ImageView_24,exoPlayer24,R.raw.piano_e4,R.raw.articulation,SINGLE,SHORT);
        ButtonInfo buttonInfo5 = new ButtonInfo(R.id.ImageView_5,exoPlayer5,R.raw.piano_g4,R.raw.mnemonics,SINGLE,SHORT);
        ButtonInfo buttonInfo11 = new ButtonInfo(R.id.ImageView_11,exoPlayer11,R.raw.piano_a3,R.raw.dyslexia,SINGLE,SHORT);

        ButtonInfo buttonInfo17 = new ButtonInfo(R.id.ImageView_17,exoPlayer17,R.raw.piano_d3,R.raw.rejection,SINGLE,SHORT);
        ButtonInfo buttonInfo23 = new ButtonInfo(R.id.ImageView_23,exoPlayer23,R.raw.piano_e3,R.raw.estimate,SINGLE,SHORT);

        initPlayButton(buttonInfo6);
        initPlayButton(buttonInfo12);
        initPlayButton(buttonInfo18);
        initPlayButton(buttonInfo24);
        initPlayButton(buttonInfo5);
        initPlayButton(buttonInfo11);

        initPlayButton(buttonInfo17);
        initPlayButton(buttonInfo23);*/

        //Piano high
       /* ButtonInfo buttonInfo4 = new ButtonInfo(R.id.ImageView_4,exoPlayer4,R.raw.piano_b_high,R.raw.estimate,SINGLE,LONG  );
        ButtonInfo buttonInfo10 = new ButtonInfo(R.id.ImageView_10,exoPlayer10,R.raw.piano_high_j,R.raw.estimate,SINGLE,LONG);

        initPlayButton(buttonInfo4);
        initPlayButton(buttonInfo10);*/
        /*
        ButtonInfo buttonInfo1 = new ButtonInfo(R.id.ImageView_1,exoPlayer1,R.raw.drum_break,R.raw.articulation,SINGLE);
        ButtonInfo buttonInfo2 = new ButtonInfo(R.id.ImageView_2,exoPlayer2,R.raw.shaker,R.raw.dyslexia,LOOP);
        ButtonInfo buttonInfo3 = new ButtonInfo(R.id.ImageView_3,exoPlayer3,R.raw.piano,R.raw.estimate,SINGLE);
        ButtonInfo buttonInfo4 = new ButtonInfo(R.id.ImageView_4,exoPlayer4,R.raw.tappy_hats,R.raw.mnemonics,SINGLE);
        ButtonInfo buttonInfo7 = new ButtonInfo(R.id.ImageView_7,exoPlayer7,R.raw.soft_pads,R.raw.articulation,SINGLE);
*/
        //tp
        ButtonInfo buttonInfo8 = new ButtonInfo(R.id.ImageView_8,exoPlayer8,R.raw.tiny_piano,R.raw.tp_full,SINGLE,LONG,R.id.animationView_tp);
        initPlayButton(buttonInfo8,(LottieAnimationView)findViewById(buttonInfo8.getAnimationViewID()));

        //th
        ButtonInfo buttonInfo2 = new ButtonInfo(R.id.ImageView_2,exoPlayer2,R.raw.tappy_hats,R.raw.th_full,SINGLE,LONG,R.id.animationView_th);
        initPlayButton(buttonInfo2,(LottieAnimationView)findViewById(buttonInfo2.getAnimationViewID()));

        //db
        ButtonInfo buttonInfo1 = new ButtonInfo(R.id.ImageView_1,exoPlayer1,R.raw.drum_break_loop,R.raw.db_full,LOOP,LONG,R.id.animationView_db);
        ButtonInfo buttonInfo7 = new ButtonInfo(R.id.ImageView_7,exoPlayer7,R.raw.drum_break_fast,R.raw.db2,SINGLE,LONG,R.id.animationView_db2);

        initPlayButton(buttonInfo1, (LottieAnimationView)findViewById(buttonInfo1.getAnimationViewID()));
        initPlayButton(buttonInfo7,(LottieAnimationView)findViewById(buttonInfo7.getAnimationViewID()));

        //sp
        ButtonInfo buttonInfo13 = new ButtonInfo(R.id.ImageView_13,exoPlayer13,R.raw.soft_pads,R.raw.sp_full,SINGLE,LONG,R.id.animationView_sp);
        initPlayButton(buttonInfo13,(LottieAnimationView)findViewById(buttonInfo13.getAnimationViewID()));

        //plucked
        ButtonInfo buttonInfo19 = new ButtonInfo(R.id.ImageView_19,exoPlayer19,R.raw.plucked,R.raw.plucked_full,SINGLE,LONG,R.id.animationView_plucked);
        initPlayButton(buttonInfo19,(LottieAnimationView)findViewById(buttonInfo19.getAnimationViewID()));

        //piano high
        ButtonInfo buttonInfo14 = new ButtonInfo(R.id.ImageView_14,exoPlayer14,R.raw.piano_high,R.raw.piano_high_full,SINGLE,LONG,R.id.animationView_piano_high);
        initPlayButton(buttonInfo14,(LottieAnimationView)findViewById(buttonInfo14.getAnimationViewID()));

        //piano low
        ButtonInfo buttonInfo20 = new ButtonInfo(R.id.ImageView_20,exoPlayer20,R.raw.piano_low,R.raw.piano_low_full,SINGLE,LONG,R.id.animationView_piano_low);
        initPlayButton(buttonInfo20,(LottieAnimationView)findViewById(buttonInfo20.getAnimationViewID()));


        //侧滑菜单
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_na);
        navigationView = (NavigationView) findViewById(R.id.nav);
        //View headerView = navigationView.getHeaderView(0);//获取头布局
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.setChecked(true);
                Toast.makeText(PerformActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                if(item.getTitle().toString().equals("编辑模式")){
                    coolMenu.editable = 1;
                }
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

        //圆形菜单
        coolMenu = (CoolMenu) findViewById(R.id.cool);
        list.add("导入工程");
        list.add("导入音源库");
        list.add("导入本地音源");
        list.add("录音");
        adapter = new CoolAdapter(list);
        coolMenu.setOnItemClickListener(new CoolMenu.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(PerformActivity.this, mItemTexts[position], Toast.LENGTH_SHORT).show();
                if(mItemTexts[position].equals("导入音源库")){

                    intent = new Intent(PerformActivity.this,ViewActivity.class);
                    startActivity(intent);
                }
                if(mItemTexts[position].equals("录音")){

                    //子滔看过来！！！这里是跳转接口！！！！！


                }

            }
        });
        coolMenu.setAdapter(adapter);
        coolMenu.setVisibility(View.GONE);
        coolMenu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(!isTouchInsideView(view,motionEvent)){
                    coolMenu.setVisibility(View.GONE);
                    coolMenu.visiable = 0;
                }
                return false;
            }
        });

    }

    class ButtonInfo {
        private int resID;
        private SimpleExoPlayer exoPlayer;
        private int musicID;
        private int mode;
        private int animationID;
        private boolean isPlaying = false;
        private int kind;
        private int animationViewID;

        ButtonInfo(int resID,SimpleExoPlayer exoPlayer,int musicID,int animationID,int mode,int kind,int animationViewID) {
            this.resID = resID;
            this.exoPlayer = exoPlayer;
            this.musicID = musicID;
            this.animationID = animationID;
            this.mode = mode;
            this.kind = kind;
            this.animationViewID = animationViewID;
            //this.isPlaying = isPlaying;
        }

        public void setExoPlayer(SimpleExoPlayer exoPlayer) {
            this.exoPlayer = exoPlayer;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        public void setMusicID(int musicID) {
            this.musicID = musicID;
        }

        public void setAnimationID(int animationID) {
            this.animationID = animationID;
        }
        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

        public void setResID(int resID) {
            this.resID = resID;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public boolean isPlaying() {
            return isPlaying;
        }

        public int getMusicID() {
            return musicID;
        }
        public int getKind(){return kind;}
        public int getAnimationID() {
            return animationID;
        }
        public int getAnimationViewID() {return animationViewID;}
        public int getMode() {
            return mode;
        }

        public int getResID() {
            return resID;
        }

        public SimpleExoPlayer getExoPlayer() {
            return exoPlayer;
        }

    }
    private void initPlayButton(final ButtonInfo buttonInfo,final LottieAnimationView animationView) {
        imageView = findViewById(buttonInfo.getResID());
        //imageView.requestFocus();

        //animationView = findViewById(buttonInfo.getAnimationViewID());
        switch (buttonInfo.getMode()){
            case SINGLE : {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animationView.setAnimation(buttonInfo.getAnimationID());

                        if(buttonInfo.kind==SHORT||buttonInfo.getExoPlayer().getPlaybackState()==Player.STATE_ENDED) {
                            //exoPlayer.setPlayWhenReady(true);
                            Log.d("neww", "onClick: ended");
                            animationView.setVisibility(View.VISIBLE);
                            animationView.playAnimation();
                            singlePlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                        }
                        else if(buttonInfo.isPlaying()) {
                            Log.d("neww", "onClick: "+buttonInfo.getExoPlayer().getPlaybackState());
                            animationView.setVisibility(View.INVISIBLE);
                            buttonInfo.getExoPlayer().setPlayWhenReady(false);
                            buttonInfo.setPlaying(false);
                        }
                        else {
                            singlePlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                            buttonInfo.setPlaying(true);
                            animationView.setVisibility(View.VISIBLE);
                            animationView.loop(false);
                            animationView.playAnimation();

                        }
                    }
                });
            } break;
            case LOOP : {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animationView.setAnimation(buttonInfo.getAnimationID());
                        //animationView.setRepeatCount(4);
                        //animationView.setRepeatMode(LOOP);

                        if(buttonInfo.isPlaying) {
                            buttonInfo.getExoPlayer().setPlayWhenReady(false);
                            buttonInfo.setPlaying(false);
                            animationView.setVisibility(View.INVISIBLE);
                        }
                        else {
                            animationView.setVisibility(View.VISIBLE);
                            animationView.loop(true);
                            animationView.playAnimation();
                            loopPlay(buttonInfo.getExoPlayer(), buttonInfo.getMusicID());
                            buttonInfo.setPlaying(true);
                        }
                    }
                });
            } break;
            default:
        }

        imageView.setLongClickable(true);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(coolMenu.editable == 1){
                    coolMenu.setVisibility(View.VISIBLE);
                    coolMenu.visiable = 1;
                }
                return false;
            }
        });


    }

    private SimpleExoPlayer newPlayer() {
        SimpleExoPlayer exoPlayer;
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory selectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(selectionFactory);
        exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        return exoPlayer;
    }

    private void loopPlay(SimpleExoPlayer exoPlayer, int resID) {
        try {
            DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(resID));
            rawResourceDataSource = new RawResourceDataSource(this);
            rawResourceDataSource.open(dataSpec);
            DataSource.Factory factory = new DataSource.Factory() {
                @Override
                public DataSource createDataSource() {
                    return rawResourceDataSource;
                }
            };

            ExtractorMediaSource mediaSource = new ExtractorMediaSource(rawResourceDataSource.getUri(),
                    factory, new DefaultExtractorsFactory(), null, null);
            LoopingMediaSource loopingMediaSource = new LoopingMediaSource(mediaSource);
            exoPlayer.prepare(loopingMediaSource);
            exoPlayer.addListener(this.eventListener);
            exoPlayer.setPlayWhenReady(true);
        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
            e.printStackTrace();
        }
    }

    private void singlePlay(SimpleExoPlayer exoPlayer, int resID) {
        try {
            DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(resID));
            rawResourceDataSource = new RawResourceDataSource(this);
            rawResourceDataSource.open(dataSpec);
            DataSource.Factory factory = new DataSource.Factory() {
                @Override
                public DataSource createDataSource() {
                    return rawResourceDataSource;
                }
            };

            ExtractorMediaSource mediaSource = new ExtractorMediaSource(rawResourceDataSource.getUri(),
                    factory, new DefaultExtractorsFactory(), null, null);

            exoPlayer.prepare(mediaSource);
            exoPlayer.addListener(this.eventListener);
            exoPlayer.setPlayWhenReady(true);
        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
            e.printStackTrace();
        }
    }
}
