package es.ulpgc.spotify.downloader.model;

public class Artist {
    private final String name;
    private final String id;
    private final int popularity;
    private final int followers;
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getPopularity() {
        return popularity;
    }
    public int getFollowers() {
        return followers;
    }
    public Artist(String name, String artistId, int popularity, int followers) {
        this.name = name;
        this.id = artistId;
        this.popularity= popularity;
        this.followers = followers;
    }
}

