package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.Album;
import model.parser.AlbumFormatter;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumFormatterTest {


    @Test
    public void formatAlbumTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");


        Album album = new Album(testArray,0);
        AlbumFormatter albumFormatter = new AlbumFormatter(album);
        String formattedArtist = albumFormatter.formatAlbum();

        String expected = """

                Album Name: Certified Lover Boy
                Album Id: 3SpBlxme9WbeQdI9kx7KAV
                Uri: spotify:album:3SpBlxme9WbeQdI9kx7KAV
                Release Date: 2021-09-03
                Total Tracks: 21""";
        Assertions.assertEquals(expected,formattedArtist);
    }

}