package com.cortezalan.problems.problem2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongProxyCache implements SongService {
    private List<Song> songLibraryList = new ArrayList<>();
    private Song[] songLibraryCache = new Song[2];

    public SongProxyCache(List<Song> songLibraryList) {
        this.songLibraryList = songLibraryList;
    }

    private void addSongToCache(Song song) {
        for (Integer i = 0; i < songLibraryCache.length; i++) {
            if (songLibraryCache[i] == null) {
                songLibraryCache[i] = song;
                return;
            }
        }

        Random random = new Random();

        Integer newRandomSlotToReplace = random.nextInt(2);

        songLibraryCache[newRandomSlotToReplace] = song;
    }

    public Song searchById(Integer songID) {
        System.out.println("Searching by id: " + songID);

        if (songLibraryCache.length > 0) {
            for (Song song : songLibraryCache) {
                if (song != null && songID == song.getSongID()) {
                    System.out.println("Cache Hit, found song with id " + songID + ": \n" + song.toString());
                    return song;
                }
            }
        }

        System.out.println("Cache Miss");

        for (Song song : songLibraryList) {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            if (songID == song.getSongID()) {
                addSongToCache(song);
                return song;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String title) {
        System.out.println("Searching by title: " + title);

        List<Song> searchQueryResults = new ArrayList<>();

        for (Song song : songLibraryCache) {
            if (song != null && song.getTitle().contains(title)) {
                System.out.println("Cache Hit, found song with title " + title + ": \n" + song.toString());
                searchQueryResults.add(song);
            }
        }

        if (searchQueryResults.size() > 0) {
            return searchQueryResults;
        }

        System.out.println("Cache Miss");

        for (Song song : songLibraryList) {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            if (song.getTitle().contains(title)) {
                addSongToCache(song);
                searchQueryResults.add(song);
            }
        }
        return searchQueryResults;
    }

    public List<Song> searchByAlbum(String album) {
        System.out.println("Searching by album: " + album);

        List<Song> searchQueryResults = new ArrayList<>();

        for (Song song : songLibraryCache) {
            if (song != null && song.getAlbum().contains(album)) {
                System.out.println("Cache Hit, found song with album " + album + ": \n" + song.toString());
                searchQueryResults.add(song);
            }
        }

        if (searchQueryResults.size() > 0) {
            return searchQueryResults;
        }

        System.out.println("Cache Miss");

        for (Song song : songLibraryList) {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            if (song.getAlbum().contains(album)) {
                addSongToCache(song);
                searchQueryResults.add(song);
            }
        }
        return searchQueryResults;
    }
}
