package Controller;

import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.parser.hashtable.SongHashTable;
import model.requests.ArtistAlbums;
import model.requests.ArtistErrorHandler;
import model.requests.ArtistID;
import model.requests.SongsRequester;
import model.type.Artist;
import net.minidev.json.JSONArray;

public class ModelController {

    public Artist searchForArtist(){

        ArtistID artistID = new ArtistID();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID();
        ArtistErrorHandler artistErrorHandler = new ArtistErrorHandler(artistSearchResultJsonArray);
        return artistErrorHandler.checkIfArtistIsvalid();
    }


    public AlbumHashTable searchForAlbums(Artist resultArtist){

        AlbumHashTable albumHashTable = new AlbumHashTable();
        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(resultArtist));

        hashTableBuilder.buildHashTable(albumHashTable);
        albumHashTable.sortHashMapIntoArrayList();
        return albumHashTable;
    }


    public SongHashTable createSongHashTable(AlbumHashTable albumHashTable){
        SongsRequester songsRequester = new SongsRequester();
        return songsRequester.requestSongs(albumHashTable);
    }
}