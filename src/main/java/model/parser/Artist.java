package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Artist extends Parser {
    private final String name;
    private final String id;
    private final String uri;
    private final String externalURL;
    private final String followerCount;

    public Artist(JSONArray inputArray) {
        super(inputArray);
        this.name = parseInfo("name");
        this.id = parseInfo("id");

        this.uri = parseInfo("uri");
        this.externalURL = parseInfo("spotify");
        this.followerCount = parseInfo("total");
    }

    public JSONArray readArtistInfoAsJson() {

        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " + "\"%s\",\"url\": \"%s\" ,\"total\": \"%s\"}]}",name,id,uri,externalURL,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}