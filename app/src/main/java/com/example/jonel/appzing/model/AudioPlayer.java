package com.example.jonel.appzing.model;

/**
 * Created by jonel on 10/12/2017.
 */

public class AudioPlayer {
    private String path;
    private String title;
    private String tenCS;
    private String album;

    public AudioPlayer(String path, String title, String tenCS, String album) {
        this.path = path;
        this.title = title;
        this.tenCS = tenCS;
        this.album = album;

    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getTenCS() {
        return tenCS;
    }

    public String getAlbum() {
        return album;
    }

}
