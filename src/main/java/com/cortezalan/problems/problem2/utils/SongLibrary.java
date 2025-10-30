package com.cortezalan.problems.problem2.utils;

import java.util.ArrayList;
import java.util.List;

public class SongLibrary implements SongService {
    private List<Song> songLibraryList = new ArrayList<>();

    public SongLibrary(List<Song> songLibraryList) {
        this.songLibraryList = songLibraryList;
    }

    public Song searchById(Integer songID) {
        for (Song song : songLibraryList) {
            if (songID == song.getSongID()) {
                return song;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String title) {
        List<Song> searchQueryResults = new ArrayList<>();
        for (Song song : songLibraryList) {
            if (song.getTitle().contains(title)) {
                searchQueryResults.add(song);
            }
        }
        return searchQueryResults;
    }

    public List<Song> searchByAlbum(String album) {
        List<Song> searchQueryResults = new ArrayList<>();
        for (Song song : songLibraryList) {
            if (song.getAlbum().contains(album)) {
                searchQueryResults.add(song);
            }
        }
        return searchQueryResults;
    }
}
