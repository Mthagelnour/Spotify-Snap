package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.type.Song;
import model.parser.hashtable.SongHashTable;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SongsHashTableTest {


    @Test
    public void readSongInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("songs.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Song song = new Song(inputArray,0);

        SongHashTable songHashTable = new SongHashTable();
        JSONArray songJsonArray = song.readSongInfoAsJson();
        JSONArray songNameArray = JsonPath.read(songJsonArray, "$..id");

        String songName = songNameArray.get(0).toString();
        songHashTable.place(songName,song);
        Assertions.assertSame(songHashTable.readAtKey("2HSmyk2qMN8WQjuGhaQgCk").getClass(), song.getClass());

    }
}