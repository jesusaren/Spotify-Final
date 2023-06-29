package es.ulpgc.spotify.downloader.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.ulpgc.spotify.downloader.model.Album;
import es.ulpgc.spotify.downloader.model.Artist;
import es.ulpgc.spotify.downloader.model.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GetData {
    public List<Album> getAlbums(String artistId) throws Exception {
        List<Album> albums = new ArrayList<>();
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/artists/" + artistId + "/albums", Map.of());
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(json, JsonObject.class);
        JsonArray items = object.getAsJsonArray("items");
        for (JsonElement item : items) {
            String name = item.getAsJsonObject().get("name").getAsString();
            String id = item.getAsJsonObject().get("id").getAsString();
            String releaseDate = item.getAsJsonObject().get("release_date").getAsString();
            int totalTracks = item.getAsJsonObject().get("total_tracks").getAsInt();
            JsonArray artists = item.getAsJsonObject().get("artists").getAsJsonArray();
            String artistsName = getArtistsName(artists);
            Album album = new Album(artistsName, name, id, releaseDate, totalTracks);
            albums.add(album);
        }
        return albums;
    }
    public List<Track> getTracks(String albumId) throws Exception {
        List<Track> tracks = new ArrayList<>();
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/albums/" + albumId + "/tracks", Map.of());
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(json, JsonObject.class);
        JsonArray items = object.getAsJsonArray("items");
        for (JsonElement item : items) {
            String name = item.getAsJsonObject().get("name").getAsString();
            String id = item.getAsJsonObject().get("id").getAsString();
            String href = item.getAsJsonObject().get("href").getAsString();
            int durationMs = item.getAsJsonObject().get("duration_ms").getAsInt();
            boolean explicit = item.getAsJsonObject().get("explicit").getAsBoolean();
            JsonArray artists = item.getAsJsonObject().get("artists").getAsJsonArray();
            String artistsName = getArtistsName(artists);
            Track track = new Track(artistsName, name, id, href, durationMs, explicit);
            tracks.add(track);
        }
        return tracks;
    }

    private String getArtistsName(JsonArray artists) {
        String artistsName = "";
        for (JsonElement artist : artists) {
            artistsName += artist.getAsJsonObject().get("name").getAsString();
            int size = artists.size();
            if (size > 1) {
                if (artist != artists.get(size - 1)) {
                    artistsName += ", ";
                }
            }
        }
        return artistsName;
    }

    public Artist getArtists(String artistId) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get("/artists/" + artistId, Map.of());
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(json, JsonObject.class);
        String name = object.getAsJsonObject().get("name").getAsString();
        int popularity = object.getAsJsonObject().get("popularity").getAsInt();
        int followers = object.getAsJsonObject().get("followers").getAsJsonObject().get("total").getAsInt();
        return new Artist(name, artistId, popularity, followers);
    }
}