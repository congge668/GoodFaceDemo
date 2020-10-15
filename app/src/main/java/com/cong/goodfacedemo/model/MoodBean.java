package com.cong.goodfacedemo.model;

public class MoodBean {
    private String imageUrl;
    private String content;

    public MoodBean(String imageUrl, String content) {
        this.imageUrl = imageUrl;
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
