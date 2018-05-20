package com.nekogee.licorice;

import com.google.android.exoplayer2.SimpleExoPlayer;

/**
 * Created by Administrator on 2018/4/11 0011.
 */
public class Trend {
    private int userImage ;
    private String userName ;
    private int cover;
    private String songTitle;
    private String songAuthor ;
    private int musicID;
    private boolean isPlaying = false;
    private SimpleExoPlayer exoPlayer;
    private int image_preview;

    public Trend(int userImage, String userName, int cover, String songTitle , String songAuthor, int musicID){
        this.userImage = userImage ;
        this.userName = userName ;
        this.cover = cover ;
        this.songTitle = songTitle ;
        this.songAuthor = songAuthor;
        this.musicID = musicID ;
    }

    public int getImage_preview() {
        return image_preview;
    }

    public void setImage_preview(int image_preview) {
        this.image_preview = image_preview;
    }

    public SimpleExoPlayer getExoPlayer() {
        return exoPlayer;
    }

    public void setExoPlayer(SimpleExoPlayer exoPlayer) {
        this.exoPlayer = exoPlayer;
    }

    public boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongAuthor() {
        return songAuthor;
    }

    public void setSongAuthor(String songAuthor) {
        this.songAuthor = songAuthor;
    }

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }
}
