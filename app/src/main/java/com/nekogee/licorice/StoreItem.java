package com.nekogee.licorice;

/**
 * Created by hui jie on 2018/5/13.
 */

public class StoreItem {
    private int coverID = R.drawable.pic_2;
    private String name ="nekogee";
    private String songNumber = "12";

    StoreItem(int coverID, String name, String songNumber) {
        this.coverID = coverID;
        this.name = name;
        this.songNumber = songNumber;
    }

    public int getCoverID() {
        return coverID;
    }

    public void setCoverID(int coverID) {
        this.coverID = coverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongNumber() {
        return songNumber;
    }

    public void setSongNumber(String songNumber) {
        this.songNumber = songNumber;
    }
}
