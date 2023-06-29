package es.ulpgc.spotify.downloader.model;

public class Translator {
    public String insertTrack(Track track){
        String name = track.getName();
        name = name.replaceAll("'", "");
        name = name.replaceAll("\"", "");
        String artistName = track.getArtistName();
        artistName = artistName.replaceAll("'", "");
        artistName = artistName.replaceAll("\"", "");
        String insert_track = "INSERT INTO tracks VALUES ('%s', '%s', '%s', '%s', '%d', '%b') " +
                "ON CONFLICT(id) DO UPDATE SET artists = ?, name = ?, href = ?, " +
                "duration = ?, explicit = ? WHERE id = ?";
        return String.format(insert_track, artistName,
        name,
        track.getId(),
        track.getHref(),
        track.getDurationMs() / 1000,
        track.isExplicit());
    }
    public String insertAlbum(Album album){
        String name = album.getName();
        name = name.replaceAll("'", "");
        name = name.replaceAll("\"", "");
        String artistName = album.getArtistName();
        artistName = artistName.replaceAll("'", "");
        artistName = artistName.replaceAll("\"", "");
        String insert_album = "INSERT INTO albums VALUES ('%s', '%s', '%s', '%s', '%d') " +
                "ON CONFLICT(id) DO UPDATE SET artists = ?, " +
                "name= ?, date = ?, tracks = ? WHERE id = ?";
        return String.format(insert_album, artistName,
        name,
        album.getId(),
        album.getReleaseDate(),
        album.getTotalTracks());
    }
    public String insertArtist(Artist artist){
        String name = artist.getName();
        name = name.replaceAll("'", "");
        name = name.replaceAll("\"", "");
        name = name.replaceAll("´", "");
        String insert_artist = "INSERT INTO artists VALUES ('%s', '%s', '%d', '%d') ON CONFLICT(id)" +
                " DO UPDATE SET name = ?, popularity = ?, followers = ? WHERE id = ?";
        return String.format(insert_artist, name,
        artist.getId(),
        artist.getPopularity(),
        artist.getFollowers());
    }

}

