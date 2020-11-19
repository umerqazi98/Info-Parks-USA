package com.CS440.infoparksusa;

public class parkItem {
    private String parkName;
    private int parkImage;
    private String webAddress;

    public String getWebAddress() {
        return webAddress;
    }

    public String getParkName() {
        return parkName;
    }

    public int getParkImage() {
        return parkImage;
    }

    public parkItem(String name, int image, String web){
        this.parkName = name;
        this.parkImage = image;
        this.webAddress = web;

    }
}
