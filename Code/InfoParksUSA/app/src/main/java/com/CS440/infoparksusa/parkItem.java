package com.CS440.infoparksusa;

public class parkItem {
    private String parkName;
    private int parkImage;

    public String getParkName() {
        return parkName;
    }

    public int getParkImage() {
        return parkImage;
    }

    public parkItem(String name, int image){
        this.parkName = name;
        this.parkImage = image;

    }
}
