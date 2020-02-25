package com.example.androidproject;

public class ModelClass {
    private int imageView;
    private String textView;
    private String textView2;

    public ModelClass(int imageView, String textView, String textView2) {
        this.imageView = imageView;
        this.textView = textView;
        this.textView2 = textView2;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTextView() {
        return textView;
    }

    public String getTextView2() {
        return textView2;
    }
}
