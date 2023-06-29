package es.ulpgc.spotify.downloader.model;

public class Album {
        private final String artistName;
        private final String name;
        private final String id;
        private final String releaseDate;
        private final int totalTracks;
    public String getArtistName() {
        return artistName;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public int getTotalTracks() {
        return totalTracks;
    }
    public Album(String artistName, String name, String id, String releaseDate, int totalTracks) {
            this.artistName = artistName;
            this.name = name;
            this.id = id;
            this.releaseDate = releaseDate;
            this.totalTracks = totalTracks;
        }
    }

