package com.example.csm;

public class AttendanceItems {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public AttendanceItems(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }
    public int getImageResourceatt() {
        return mImageResource;
    }
    public String getText1att() {
        return mText1;
    }
    public String getText2att() {
        return mText2;
    }
}
