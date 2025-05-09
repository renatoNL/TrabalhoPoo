package Musicboxd.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistID;

    @ElementCollection
    private List<String> userPlaylist;
    private String playlistName;

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public List<String> getUserPlaylist() {
        return userPlaylist;
    }

    public void setUserPlaylist(List<String> userPlaylist) {
        this.userPlaylist = userPlaylist;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

}