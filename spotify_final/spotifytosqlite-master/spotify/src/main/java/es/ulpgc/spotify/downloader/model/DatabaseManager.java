package es.ulpgc.spotify.downloader.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseManager{
    private final Translator translator;
    public DatabaseManager() {
        this.translator = new Translator();
    }
    public Statement init() throws SQLException {
        String dbPath = "C:/Users/jesus/Downloads/spotifytosqlite-master (10000)/spotifytosqlite-master/spotify/src/main/spotify.db";
        Connection connection = connect(dbPath);
        Statement statement = connection.createStatement();
        createTable(statement);
        return statement;
    }
    private Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS artists (" +
                "name TEXT," +
                "id TEXT PRIMARY KEY," +
                "popularity NUMBER,"+
                "followers NUMBER" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS albums (" +
                "artists TEXT," +
                "name TEXT," +
                "id TEXT PRIMARY KEY," +
                "date TEXT,"+
                "tracks NUMBER" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS tracks (" +
                "artists TEXT," +
                "name TEXT," +
                "id TEXT PRIMARY KEY," +
                "href TEXT,"+
                "duration NUMBER,"+
                "explicit BOOLEAN" +
                ");");
    }
    public void insertArtists(Statement statement, List<Artist> artists) throws SQLException {
        for (Artist artist : artists) {
                statement.execute(translator.insertArtist(artist));

        }
    }
    public void insertAlbums(Statement statement, List<Album> albums) throws SQLException{
        for (Album album : albums) {
                statement.execute(translator.insertAlbum(album));
        }
    }
    public void insertTracks(Statement statement, List<Track> tracks) throws SQLException{
        for (Track track : tracks) {
                statement.execute(translator.insertTrack(track));
        }
    }
}


