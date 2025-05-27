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
    private long playlistID;
    private List<String> userPlaylist;
    private String playlistName;

}