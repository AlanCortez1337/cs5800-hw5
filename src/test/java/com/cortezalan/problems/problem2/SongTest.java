package com.cortezalan.problems.problem2;

import com.cortezalan.problems.problem2.utils.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    private Song song;

    @BeforeEach
    protected void setUp() throws Exception {
        song = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);
    }

    @Test
    public void initializeSongTest() {
        Song newSong = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);

        assertEquals(newSong.toString(), this.song.toString());
    }

    @Test
    public void updateSongTitle() {
        Song newSong = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);

        newSong.setTitle("Serendipity");

        assertEquals("Serendipity", newSong.getTitle());
    }

    @Test
    public void updateSongArtist() {
        Song newSong = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);

        newSong.setArtist("Laufey");

        assertEquals("Laufey", newSong.getArtist());
    }

    @Test
    public void updateSongAlbum() {
        Song newSong = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);

        newSong.setAlbum("Bewitched");

        assertEquals("Bewitched", newSong.getAlbum());
    }

    @Test
    public void updateSongDuration() {
        Song newSong = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);

        newSong.setDuration(3);

        assertEquals(3, newSong.getDuration());
    }
}
