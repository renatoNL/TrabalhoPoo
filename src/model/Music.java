package model;

public class Music {

    private int musicID;
    private String songName;
    private String artist;
    private String genre;
    private String album;

    public Music(int musicID, String songName, String artist, String genre, String album){
        this.musicID = musicID;
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }
    public Music(){

    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    // MusicaID nao deve ter metodo GET

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artista) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
