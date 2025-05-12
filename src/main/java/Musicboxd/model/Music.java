package Musicboxd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

//@Getter
//@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musicID;

    private String songName;
    private String artist;
    private String genre;
    private String album;

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
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
