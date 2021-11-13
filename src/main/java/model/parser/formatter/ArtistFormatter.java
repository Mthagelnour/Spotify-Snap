package model.parser.formatter;

import model.parser.type.Artist;
import model.parser.Parser;

public class ArtistFormatter extends Parser implements Formatter {


    public ArtistFormatter(Artist artist) {
        super(artist.readArtistInfoAsJson());
    }

    public String format() {

        String name = parseInfo("name");
        String id = parseInfo("id");
        String uri = parseInfo("uri");

        String url = parseInfo("url");
        String total = parseInfo("total");

        return String.format("\nArtist Name: %s\nArtist Id: %s\nExternal URL: %s\nUri: %s\nFollower Count: %s",
                name,id,url,uri,total);
    }
}