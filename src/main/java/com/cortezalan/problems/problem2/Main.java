package com.cortezalan.problems.problem2;

import com.cortezalan.problems.problem2.utils.Song;
import com.cortezalan.problems.problem2.utils.SongProxyCache;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Song> songLibraryList = new ArrayList<>();

        Song newComputers = new Song(1, "New Computers", "Girlfriends", "Girlfriends", 2);
        Song isntSheLovely = new Song(2, "Isn't She Lovely", "Tom Misch", "Geography", 1);
        Song luvSic = new Song(3, "Luv  (sic)", "Nujabes", "Luv(sic) Hexalogy", 5);
        Song theRedFox = new Song(4, "The Red Fox", "Plini", "Mirage", 6);
        Song serendipity = new Song(5, "Serendipity", "Laufey", "Bewitched", 3);

        songLibraryList.add(newComputers);
        songLibraryList.add(isntSheLovely);
        songLibraryList.add(luvSic);
        songLibraryList.add(theRedFox);
        songLibraryList.add(serendipity);

        SongProxyCache searchService = new SongProxyCache(songLibraryList);

        searchService.searchById(1);
        searchService.searchById(2);
        searchService.searchById(2);
        searchService.searchById(2);
    }
}
