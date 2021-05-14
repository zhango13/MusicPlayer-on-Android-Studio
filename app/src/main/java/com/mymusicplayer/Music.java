package com.mymusicplayer;

public class Music {
    private String name;
    private String singer;
    private String lyric;
    private int song;

    public Music(String name, String singer, String lyric, int song) {
        this.name = name;
        this.singer = singer;
        this.lyric = lyric;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyrics) {
        this.lyric = lyrics;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
