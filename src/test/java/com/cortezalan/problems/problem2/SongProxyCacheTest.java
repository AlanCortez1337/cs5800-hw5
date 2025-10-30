package com.cortezalan.problems.problem2;

import com.cortezalan.problems.problem2.utils.Song;
import com.cortezalan.problems.problem2.utils.SongProxyCache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SongProxyCacheTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private SongProxyCache searchService;

    @BeforeEach
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

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

        searchService = new SongProxyCache(songLibraryList);
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void searchByIDCacheMiss() {
        searchService.searchById(1);

        assertTrue(outContent.toString().contains("Cache Miss"));
    }

    @Test
    public void searchByIDCacheHit() {
        searchService.searchById(1);
        searchService.searchById(1);

        assertTrue(outContent.toString().contains("Cache Hit"));

    }

    @Test
    public void searchByTitleCacheMiss() {
        searchService.searchByTitle("Isn't She Lovely");

        assertTrue(outContent.toString().contains("Cache Miss"));
    }

    @Test
    public void searchByTitleCacheHit() {
        searchService.searchByTitle("New Computers");
        searchService.searchByTitle("New Computers");

        assertTrue(outContent.toString().contains("Hit"));
    }

    @Test
    public void searchByAlbumCacheMiss() {

        searchService.searchByAlbum("Mirage");

        assertTrue(outContent.toString().contains("Cache Miss"));
    }

    @Test
    public void searchByAlbumCacheHit() {
        searchService.searchByAlbum("Girlfriends");
        searchService.searchByAlbum("Girlfriends");

        assertTrue(outContent.toString().contains("Hit"));
    }
}
