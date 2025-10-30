package com.cortezalan.problems.problem2.utils;

public class Song {
    private Integer songID;
    private String title;
    private String artist;
    private String album;
    private Integer duration;

    public Song(Integer songID, String title, String artist, String album, int duration) {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public Integer getSongID() {
        return this.songID;
    }
    public String getTitle() {
        return this.title;
    }
    public String getArtist() {
        return this.artist;
    }
    public String getAlbum() {
        return this.album;
    }
    public Integer getDuration() {
        return this.duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song: " + this.getTitle() + "\n" +
                "Artist: " + this.getArtist() + "\n" +
                "Album: " + this.getAlbum() + "\n" +
                "Duration: ~" + this.getDuration() + "minutes.";
    }
}
