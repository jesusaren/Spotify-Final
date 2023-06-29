package es.ulpgc.spotify.downloader.model;

public class Track {
    private final String artistName;
    private final String name;
    private final String id;
    private final String href;
    private final int durationMs;
    private final boolean explicit;
    public String getArtistName() {
        return artistName;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getHref() {
        return href;
    }
    public int getDurationMs() {
        return durationMs;
    }
    public boolean isExplicit() {
        return explicit;
    }
    public Track(String artistName, String name, String id, String href, int durationMs, boolean explicit) {
        this.artistName = artistName;
        this.name = name;
        this.id = id;
        this.href = href;
        this.durationMs = durationMs;
        this.explicit = explicit;
    }
}
